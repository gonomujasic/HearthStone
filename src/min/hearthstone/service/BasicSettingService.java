package min.hearthstone.service;

import java.io.IOException;
import java.util.Set;

import javax.websocket.Session;

import min.hearthstone.game.GameInfo;

public class BasicSettingService implements Service {

	@Override
	public void execute(GameInfo gameInfo, String message, Set<Session> clients) {
		
		for (Session client : clients) {
			try {
				// 첫 세팅 정보 상세사항 정해야함
				client.getBasicRemote().sendText("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}
