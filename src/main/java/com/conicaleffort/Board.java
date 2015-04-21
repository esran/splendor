package com.conicaleffort;

import com.conicaleffort.game.Colour;

import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public interface Board {

    Card getCard(int level, int position);

    Map<Colour,Integer> getChips();
    int getJokers();



}
