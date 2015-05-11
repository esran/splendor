package com.conicaleffort.splendor.engine;

import com.conicaleffort.splendor.api.Colour;
import com.conicaleffort.splendor.api.Level;

import java.util.Map;

/*
 * Created by sean on 29/04/15.
 */
public interface BoardEngine {

    void removeCard(Level level, Integer index);

    void removeChips(Map<Colour, Integer> chips);
    void addChips(Map<Colour, Integer> chips);

    void addJokers(Integer count);
    void removeJoker();

    void removeNoble(Integer index);

}
