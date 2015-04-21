package com.conicaleffort.impl;

import com.conicaleffort.*;
import com.conicaleffort.game.Colour;
import com.conicaleffort.game.Move;
import com.conicaleffort.strategy.Strategy;
import com.conicaleffort.utils.Utils;

import java.util.*;

/*
 * Created by sean on 20/04/15.
 */
public class PlayerImpl implements Player, PlayerInternal {

    List<Card> cards = new ArrayList<>();
    List<Card> stash = new ArrayList<>();
    Map<Colour,Integer> chips = new HashMap<>();
    int jokers = 0;

    Strategy strategy;

    <S extends Strategy> PlayerImpl(S strategy) {
        this.strategy = strategy;
    }

    @Override
    public Collection<Card> getCards() {
        return cards;
    }

    @Override
    public List<Card> getStashedCards() {
        return stash;
    }

    @Override
    public int getJokers() {
        return jokers;
    }

    @Override
    public Map<Colour, Integer> getChips() {
        return chips;
    }

    @Override
    public int getScore() {
        int score = 0;

        for (Card card : cards) {
            score += card.getScore();
        }

        return score;
    }

    @Override
    public Move getMove(Game game) {
        return strategy.chooseMove(game, this);
    }

    /*
     * Note: No validation is done here!
     */
    @Override
    public void buyCard(Card card, BoardInternal board) {
        Map<Colour,Integer> chipSpend = new HashMap<>();
        int jokersRequired = 0;

        for (Colour colour : card.getCost().keySet()) {
            // Initial difference is the colour cost of the card
            int difference = card.getCost().get(colour);

            // Reduce this by the number of gems we have
            difference -= Utils.countGems(cards, colour);
            if (difference <= 0) continue;;

            // Check how many chips of the colour we have
            int chipCount = chips.get(colour);

            // If we can cover the difference with chips then mark
            // that as the spend and move on to the next colour.
            if (difference <= chipCount) {
                chipSpend.put(colour, difference);
                continue;
            }

            // Otherwise mark the spend as the whole chip count
            chipSpend.put(colour, chipCount);

            // Check for any remaining difference and add that to
            // the number of jokers required.
            difference -= chipCount;
            if (difference > 0) {
                jokersRequired += difference;
            }
        }

        // Check we have enough jokers
        if (jokersRequired > jokers) {
            throw new RuntimeException("Trying to spend more jokers than we have!");
        }

        // Spend the chips
        board.returnChips(chipSpend);
        for (Colour colour : chipSpend.keySet()) {
            chips.put(colour, chips.get(colour) - chipSpend.get(colour));
        }

        // Spend the jokers
        board.returnJokers(jokersRequired);
        jokers -= jokersRequired;

        // Finally, add the card to our list!
        cards.add(card);
    }
}
