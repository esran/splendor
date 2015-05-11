package com.conicaleffort.splendor.impl;

import com.conicaleffort.splendor.api.Card;
import com.conicaleffort.splendor.api.Colour;

import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public class CardImpl implements Card {

    private Integer vp;
    private Map<Colour, Integer> cost;
    private Colour gem;

    CardImpl(Map<Colour, Integer> cost, Colour gem, Integer vp) {
        this.cost = cost;
        this.gem = gem;
        this.vp = vp;
    }

    @Override
    public Integer getVP() {
        return vp;
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
