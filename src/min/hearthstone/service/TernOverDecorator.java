package min.hearthstone.service;

import java.util.Set;

import javax.websocket.Session;

import min.hearthstone.game.GameInfo;

public class TernOverDecorator extends ServiceDecorator {

	public TernOverDecorator(Service service) {
		super.target = service;
	}

	@Override
	public void execute(GameInfo gameInfo, String message, Set<Session> clients) {
		
		target.execute(gameInfo, message,clients);

	}

}
