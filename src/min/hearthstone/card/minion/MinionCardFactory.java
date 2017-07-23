package min.hearthstone.card.minion;

public class MinionCardFactory {

	private static class MinionCardFactorySingleton {

		private static MinionCardFactory minionCardFactory = new MinionCardFactory();

	}

	public static MinionCardFactory getMinionCardFactory() {

		return MinionCardFactorySingleton.minionCardFactory;

	}

	// 다른 방법 없나??...
	public MinionCard getMinionCard(MinionCardEnum minionCardEnum) {

		/*
		 * if(MinionCardEnum.M_FLAME_OF_AZZINOTH.equals(minionCardEnum)){ return
		 * new FlameOfAzzinoth(); } else
		 * if(MinionCardEnum.M_ILIDAN_STORMRAGE.equals(minionCardEnum)){ return
		 * new IlidanStormrage(); } else
		 * if(MinionCardEnum.M_MIRROR_IMAGE.equals(minionCardEnum)){ return new
		 * MirrorImage(); }
		 */

		// 동적 클래스 로딩할 수 있는 듯

		MinionCard card = null;
		String rawStr = minionCardEnum.getName();
		String[] splitedRawStr = rawStr.split("_");
		String className = "";

		for (int i = 1; i < splitedRawStr.length; i++) {
			className += splitedRawStr;
		}

		String str = "min.hearthstone.card.minion";
		str += className;

		try {
			card = (MinionCard) Class.forName(str).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return card;
	}

}
