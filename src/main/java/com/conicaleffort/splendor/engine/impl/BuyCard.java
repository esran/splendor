package com.conicaleffort.splendor.engine.impl;

import com.conicaleffort.splendor.api.Level;
import com.conicaleffort.splendor.engine.api.Move;

/*
 * Created by sean on 29/04/15.
 */
public class BuyCard extends MoveImpl {

    private Level level;
    private Integer index;

    BuyCard(Level level, Integer index) {
        this.level = level;
        this.index = index;
    }

    public Level getLevel() {
        return level;
    }

    public Integer getIndex() {
        return index;
    }

}
