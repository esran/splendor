package com.conicaleffort.impl;

import com.conicaleffort.Card;
import com.conicaleffort.game.Colour;

import java.util.List;
import java.util.Map;

/*
 * Created by sean on 21/04/15.
 */
public interface BoardInternal {

    public Card takeCard(int level, int position);
    public void takeChips(List<Colour> chips);
    public void returnChips(Map<Colour, Integer> chips);
    public void returnJokers(int jokers);
    public void takeJoker();

}
