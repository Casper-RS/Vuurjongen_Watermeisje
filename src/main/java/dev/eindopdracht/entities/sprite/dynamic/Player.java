package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

import java.util.Optional;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider {
    double speed = 1;
    double jumpstrenght = 1;
    boolean isOnGround = false;

    public Player(String resource, Coordinate2D location) {
        super(resource, location, new Size(30, 50), 1, 2);

        setGravityConstant(0);
//        setFrictionConstant(0.04);
    }

    public final void moveLeft() {
        setMotion(3,270d);
        setCurrentFrameIndex(0);
    }

    public final void moveRight() {
        setMotion(3, 90d);
        setCurrentFrameIndex(1);
    }

    public void jump() {

    }

    public void onCollision() {

    }

    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT)){
            moveLeft();
        }
        if(pressedKeys.contains(KeyCode.RIGHT)) {
            moveRight();
        }
    }
}
