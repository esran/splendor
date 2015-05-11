package com.conicaleffort.splendor.strategy.impl;

import com.conicaleffort.splendor.api.Game;
import com.conicaleffort.splendor.api.Player;
import com.conicaleffort.game.Move;
import com.conicaleffort.splendor.strategy.api.PlayerStrategy;
import com.conicaleffort.splendor.strategy.api.Strategy;

/*
 * Created by sean on 20/04/15.
 */
public class DumbStrategy implements Strategy{
    @Override
    public <P extends Player & PlayerStrategy> Move chooseMove(Game game, P player) {
        return null;
    }
}
