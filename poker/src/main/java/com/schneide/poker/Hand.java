package com.schneide.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cards;
	
	public static Hand from(String handRepresentation) {
		String[] cardRepresentations = handRepresentation.split(" ");
		List<Card> parsedCards = new ArrayList<Card>();
		for(String cardRepresentation : cardRepresentations){
			parsedCards.add(Card.from(cardRepresentation));
		}
		return new Hand(parsedCards);
	}
	
	private Hand (List<Card> cardsInHand) {
		this.cards = cardsInHand;
	}

	public String representation() {
		StringBuilder cardRepresentation = new StringBuilder();
		for(Card card : this.cards) {
			cardRepresentation.append(card.representation());
			cardRepresentation.append(" ");
		}
		return cardRepresentation.toString().trim();
	}

	public boolean hasSameSuit() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasConsecutiveValues() {
		// TODO Auto-generated method stub
		return false;
	}

	public Value highestValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
