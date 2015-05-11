package com.conicaleffort.splendor.engine.impl;

import com.conicaleffort.splendor.engine.PlayerEngine;
import com.conicaleffort.splendor.api.Card;
import com.conicaleffort.splendor.api.Colour;
import com.conicaleffort.splendor.api.Noble;
import com.conicaleffort.splendor.impl.PlayerImpl;

import java.util.Map;

/*
 * Created by sean on 29/04/15.
 */
public class PlayerEngineImpl extends PlayerImpl implements PlayerEngine {

    @Override
    public void addChips(Map<Colour, Integer> chips) {
        for (Colour colour : chips.keySet()) {
            this.chips.put(colour, this.chips.get(colour) + chips.get(colour));
        }
    }

    @Override
    public void removeChips(Map<Colour, Integer> chips) {
        for (Colour colour : chips.keySet()) {
            this.chips.put(colour, this.chips.get(colour) - chips.get(colour));
        }
    }

    @Override
    public void addJoker() {
        this.jokers++;
    }

    @Override
    public void removeJokers(Integer count) {
        this.jokers -= count;
    }

    @Override
    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public void addStashedCard(Card card) {
        this.stash.add(card);
    }

    @Override
    public void removeStashedCard(Integer index) {
        this.stash.remove(index);
    }

    @Override
    public void addNoble(Noble noble) {
        this.nobles.add(noble);
    }

}
