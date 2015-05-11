package com.conicaleffort.splendor.impl;

import com.conicaleffort.splendor.api.Card;
import com.conicaleffort.splendor.api.Colour;
import com.conicaleffort.splendor.api.Noble;
import com.conicaleffort.splendor.api.Player;

import java.util.*;

/*
 * Created by sean on 20/04/15.
 */
public class PlayerImpl implements Player {

    protected List<Card> cards = new ArrayList<>();
    protected List<Card> stash = new ArrayList<>();
    protected Map<Colour,Integer> chips = new HashMap<>();
    protected List<Noble> nobles = new ArrayList<>();
    protected Integer jokers = 0;

    @Override
    public Collection<Card> getCards() {
        return cards;
    }

    @Override
    public Integer getNumStashedCards() {
        return stash.size();
    }

    @Override
    public Integer getJokers() {
        return jokers;
    }

    @Override
    public Map<Colour, Integer> getChips() {
        return chips;
    }

    @Override
    public Collection<Noble> getNobles() {
        return nobles;
    }

    @Override
    public Integer getScore() {
        int score = 0;

        for (Card card : cards) {
            score += card.getVP();
        }

        return score;
    }

}
