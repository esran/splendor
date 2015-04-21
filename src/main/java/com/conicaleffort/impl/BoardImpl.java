package com.conicaleffort.impl;

import com.conicaleffort.Board;
import com.conicaleffort.Card;
import com.conicaleffort.game.Colour;

import java.util.*;

/*
 * Created by sean on 20/04/15.
 */
public class BoardImpl implements Board, BoardInternal {

    private static final int MAX_LEVELS = 3;
    private static final int MAX_POSITIONS = 4;

    private Deck decks[];
    private Card cards[][];
    private Map<Colour,Integer> chips = new HashMap<>();
    private int jokers;

    BoardImpl(int numPlayers) {
        // Set the number of chips based on the number of players
        int numChips;
        switch(numPlayers) {
            case 3:
                numChips = 5;
                break;
            case 4:
                numChips = 7;
                break;
            default:
                throw new RuntimeException("ERROR: Number of players must be 3 or 4");
        }

        // Setup the initial stacks of jokers and chips
        jokers = numChips;
        for (Colour colour : Colour.values()) {
            chips.put(colour, numChips);
        }

        // Deal out the initial state
        decks = new Deck[MAX_LEVELS];
        cards = new Card[MAX_LEVELS][MAX_POSITIONS];
        for (int level = 0 ; level < MAX_LEVELS ; level++) {
            // TODO: Get the initial decks from static data
            decks[level] = new Deck();
            decks[level].shuffle();

            for (int position = 0 ; position < MAX_POSITIONS ; position++) {
                cards[level][position] = decks[level].dealCard();
            }
        }

    }

    @Override
    public Card getCard(int level, int position) {
        return cards[level][position];
    }

    @Override
    public Map<Colour, Integer> getChips() {
        return chips;
    }

    @Override
    public int getJokers() {
        return jokers;
    }

    @Override
    public Card takeCard(int level, int position) {
        Card card = cards[level][position];
        cards[level][position] = decks[level].dealCard();

        return card;
    }

    @Override
    public void takeChips(List<Colour> chips) {
        for(Colour colour : chips) {
            this.chips.put(colour, this.chips.get(colour) - 1);
        }
    }

    @Override
    public void returnChips(Map<Colour, Integer> chips) {
        for (Colour colour : chips.keySet()) {
            this.chips.put(colour, this.chips.get(colour) + chips.get(colour));
        }
    }

    @Override
    public void returnJokers(int jokers) {
        this.jokers += jokers;
    }

    @Override
    public void takeJoker() {
        this.jokers--;
    }

    private class Deck {

        private List<Card> deck = new LinkedList<>();
        private Random random;

        protected Deck() {
            random = new Random();
        }

        protected Deck(long seed) {
            random = new Random(seed);
        }

        protected void addCard(Card card) {
            deck.add(card);
        }

        public void shuffle() {
            Collections.shuffle(deck, random);
        }

        public Card dealCard() {
            return deck.remove(0);
        }

        public Integer cardsLeft() {
            return deck.size();
        }

        public boolean isEmpty() {
            return deck.isEmpty();
        }

    }
}
