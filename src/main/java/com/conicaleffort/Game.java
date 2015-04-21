package com.conicaleffort;

import java.util.Collection;

/*
 * Created by sean on 20/04/15.
 */
public interface Game {

    Board getBoard();
    Collection<? extends Player> getPlayers();

    Player getCurrentPlayer();
    Collection<? extends Player> getPlayersStillToPlay();

    boolean isGameEnding();
    boolean isGameOver();

}
