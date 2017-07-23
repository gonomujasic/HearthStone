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

@ServerEndpoint("/controller")
public class Contoller {

	private Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {

		GameInfo gameInfo = GameInfoFactory.getGameInfo();

		if (gameInfo.getPlayerOne().getSessionID() == session.getId() && gameInfo.getTernNumber() % 2 == 0) {
			// 플레이어원의 턴
			if (message.startsWith("!")) {
				int ternNum = gameInfo.getTernNumber();
				gameInfo.setTernNumber(ternNum++);
			}

		} else if (gameInfo.getPlayerTwo().getSessionID() == session.getId() && gameInfo.getTernNumber() % 2 != 0) {
			// 플레이어투의 턴
			if (message.startsWith("!")) {
				int ternNum = gameInfo.getTernNumber();
				gameInfo.setTernNumber(ternNum++);
			}

		} else {
			for (Session client : clients) {
				client.getBasicRemote().sendText("");
			}
			// 명령을 내릴 수 있는 턴이 아님
		}

		// 짝수면 playerOne가, 홀수면 playerTwo가 플레이 가능

		// 메시지 형식 정리
		// ! 턴 넘김, @ 일반 공격, # 특수 공격, $ 스펠
		// mox 전장에 나와있는 플레이어원의 x번째 하수인, mtx 플레이어투의 x번째 하수인, po 플레이어원 영웅, pt
		// 플레이어투 영웅
		// ao 플레이어원 전장 전체 하수인, aop 플레이어원 전장 전체 하수인과 영웅
		// at 플레이어투 전장 전체 하수인, atp 플레이어투 전장 전체 하수인과 영웅
		// 예시
		// @mo1:mt2 하수인 mo의 1번 하수인이 mt의 2번 하수인 공격, @po:mt2 playerOne이 mt2에게 일반
		// 공격
		// #mo1:mo2 하수인 mo1이 mo2에게 특수능력, @po:mt7 플레이어원이 mt7에게 특수 공격
		// $po:mo1 playerOne이 m1에게 스펠, $pt:ao playerTwo가 playerOne의 전체에 스펠

	}

	@OnOpen // 클라이언트가 접속할 때
	public void onOpen(Session session) {
		// 둘만 접속한다는 전제 필요
		GameInfo gameInfo = GameInfoFactory.getGameInfo();
		if (clients.isEmpty()) {

			Player player = new Player(session.getId(), new Jaina()); //캐릭터는 일단 Jaina로 고정
			CardDispenser.getCardDispenser().cardDispenser(player);//플레이어 덱 랜덤으로 카드 넣기
			gameInfo.setPlayerOne(player);
			gameInfo.setCardOwnedByPO(player.getFirstDeck());
			
			
		} else {
			
			Player player = new Player(session.getId(), new Jaina());
			CardDispenser.getCardDispenser().cardDispenser(player);//캐릭터는 일단 Jaina로 고정
			gameInfo.setPlayerTwo(player);
			gameInfo.setCardOwnedByPT(player.getFirstDeck());
		}

		clients.add(session);//세션셋에 집어 넣기
			System.out.println("일단 연결은 되는지?");
/*		for (Session client : clients) {//자신한테 세션아이디 보내기                    onopen은 데이터는 전송 못하네.
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
