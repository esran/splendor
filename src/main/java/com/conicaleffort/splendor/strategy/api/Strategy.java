package com.conicaleffort.splendor.strategy.api;

import com.conicaleffort.splendor.api.Game;
import com.conicaleffort.game.Move;
import com.conicaleffort.splendor.api.Player;

/*
 * Created by sean on 20/04/15.
 */
public interface Strategy {

    <P extends Player & PlayerStrategy> Move chooseMove(Game game, P player);

}
