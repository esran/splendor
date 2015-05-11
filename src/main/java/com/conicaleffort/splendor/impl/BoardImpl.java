package com.conicaleffort.splendor.impl;

import com.conicaleffort.splendor.api.*;

import java.util.*;

/*
 * Created by sean on 20/04/15.
 */
public class BoardImpl implements Board {

    private static final int NUM_POSITIONS = 4;

    protected List<Noble> noblesDeck = new ArrayList<>();
    protected List<Noble> nobles = new ArrayList<>();

    protected Map<Level,List<Card>> cardDecks = new HashMap<>();
    protected Map<Level,List<Card>> cards = new HashMap<>();

    protected Map<Colour,Integer> chips = new HashMap<>();
    protected Integer jokers = new Integer(0);

    protected BoardImpl(int numPlayers) {
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

        // TODO: Get the initial decks from static data
        // Shuffle the card decks
        for (List<Card> deck : cardDecks.values()) {
            Collections.shuffle(deck);
        }

        // Deal out the initial state
        for (Level level : Level.values()) {
            cards.put(level, new ArrayList<Card>());
            for (int position = 0 ; position < NUM_POSITIONS ; position++) {
                cards.get(level).add(cardDecks.get(level).remove(0));
            }
        }

        // TODO get the nobles deck
        // shuffle the nobles deck
        Collections.shuffle(noblesDeck);

        // Deal out the nobles
        for (int noble = 0 ; noble <= numPlayers ; noble++) {
            nobles.add(noblesDeck.remove(0));
        }
    }

    @Override
    public List<Noble> getNobles() {
        return nobles;
    }

    @Override
    public List<Card> getCards(Level level) {
        return cards.get(level);
    }

    @Override
    public Map<Colour, Integer> getChips() {
        return chips;
    }

    @Override
    public Integer getJokers() {
        return jokers;
    }

}
