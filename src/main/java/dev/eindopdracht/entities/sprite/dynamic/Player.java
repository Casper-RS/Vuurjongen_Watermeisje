package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.Node;

import java.util.Optional;

public class Player /*extends DynamicSpriteEntity*/ {
    float x, y;
    double speed;
    double jumpstrenght;
    boolean isOnGround = false;

    public Player(float x, float y, double speed, double jumpstrenght) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.jumpstrenght = jumpstrenght;
    }

    public void moveLeft() {

    }

    public void moveRight() {

    }

    public void jump() {

    }

    public void onCollision() {

    }
}
