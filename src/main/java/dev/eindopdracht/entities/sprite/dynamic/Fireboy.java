package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.KeyCode;
import java.util.Set;

public class Fireboy extends Player{
    public Fireboy(Coordinate2D location) {
        super("sprites/fireboy.png", location);
    }

    @Override
    public void onCollision() {
    }

    @Override
    public void handleMovement(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            moveLeft();
        }
        if (pressedKeys.contains(KeyCode.D)) {
            moveRight();
        }
    }
}

