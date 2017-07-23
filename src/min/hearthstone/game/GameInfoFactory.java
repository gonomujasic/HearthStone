package min.hearthstone.game;

public class GameInfoFactory {

	private static class GameInfoSingleton {
		
		private static GameInfo gameInfo = new GameInfo();

	}

	public static GameInfo getGameInfo() {
		return GameInfoSingleton.gameInfo;
	}


}
