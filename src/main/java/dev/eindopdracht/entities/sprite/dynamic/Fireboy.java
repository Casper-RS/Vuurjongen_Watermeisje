package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.map.Wall;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Fireboy extends Player {

    public Fireboy(Coordinate2D location, VuurjongenWatermeisje v) {
        super("sprites/fireboy.png", location, v);
    }

    @Override
    public void handleMovement(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            System.out.println("Naar links");
            moveLeft();
        }
        if (pressedKeys.contains(KeyCode.D)) {
            moveRight();
        }
        if (pressedKeys.contains(KeyCode.W)) {
            jump(this);
        }
    }
}


