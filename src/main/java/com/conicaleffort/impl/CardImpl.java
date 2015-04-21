package com.conicaleffort.impl;

import com.conicaleffort.Card;
import com.conicaleffort.game.Colour;

import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public class CardImpl implements Card {

    private Integer score;
    private Map<Colour, Integer> cost;
    private Colour gem;

    CardImpl(Map<Colour, Integer> cost, Colour gem, Integer score) {
        this.cost = cost;
        this.gem = gem;
        this.score = score;
    }

    @Override
    public Integer getScore() {
        return score;
    }

    @Override
    public Colour getGem() {
        return gem;
    }

    @Override
    public Map<Colour, Integer> getCost() {
        return cost;
    }

}
