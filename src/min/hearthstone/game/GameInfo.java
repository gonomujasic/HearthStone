package min.hearthstone.game;

import java.util.ArrayList;

import min.hearthstone.card.Card;
import min.hearthstone.card.minion.MinionCard;
import min.hearthstone.player.Player;

public class GameInfo {

	private Player playerOne;
	private Player playerTwo;
	private ArrayList<Card> cardOwnedByPO;// 덱에 있는 카드
	private ArrayList<Card> cardOwnedByPT;
	private ArrayList<Card> cardInHandOfPO;// 들고 있는 카드
	private ArrayList<Card> cardInHandOfPT;
	private ArrayList<MinionCard> POSideMinion;//전장의 하수인 카드
	private ArrayList<MinionCard> PTSideMinion;
	private int ternNumber = 0;
	private String history;
	
	public GameInfo() {
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public ArrayList<Card> getCardOwnedByPO() {
		return cardOwnedByPO;
	}
	public void setCardOwnedByPO(ArrayList<Card> cardOwnedByPO) {
		this.cardOwnedByPO = cardOwnedByPO;
	}
	public ArrayList<Card> getCardOwnedByPT() {
		return cardOwnedByPT;
	}
	public void setCardOwnedByPT(ArrayList<Card> cardOwnedByPT) {
		this.cardOwnedByPT = cardOwnedByPT;
	}
	public ArrayList<Card> getCardInHandOfPO() {
		return cardInHandOfPO;
	}
	public void setCardInHandOfPO(ArrayList<Card> cardInHandOfPO) {
		this.cardInHandOfPO = cardInHandOfPO;
	}
	public ArrayList<Card> getCardInHandOfPT() {
		return cardInHandOfPT;
	}
	public void setCardInHandOfPT(ArrayList<Card> cardInHandOfPT) {
		this.cardInHandOfPT = cardInHandOfPT;
	}
	public ArrayList<MinionCard> getPOSideMinion() {
		return POSideMinion;
	}
	public void setPOSideMinion(ArrayList<MinionCard> pOSideMinion) {
		POSideMinion = pOSideMinion;
	}
	public ArrayList<MinionCard> getPTSideMinion() {
		return PTSideMinion;
	}
	public void setPTSideMinion(ArrayList<MinionCard> pTSideMinion) {
		PTSideMinion = pTSideMinion;
	}
	public int getTernNumber() {
		return ternNumber;
	}
	public void setTernNumber(int ternNumber) {
		this.ternNumber = ternNumber;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
	
}
