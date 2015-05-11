package com.conicaleffort.splendor.api;

import java.util.Collection;
import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public interface Player {

    Collection<Card> getCards();
    Integer getNumStashedCards();
    Integer getJokers();
    Map<Colour,Integer> getChips();
    Collection<Noble> getNobles();

    Integer getScore();

}
