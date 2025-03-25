package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider {
    double speed = 1;
    double jumpstrenght = 1;

    public Player(String resource, Coordinate2D location) {
        super(resource, location, new Size(30, 50), 1, 1);

        setGravityConstant(0.05);
        setFrictionConstant(0.04);
    }

    public final void moveLeft() {
        setMotion(speed, 270d);
        setCurrentFrameIndex(0);
    }

    public final void moveRight() {
        setMotion(speed, 90d);
        setCurrentFrameIndex(1);
    }

    public void onCollision() {

    }

    public void jump(Player p) {
        if (p instanceof Fireboy) {
            ((Fireboy) p).isOnground = true;
            setMotion(jumpstrenght, 180d);
            //p.isOnGround = false;
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        handleMovement(pressedKeys);
    }

    public void handleMovement(Set<KeyCode> pressedKeys) {
        //movement is different for each kind of character
    }
}
