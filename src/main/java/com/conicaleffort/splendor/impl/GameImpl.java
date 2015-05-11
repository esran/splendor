package com.conicaleffort.splendor.impl;

import com.conicaleffort.splendor.api.Board;
import com.conicaleffort.splendor.api.Game;
import com.conicaleffort.splendor.api.Player;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sean on 20/04/15.
 */
public class GameImpl implements Game {

    protected Board board;
    protected List<Player> players;

    protected int firstPlayer;
    protected int currentPlayer;

    protected GameImpl(Board board, List<Player> players) {
        this.board = board;
        this.players = players;

        // Simply set current player and first player to 0
        firstPlayer = 0;
        currentPlayer = 0;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Integer getFirstPlayerIndex() {
        return firstPlayer;
    }

    @Override
    public Integer getCurrentPlayerIndex() {
        return currentPlayer;
    }

}
