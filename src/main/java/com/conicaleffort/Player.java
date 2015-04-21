package com.conicaleffort;

import com.conicaleffort.game.Colour;
import com.conicaleffort.game.Move;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public interface Player {

    Collection<Card> getCards();
    List<Card> getStashedCards();
    int getJokers();
    Map<Colour,Integer> getChips();

    int getScore();

    Move getMove(Game game);

}
