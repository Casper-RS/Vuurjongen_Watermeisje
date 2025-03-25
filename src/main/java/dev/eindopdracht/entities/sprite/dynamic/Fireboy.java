package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.KeyCode;
import java.util.Set;

public class Fireboy extends Player{

    public boolean isOnground = true;

    public Fireboy(Coordinate2D location) {
        super("sprites/fireboy.png", location);
    }

    @Override
    public void onCollision() {
        System.out.println("Fireboy");
    }

    @Override
    public void handleMovement(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            moveLeft();
        }
        if (pressedKeys.contains(KeyCode.D)) {
            moveRight();
        }
        if (pressedKeys.contains(KeyCode.W)) {
            jump(this);
        }
    }

    public boolean getIsOnground() {
        return isOnground;
    }

    public void toggleIsOnground() {
        isOnground = !isOnground;
    }

    public void setIsOnground(boolean isOnground) {
        this.isOnground = isOnground;
    }
}

