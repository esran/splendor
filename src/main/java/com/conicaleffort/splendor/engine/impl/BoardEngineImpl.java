package com.conicaleffort.splendor.engine.impl;

import com.conicaleffort.splendor.engine.BoardEngine;
import com.conicaleffort.splendor.api.Colour;
import com.conicaleffort.splendor.api.Level;
import com.conicaleffort.splendor.impl.BoardImpl;

import java.util.Map;

/*
 * Created by sean on 29/04/15.
 */
public class BoardEngineImpl extends BoardImpl implements BoardEngine {

    BoardEngineImpl(int numPlayers) {
        super(numPlayers);
    }

    @Override
    public void removeCard(Level level, Integer index) {
        // Remove the card
        cards.get(level).remove(index);

        // Deal a new one into its place
        cards.get(level).add(index, cardDecks.get(level).remove(0));
    }

    @Override
    public void removeChips(Map<Colour, Integer> chips) {
        for (Colour colour : chips.keySet()) {
            this.chips.put(colour, this.chips.get(colour) - chips.get(colour));
        }
    }

    @Override
    public void addChips(Map<Colour, Integer> chips) {
        for (Colour colour: chips.keySet()) {
            this.chips.put(colour, this.chips.get(colour) + chips.get(colour));
        }
    }

    @Override
    public void addJokers(Integer count) {
        this.jokers += count;
    }

    @Override
    public void removeJoker() {
        this.jokers--;
    }

    @Override
    public void removeNoble(Integer index) {
        nobles.remove(index);
    }

}
