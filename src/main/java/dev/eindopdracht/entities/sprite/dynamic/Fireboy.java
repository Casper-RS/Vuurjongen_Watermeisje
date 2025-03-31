package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import dev.eindopdracht.VuurjongenWatermeisje;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Fireboy extends Player {

    public Fireboy(Coordinate2D location, VuurjongenWatermeisje v) {
        super("sprites/fireboy.png", location, v);
    }

    @Override
    public void handleMovement(Set<KeyCode> pressedKeys) {
        boolean moving = false;

        if (pressedKeys.contains(KeyCode.A)) {
            System.out.println("Naar links");
            moveLeft(false);
            moving = true;
        }
        if (pressedKeys.contains(KeyCode.D)) {
            moveRight(false);
            moving = true;
        }
        if (pressedKeys.contains(KeyCode.W)) {
            jump(this);
            moving = true;
        }
        if (!moving) {
            setSpeed(0); // Stop movement when no key is pressed
        }
    }
}


