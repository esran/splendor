package com.conicaleffort.impl;

import com.conicaleffort.Board;
import com.conicaleffort.Card;
import com.conicaleffort.Game;
import com.conicaleffort.Player;
import com.conicaleffort.game.Move;
import com.conicaleffort.utils.Utils;

/*
 * Created by sean on 20/04/15.
 */
public class ActionImpl {

    void performAction(GameImpl game, BoardImpl board, PlayerImpl player, Move move) {
        if (!Utils.isValidMove(game, player, move)) {
            throw new RuntimeException("Illegal move!");
        }

        switch(move.getType()) {
            case BUY_CARD:
                performBuyCard(game, board, player, move);
            case BUY_STASHED_CARD:
                performBuyStashedCard(game, board, player, move);
            case STASH_CARD:
                performStashCard(game, board, player, move);
            case TAKE_TWO:
            case TAKE_THREE:
                performTakeChips(game, board, player, move);
        }
    }

    private void performStashCard(GameImpl game, BoardInternal board, PlayerInternal player, Move move) {

    }

    private void performTakeChips(GameImpl game, BoardInternal board, PlayerInternal player, Move move) {

    }

    private void performBuyStashedCard(GameImpl game, BoardInternal board, PlayerInternal player, Move move) {

    }

    private static void performBuyCard(Game game, BoardInternal board, PlayerInternal player, Move move) {
        Card card = board.takeCard(move.getLevel(), move.getPosition());
        player.buyCard(card, board);
    }

}
