package min.hearthstone.service;

import java.util.Set;

import javax.websocket.Session;

import min.hearthstone.game.GameInfo;

public interface Service {

	public void execute(GameInfo gameInfo,String message, Set<Session> clients);
	
}
