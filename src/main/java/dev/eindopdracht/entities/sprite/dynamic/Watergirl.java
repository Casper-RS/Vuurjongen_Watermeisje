package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.KeyCode;
import java.util.Set;

public class Watergirl extends Player {
    public Watergirl(Coordinate2D location) {
        super("sprites/watergirl.png", location);
    }

    @Override
    public void onCollision() {
    }

    @Override
    public void handleMovement(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            moveLeft();
        }
        if (pressedKeys.contains(KeyCode.RIGHT)) {
            moveRight();
        }
    }
}
