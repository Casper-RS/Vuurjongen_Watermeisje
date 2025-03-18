package dev.eindopdracht;
import com.github.hanyaeger.api.YaegerGame;

import java.util.ArrayList;
import java.util.List;

public class Game extends YaegerGame {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    List <Levels> levels = new ArrayList<>(800000);
    int levelState;

    @Override
    public void setupGame() {

    }

    @Override
    public void setupScenes() {
        System.out.println("test");
        System.out.println("test2");
    }
}