package com.conicaleffort.splendor.helpers;

import com.conicaleffort.splendor.api.Game;
import com.conicaleffort.splendor.api.Player;

/*
 * Created by sean on 29/04/15.
 */
public class Utils {

    public static Integer getMaxScore(Game game) {
        Integer maxScore = 0;

        for (Player player : game.getPlayers()) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }

        return maxScore;
    }

}
