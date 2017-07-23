package min.hearthstone.player;

import java.util.ArrayList;

import min.hearthstone.card.Card;
import min.hearthstone.card.minion.MinionCardEnum;
import min.hearthstone.card.minion.MinionCardFactory;
import min.hearthstone.card.spell.SpellCardEnum;
import min.hearthstone.card.spell.SpellCardFactory;
import min.hearthstone.card.weapon.WeaponCardEnum;
import min.hearthstone.card.weapon.WeaponCardFactory;

public class CardDispenser {
	
	private static class CardDispenserSingleton{
		
		private static CardDispenser cardDispenser = new CardDispenser();
	}
	
	public static CardDispenser getCardDispenser(){
		return CardDispenserSingleton.cardDispenser;
	}

	public void cardDispenser(Player player) {//카드 임의로 플레이어 덱에 집어 넣기 

		//이넘들에서 String으로 뽑아오기
		ArrayList<String> cards = enumToString();
		
		//랜덤하게 카드 뽑기
		int randomNumber;
		ArrayList<Card> cardList = player.getFirstDeck();
		for(int i = 0; i<30;i++){
			
			randomNumber = (int) ((cards.size()-1)*Math.random()); 
			
			//스트링을 다시 이넘으로 바꿔야 함... 복잡... 일단 구현은 하자..
			try {
				//String타입의 ArrayList에서 랜덤번호로 하나 뽑아서 그걸로 미니언이넘값을 얻는다.
				//그 값으로 팩토리에서 미니언 객체를 새로 생성해서 그걸 덱에 집어 넣는다. 
				//이 작업을 각 이넘타입마다 해줘야 함. valueOf 메서드는 널포인트 에러 뜨므로 각각 try Catch
				cardList.add(
				(Card) MinionCardFactory.getMinionCardFactory()
				.getMinionCard(MinionCardEnum.getConstance(cards.get(randomNumber))));
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
				cardList.add(
				(Card) WeaponCardFactory.getWeaponCardMap().get(WeaponCardEnum.getConstance(cards.get(randomNumber))));
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			
		}
	}
	
	public ArrayList<String> enumToString(){
		ArrayList<String> cards = new ArrayList<String>();
		
		for(MinionCardEnum minionCardEnum :MinionCardEnum.values()){
			cards.add(minionCardEnum.getName());
		};
		for(SpellCardEnum spellCardEnum :SpellCardEnum.values()){
			cards.add(spellCardEnum.getName());
		};
		for(WeaponCardEnum weaponCardEnum :WeaponCardEnum.values()){
			cards.add(weaponCardEnum.getName());
		};
		return cards;
	}
	
}
