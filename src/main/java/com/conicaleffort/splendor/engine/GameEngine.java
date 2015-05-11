package com.conicaleffort.splendor.engine;

import com.conicaleffort.splendor.engine.api.Move;

/*
 * Created by sean on 29/04/15.
 */
public interface GameEngine {

    void playMove(Move move);
    void nextPlayer();

    boolean hasGameEnded();

}
