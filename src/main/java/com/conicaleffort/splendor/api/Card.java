package com.conicaleffort.splendor.api;

import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public interface Card {

    Integer getVP();
    Colour getGem();
    Map<Colour,Integer> getCost();

}
