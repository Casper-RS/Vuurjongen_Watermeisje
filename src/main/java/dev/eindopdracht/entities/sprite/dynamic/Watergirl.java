package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import dev.eindopdracht.VuurjongenWatermeisje;
import javafx.scene.input.KeyCode;
import java.util.Set;

public class Watergirl extends Player {
    public Watergirl(Coordinate2D location, VuurjongenWatermeisje v) {
        super("sprites/watergirl.png", location, v);
    }

    @Override
    public void handleMovement(Set<KeyCode> pressedKeys) {
        boolean moving = false;

        if (pressedKeys.contains(KeyCode.LEFT)) {
            moveLeft(false);
            moving = true;
        }
        if (pressedKeys.contains(KeyCode.RIGHT)) {
            moveRight(false);
            moving = true;
        }
        if (pressedKeys.contains(KeyCode.UP)) {
            jump(this);
            moving = true;
        }
        if (!moving) {
            setSpeed(0); // Stop movement when no key is pressed
        }
    }
}
