package min.hearthstone.game;

public class GameInfoFactory {

	private static class GameInfoSingleton {
		
		//일단 하나만 만들자.
		private static final GameInfo GAMEINFO = new GameInfo();

	}

	public static GameInfo getGameInfo() {
		return GameInfoSingleton.GAMEINFO;
	}


}
