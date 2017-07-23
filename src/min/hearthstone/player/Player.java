package min.hearthstone.player;

import java.util.ArrayList;

import min.hearthstone.card.Card;
import min.hearthstone.character.Character;

public class Player {
	
	private String sessionID;
	private Character character;
	private ArrayList<Card> FirstDeck = new ArrayList<Card>();

	
	public Player(String sessionID, Character character) {
		this.sessionID = sessionID;
		this.character = character;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public ArrayList<Card> getFirstDeck() {
		return FirstDeck;
	}

	public void setFirstDeck(ArrayList<Card> firstDeck) {
		FirstDeck = firstDeck;
	}
	
	
}
