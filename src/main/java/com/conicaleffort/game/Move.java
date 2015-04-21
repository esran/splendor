package com.conicaleffort.game;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by sean on 20/04/15.
 */
public class Move {

    public enum MoveType {
        BUY_CARD,
        STASH_CARD,
        TAKE_TWO,
        TAKE_THREE,
        BUY_STASHED_CARD
    }

    private MoveType type;

    private int level;
    private int position;
    private int jokers;
    private List<Colour> colours;

    private Move() {

    }

    public MoveType getType() {
        return type;
    }

    public static Move buyCard(int level, int position, int jokers) {
        Move move = new Move();

        move.type = MoveType.BUY_CARD;
        move.level = level;
        move.position = position;

        move.jokers = jokers;

        return move;
    }

    public static Move buyStashedCard(int position, int jokers) {
        Move move = new Move();

        move.type = MoveType.BUY_STASHED_CARD;
        move.position = position;
        move.jokers = jokers;

        return move;
    }

    public int getLevel() {
        return level;
    }

    public int getPosition() {
        return position;
    }

    public int getJokers() {
        return jokers;
    }

    public List<Colour> getColours() {
        return colours;
    }

    public static Move stashCard(int level, int position) {
        Move move = new Move();


        move.type = MoveType.STASH_CARD;
        move.level = level;
        move.position = position;

        return move;
    }

    public static Move takeTwo(Colour colour) {
        Move move = new Move();

        move.type = MoveType.TAKE_TWO;
        move.colours = new ArrayList<Colour>();
        move.colours.add(colour);
        move.colours.add(colour);

        return move;
    }

    public static Move takeThree(Colour c1, Colour c2, Colour c3) {
        Move move = new Move();

        move.type = MoveType.TAKE_THREE;
        move.colours = new ArrayList<Colour>();
        move.colours.add(c1);
        move.colours.add(c2);
        move.colours.add(c3);

        return move;
    }

}
