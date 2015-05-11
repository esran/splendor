package com.conicaleffort.splendor.api;

import java.util.List;
import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public interface Board {

    List<Noble> getNobles();
    List<Card> getCards(Level level);

    Map<Colour,Integer> getChips();
    Integer getJokers();

}
