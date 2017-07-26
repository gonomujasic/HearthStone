package min.hearthstone.service;

import java.util.Set;

import javax.websocket.Session;

import min.hearthstone.card.minion.MinionCardImpl;
import min.hearthstone.game.GameInfo;

public class AttackDecorator extends ServiceDecorator implements Service {

	@Override
	public void execute(GameInfo gameInfo, String message, Set<Session> clients) {

		//공격전에 확인해야 할 것들
		int minionNumberPO = gameInfo.getPOSideMinion().size();
		int minionNumberPT = gameInfo.getPTSideMinion().size();
		
		for(int i = 0; i<minionNumberPO;i++){
		MinionCardImpl minionCardImpl = (MinionCardImpl) gameInfo.getPOSideMinion().get(i);
		
		}
		target.execute(gameInfo, message, clients);
		
		//공격 후에 확인해야 할 것들
		
	}

}
