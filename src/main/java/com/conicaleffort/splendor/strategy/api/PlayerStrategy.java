package com.conicaleffort.splendor.strategy.api;

import com.conicaleffort.splendor.api.Card;
import com.conicaleffort.splendor.impl.PlayerImpl;

import java.util.List;

/*
 * Created by sean on 29/04/15.
 */
public interface PlayerStrategy {

    List<Card> getStashCards();

}
