package com.conicaleffort.splendor.engine;

import com.conicaleffort.splendor.api.Card;
import com.conicaleffort.splendor.api.Colour;
import com.conicaleffort.splendor.api.Noble;

import java.util.Map;

/*
 * Created by sean on 29/04/15.
 */
public interface PlayerEngine {

    void addChips(Map<Colour, Integer> chips);
    void removeChips(Map<Colour, Integer> chips);

    void addJoker();
    void removeJokers(Integer count);

    void addCard(Card card);

    void addStashedCard(Card card);
    void removeStashedCard(Integer index);

    void addNoble(Noble noble);

}
