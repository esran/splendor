package com.conicaleffort.splendor.impl;

import com.conicaleffort.splendor.api.Colour;
import com.conicaleffort.splendor.api.Noble;

import java.util.Map;

/*
 * Created by sean on 29/04/15.
 */
public class NobleImpl implements Noble {

    protected Integer vp;
    protected Map<Colour, Integer> cost;

    @Override
    public Integer getVP() {
        return vp;
    }

    @Override
    public Map<Colour, Integer> getCost() {
        return cost;
    }
}
