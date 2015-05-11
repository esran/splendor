package com.conicaleffort.splendor.api;

import java.util.List;

/*
 * Created by sean on 20/04/15.
 */
public interface Game {

    Board getBoard();
    List<Player> getPlayers();
    Integer getFirstPlayerIndex();
    Integer getCurrentPlayerIndex();

}
