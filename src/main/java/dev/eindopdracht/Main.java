package dev.eindopdracht;
import com.github.hanyaeger.api.YaegerGame;

public class Main extends YaegerGame {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void setupGame() {

    }

    @Override
    public void setupScenes() {
        System.out.println("test webhook");
    }
}