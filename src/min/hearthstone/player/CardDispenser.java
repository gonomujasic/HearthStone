package min.hearthstone.player;

import java.util.ArrayList;

import min.hearthstone.card.Card;
import min.hearthstone.card.minion.MinionCardEnum;
import min.hearthstone.card.minion.MinionCardFactory;
import min.hearthstone.card.spell.SpellCardEnum;
import min.hearthstone.card.spell.SpellCardFactory;
import min.hearthstone.card.weapon.WeaponCardEnum;
import min.hearthstone.card.weapon.WeaponCardFactory;
import min.hearthstone.game.GameInfo;

public class CardDispenser {

	private static class CardDispenserSingleton {

		private static CardDispenser cardDispenser = new CardDispenser();
	}

	public static CardDispenser getCardDispenser() {
		return CardDispenserSingleton.cardDispenser;
	}

	// 카드 임의로 플레이어 덱에 집어 넣기
	public void cardDeckDispenser(Player player) {

		// 이넘들에서 String으로 뽑아오기
		ArrayList<String> cards = enumToString();

		// 랜덤하게 카드 뽑기
		int randomNumber;
		ArrayList<Card> cardList = player.getFirstDeck();
		for (int i = 0; i < 30; i++) {

			randomNumber = (int) ((cards.size() - 1) * Math.random());

			// 스트링을 다시 이넘으로 바꿔야 함... 복잡... 일단 구현은 하자..
			try {
				// String타입의 ArrayList에서 랜덤번호로 하나 뽑아서 그걸로 미니언이넘값을 얻는다.
				// 그 값으로 팩토리에서 미니언 객체를 새로 생성해서 그걸 덱에 집어 넣는다.
				// 이 작업을 각 이넘타입마다 해줘야 함. valueOf 메서드는 널포인트 에러 뜨므로 각각 try Catch
				cardList.add(
						(Card) MinionCardFactory.getMinionCard(MinionCardEnum.getConstance(cards.get(randomNumber))));
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				cardList.add(
						(Card) SpellCardFactory.getSpellMap().get(SpellCardEnum.getConstance(cards.get(randomNumber))));
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				cardList.add((Card) WeaponCardFactory.getWeaponCardMap()
						.get(WeaponCardEnum.getConstance(cards.get(randomNumber))));
			} catch (NullPointerException e) {
				// TODO: handle exception
			}

		}
	}

	// Enum타입을 스트링으로 바꾸는 메서드
	public ArrayList<String> enumToString() {
		ArrayList<String> cards = new ArrayList<String>();

		for (MinionCardEnum minionCardEnum : MinionCardEnum.values()) {
			cards.add(minionCardEnum.getName());
		}
		;
		for (SpellCardEnum spellCardEnum : SpellCardEnum.values()) {
			cards.add(spellCardEnum.getName());
		}
		;
		for (WeaponCardEnum weaponCardEnum : WeaponCardEnum.values()) {
			cards.add(weaponCardEnum.getName());
		}
		;
		return cards;
	}

	// 플레이어의 덱에서 게임실행에 필요한 카드를 랜덤으로 배분하는 메서드
	public void handCardDispenser(Player player, GameInfo gameInfo) {

		// 이미 뽑힌 카드는 덱에 없어야 함.
		// 1. 배열에 0부터 29까지 넣어서 배열을 섞어서 그 순서대로 추출
		// 배열을 섞는 메서드를 하나 만들어야 함. 이게 더 복잡할듯.
		// 2. 덱에서 뽑은걸 지우고 그 안에서 다시 랜덤 추출
		// 덱에서 가져와서 랜덤으로 추출 후 하나씩 지워야 함. 일단 3장은 먼저 추출. 플레이어2에게는 코인 카드 줘야 함.

		// 아래에 플레이어 구분이 많으므로 연산을 덜하기 위해 미리 구분
		String playerWhoes = "";
		if (player.getSessionID() == gameInfo.getPlayerOne().getSessionID()) {
			playerWhoes = "playerOne";
		} else {
			playerWhoes = "playerTwo";
		}

		// 플레이어 소유 카드에서 받아오기
		ArrayList<Card> cardOwned = null;
		if (playerWhoes.equals("playerOne")) {
			cardOwned = gameInfo.getCardOwnedByPO();
		} else {
			cardOwned = gameInfo.getCardOwnedByPT();
		}
		
		//플레이어 게임 첫 카드 분배
		ArrayList<Card> cardInHandOfPO = gameInfo.getCardInHandOfPO();
		ArrayList<Card> cardInHandOfPT = gameInfo.getCardInHandOfPT();
		int randomNumber = 0;
		if (playerWhoes.equals("playerOne")) { //플레이어원 손에 든 카드 분배
			for (int i = 0; i < 3; i++) {
				randomNumber = (int) Math.random() * cardOwned.size();
				cardInHandOfPO.add(cardOwned.get(randomNumber));
				cardOwned.remove(randomNumber);
			}
		} else {
			for (int i = 0; i < 4; i++) {//플레이어투 손에 든 카드 분배
				randomNumber = (int) Math.random() * cardOwned.size();
				cardInHandOfPT.add(cardOwned.get(randomNumber));
				cardOwned.remove(randomNumber);
			}
			// 플레이어 투에게 코인카드 더 넣어 주기.
			cardInHandOfPT.add((Card) SpellCardFactory.getSpellMap().get(SpellCardEnum.S_COIN));
		}
	}
}
