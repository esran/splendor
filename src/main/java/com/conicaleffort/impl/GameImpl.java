package com.conicaleffort.impl;

import com.conicaleffort.Board;
import com.conicaleffort.Game;
import com.conicaleffort.Player;
import com.conicaleffort.strategy.impl.DumbStrategy;
import com.conicaleffort.utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Created by sean on 20/04/15.
 */
public class GameImpl implements Game {

    private BoardImpl board;
    private List<PlayerImpl> players;
    private int currentPlayer;
    private int numPlayers;

    GameImpl(int numPlayers) {
        this.numPlayers = numPlayers;
        board = new BoardImpl(numPlayers);
        players = new ArrayList<>();
        for (int i = 0 ; i < numPlayers ; ++i) {
            players.add(new PlayerImpl(new DumbStrategy()));
        }
        currentPlayer = 0;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public Collection<? extends Player> getPlayers() {
        return players;
    }

    @Override
    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    @Override
    public Collection<? extends Player> getPlayersStillToPlay() {
        Collection<Player> result = new ArrayList<>();

        for (int p = currentPlayer + 1 ; p < numPlayers ; ++p) {
            result.add(players.get(p));
        }

        return result;
    }

    @Override
    public boolean isGameEnding() {
        return (Utils.getMaxScore(this) >= 15);
    }

    @Override
    public boolean isGameOver() {
        return (isGameEnding() && currentPlayer == 0);
    }

}
