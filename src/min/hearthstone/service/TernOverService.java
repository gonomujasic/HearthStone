package min.hearthstone.service;

import java.io.IOException;
import java.util.Set;

import javax.websocket.Session;

import min.hearthstone.game.GameInfo;

public class TernOverService implements Service {

	@Override
	public void execute(GameInfo gameInfo, String message, Set<Session> clients) {

		String str = message.substring(1, 2);

		if (str.equals("po") && gameInfo.getTernNumber() % 2 == 0) {
			// 플레이어원의 턴

			int ternNum = gameInfo.getTernNumber();
			gameInfo.setTernNumber(ternNum++);

		} else if (str.equals("pt") && gameInfo.getTernNumber() % 2 != 0) {
			// 플레이어투의 턴

			int ternNum = gameInfo.getTernNumber();
			gameInfo.setTernNumber(ternNum++);

		} else {
			try {
				// 명령을 내릴 수 있는 턴이 아님
				for (Session client : clients) {

					client.getBasicRemote().sendText(",");

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
