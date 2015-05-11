package com.conicaleffort.splendor.engine.impl;

import com.conicaleffort.splendor.api.Level;

/*
 * Created by sean on 29/04/15.
 */
public class BuyStashedCard extends MoveImpl {

    private Integer index;

    BuyStashedCard(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

}
