package min.hearthstone.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import min.hearthstone.character.Jaina;
import min.hearthstone.game.GameInfo;
import min.hearthstone.game.GameInfoFactory;
import min.hearthstone.player.CardDispenser;
import min.hearthstone.player.Player;
import min.hearthstone.service.DecoratorEnum;
import min.hearthstone.service.DecoratorFactory;
import min.hearthstone.service.Service;
import min.hearthstone.service.ServiceFactory;
import min.hearthstone.service.TernOverDecorator;

@ServerEndpoint("/controller")
public class Contoller {

	private Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {

		// 짝수면 playerOne가, 홀수면 playerTwo가 플레이 가능

		// 메시지 형식 정리
		// ~ 첫 접속, ! 턴 넘김, @ 영웅 일반 공격, # 영웅 특수 능력, $ 스펠, % 무기,
		//^ 하수인 카드 내기, & 하수인 일반 공격, * 하수인 특수 능력, - 카드 뽑기  
		// mox 전장에 나와있는 플레이어원의 x번째 하수인, mtx 플레이어투의 x번째 하수인, po 플레이어원 영웅, pt 플레이어투 영웅
		// ao 플레이어원 전장 전체 하수인, aop 플레이어원 전장 전체 하수인과 영웅
		// at 플레이어투 전장 전체 하수인, atp 플레이어투 전장 전체 하수인과 영웅
		// ac 모든 캐릭터, none 대상 없음
		// 예시
		// !po 플레이어원이 턴 종료
		// @po:mt3 플레이어원이 mt3일반공격
		// @po:pt 플레이어원이 플레이어2 일반공격
		// #po:mt3 플레이어원이 mt3에 특수능력
		// $Arcane_Explosion=po:at 플레이어원이 플레이어투에게 스펠
		// $Mirror_image=po:none 플레이어원이 플레이어투와 그 하수인 모두에게 스펠
		// $po:ac 플레이어원이 모든 캐릭터에게 스펠
		
		GameInfo gameInfo = GameInfoFactory.getGameInfo();
		Service service = ServiceFactory.getServiceFactory().getService(message);
		service.execute(gameInfo, message,clients);
		if(service.getClass().getSimpleName().substring(0, 4).equals("Basic")){//처음 세팅
			//셋팅된 값을 보내야 함. 어케 해야 하나..
			//손안에 든 카드 정보 po,pt꺼, 남은 카드 개수를 보내야 함. 영웅 정보,  
			service.execute(gameInfo, message,clients);
		} else if(service.getClass().getSimpleName().substring(0, 4).equals("TernO")){
			
			Service decoratedTernOver = new TernOverDecorator(service);
			decoratedTernOver.execute(gameInfo, message, clients);
		}
		//서비스 종류에 따라 
		
		
		
		



	}

	@OnOpen // 클라이언트가 접속할 때
	public void onOpen(Session session) {
		// 둘만 접속한다는 전제 필요
		GameInfo gameInfo = GameInfoFactory.getGameInfo();//일단 한 판만..?
		if (clients.isEmpty()) {

			Player player = new Player(session.getId(), new Jaina()); //캐릭터는 일단 Jaina로 고정
			CardDispenser.getCardDispenser().cardDeckDispenser(player);//플레이어 덱 랜덤으로 카드 넣기
			gameInfo.setPlayerOne(player);//게임정보에 플레이어원 셋팅
			gameInfo.setCardOwnedByPO(player.getFirstDeck());//게임정보에 플레이어원 덱 채움.
			CardDispenser.getCardDispenser().handCardDispenser(player, gameInfo);//플레이어 초반 손에 든 카드 세팅.
			
		} else {
			
			Player player = new Player(session.getId(), new Jaina());
			CardDispenser.getCardDispenser().cardDeckDispenser(player);//캐릭터는 일단 Jaina로 고정
			gameInfo.setPlayerTwo(player);
			gameInfo.setCardOwnedByPT(player.getFirstDeck());
			CardDispenser.getCardDispenser().handCardDispenser(player, gameInfo);
			
		}

		clients.add(session);//세션셋에 집어 넣기
			System.out.println("일단 연결은 되는지?");
/*		for (Session client : clients) {//자신한테 세션아이디 보내기                    onopen은 데이터는 전송하지 못하네.
			if (client.equals(session)) {
				try {
					client.getBasicRemote().sendText(session.getId());
					System.out.println("메시지는 보냈는지? " +session.getId());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}*/
	}

	@OnClose // 클라이언트가 접속 끊을 때
	public void onClose(Session session) {

	}

}
