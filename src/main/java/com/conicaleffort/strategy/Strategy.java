package com.conicaleffort.strategy;

import com.conicaleffort.Game;
import com.conicaleffort.Player;
import com.conicaleffort.game.Move;

/*
 * Created by sean on 20/04/15.
 */
public interface Strategy {

    Move chooseMove(Game game, Player player);

}
