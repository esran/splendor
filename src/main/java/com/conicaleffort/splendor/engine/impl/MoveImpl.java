package com.conicaleffort.splendor.engine.impl;

import com.conicaleffort.splendor.engine.api.Move;

/*
 * Created by sean on 29/04/15.
 */
public class MoveImpl implements Move {

    protected MoveType type;

    @Override
    public MoveType getMoveType() {
        return type;
    }

}
