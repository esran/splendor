package com.conicaleffort.utils;

import com.conicaleffort.Board;
import com.conicaleffort.Card;
import com.conicaleffort.game.Colour;
import com.conicaleffort.Game;
import com.conicaleffort.Player;
import com.conicaleffort.game.Move;

import java.util.Collection;
import java.util.Map;

/*
 * Created by sean on 20/04/15.
 */
public class Utils {

    public static int countGems(Collection<Card> cards, Colour colour) {
        int result = 0;

        for (Card card : cards) {
            if (card.getGem() == colour) {
                result++;
            }
        }

        return result;
    }

    public static int calcScore(Player player) {
        int score = 0;

        for (Card card : player.getCards()) {
            score += card.getScore();
        }

        return score;
    }

    public static int getMaxScore(Game game) {
        int maxScore = 0;

        for (Player player : game.getPlayers()) {
            if (calcScore(player) > maxScore) {
                maxScore = calcScore(player);
            }
        }

        return maxScore;
    }

    public static boolean isValidMove(Game game, Player player, Move move) {

        // If game is over then obviousl no move is valid
        if (game.isGameOver()) return false;

        // If this player is not the current player than not valid
        if (!game.getCurrentPlayer().equals(player)) return false;

        switch(move.getType()) {
            case TAKE_TWO:
                return isTakeTwoValid(game, player, move);
            case TAKE_THREE:
                return isTakeThreeValid(game, player, move);
            case BUY_CARD:
                return isBuyCardValid(game, player, move);
            case BUY_STASHED_CARD:
                return isBuyStashedCardValid(game, player, move);
            case STASH_CARD:
                return true;
        }

        return false;
    }

    private static boolean isTakeTwoValid(Game game, Player player, Move move) {
        // Currently we don't allow taking chips if it would put the player over the 10
        // chip hand limit
        if (player.getChips().size() + player.getJokers() + 2 > 10) {
            return false;
        }

        // Not valid if the relevant stack has <4 currently
        if (game.getBoard().getChips().get(move.getColours().get(0)) < 4) {
            return false;
        }

        return true;
    }

    private static boolean isTakeThreeValid(Game game, Player player, Move move) {
        // Currently we don't allow taking chips if it would put the player over the 10
        // chip hand limit
        if (player.getChips().size() + player.getJokers() + 3 > 10) {
            return false;
        }

        // Check that each colour's stack has at least 1 chip left
        for (Colour colour : move.getColours()) {
            if (game.getBoard().getChips().get(colour) <= 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isBuyCardValid(Game game, Player player, Move move) {
        // Identify the card
        Card cardToBuy = game.getBoard().getCard(move.getLevel(), move.getPosition());

        return isCardPurchaseValid(cardToBuy, player, move.getJokers());
    }

    private static boolean isBuyStashedCardValid(Game game, Player player, Move move) {
        // Identify the card
        Card cardToBuy = player.getStashedCards().get(move.getPosition());

        return isCardPurchaseValid(cardToBuy, player, move.getJokers());
    }

    private static boolean isCardPurchaseValid(Card cardToBuy, Player player, int jokers) {

        // Abort if no card specified!
        if (cardToBuy == null) {
            return false;
        }

        // Abort if trying to use more jokers than the player has
        if (jokers > player.getJokers()) {
            return false;
        }

        // Check each colour on the card being purchased
        for (Colour colour : cardToBuy.getCost().keySet()) {
            // Initialise the difference to the cost of that colour
            int difference = cardToBuy.getCost().get(colour);

            // Subtract the gems player has from their cards
            difference -= countGems(player.getCards(), colour);
            if (difference <= 0) continue;

            // Subtract the relevant colour chips the player has
            difference -= player.getChips().get(colour);
            if (difference <= 0) continue;

            // If not enough jokers to cover the difference then abort
            if (difference > jokers) {
                return false;
            }

            // Mark the jokers as used
            jokers -= difference;
        }

        return true;
    }

}
