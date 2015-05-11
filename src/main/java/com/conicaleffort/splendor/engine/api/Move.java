package com.conicaleffort.splendor.engine.api;

/*
 * Created by sean on 29/04/15.
 */
public interface Move {

    MoveType getMoveType();

    enum MoveType {
        BUY_CARD,
        BUY_STASHED_CARD,
        TAKE_TWO,
        TAKE_THREE,
        STASH_CARD;
    }

}
