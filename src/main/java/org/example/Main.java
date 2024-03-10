package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Game game = new Game();
            game.play();
            results.add(game.isSwitchDoor());
        }
        int wins = (int) results.stream().filter(Boolean::booleanValue).count();
        int losses = results.size() - wins;
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}