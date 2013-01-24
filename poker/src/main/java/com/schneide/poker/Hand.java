package com.schneide.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		this.cards = sorted(cardsInHand);
	}

	private List<Card> sorted(List<Card> cardsInHand) {
		Collections.sort(cardsInHand, sortByCardValue());
		return cardsInHand;
	}

	private Comparator<Card> sortByCardValue() {
		return new Comparator<Card>() {

			@Override
			public int compare(Card o1, Card o2) {
				return o1.compareTo(o2.getValue());
			}
		};
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
		Card previousCard = firstCard();
		for(Card card:this.cards) {
			if(!previousCard.hasSameSuit(card)) return false;
			previousCard = card;
		}
		return true;
	}

	private Card firstCard() {
		return this.cards.get(0);
	}

	public boolean hasConsecutiveValues() {
		Card previousCard = firstCard();
		for(int nextCard = 1; nextCard < cards.size(); nextCard++){
			Card card = cards.get(nextCard);
			if(!nextCardsValueIsExcatlyOneHigher(previousCard, card)) return false;
			previousCard = card;
		}
		return true;
	}

	private boolean nextCardsValueIsExcatlyOneHigher(Card previousCard,
			Card card) {
		return previousCard.getValue().ordinal()+1 == card.getValue().ordinal();
	}

	public Value highestValue() {
		Value highestValue = Value._2;
		for(Card card : cards){
			if(card.compareTo(highestValue) > 0){
				highestValue = card.getValue();
			}
		}
		return highestValue;
	}

}

