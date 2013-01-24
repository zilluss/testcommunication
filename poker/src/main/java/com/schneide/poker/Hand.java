package com.schneide.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	public int highestNumberOfCardsWithTheSameValue() {
		Map<Value, Integer> countOfValues = countValues();
		for(Card card : this.cards) {
			countOfValues.put(card.getValue(), countOfValues.get(card.getValue())+1);
		}
		return highest(countOfValues);
	}

	private int highest(Map<Value, Integer> countOfValues) {
		int highestCount = 0;
		for(Integer count : countOfValues.values()){
			highestCount = count > highestCount ? count : highestCount;
		}
		return highestCount;
	}

	private Map<Value, Integer> countValues() {
		Map<Value, Integer> countValues = new HashMap<Value, Integer>();
		for(Value value: Value.values()) {
			countValues.put(value, 0);
		}
		return countValues;
	}

}

