package com.conicaleffort;

import com.conicaleffort.game.Colour;

import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public interface Card {

    Integer getScore();
    Colour getGem();
    Map<Colour,Integer> getCost();

}
