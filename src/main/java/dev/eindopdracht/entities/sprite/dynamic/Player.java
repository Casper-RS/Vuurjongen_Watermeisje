package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.map.Wall;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider, Collided {

    public boolean isOnground = true;

    private double speed = 1;
    private double jumpstrenght = 4;
    protected boolean touchingWall = false;

    private VuurjongenWatermeisje vuurjongenWatermeisje;

    public Player(String resource, Coordinate2D location, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(resource, location, new Size(30, 50), 1, 1);
        setGravityConstant(0.08);
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

    @Override
    public Coordinate2D getAnchorLocation() {
        return super.getAnchorLocation();
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var wallCollision = false;

        for (Collider collider : collidingObject) {
            if (collider instanceof Wall) {
                wallCollision = true;
            }
        }

        if (wallCollision) {
            setMotion(0, 0d);
            System.out.println("Je raakt een muur stumperd");
        }
    }


    public void jump(Player p) {
        if (p instanceof Fireboy) {
            if (((Fireboy) p).isOnground) {
                setMotion(jumpstrenght, 180d);
                ((Fireboy) p).isOnground = false;
            }
        } else if (p instanceof Watergirl) {
            if (((Watergirl) p).isOnGround) {
                setMotion(jumpstrenght, 180d);
                ((Watergirl) p).isOnGround = false;
            }
        }
    }

    // =================[ CHECK if player hits borders ]=================
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

    // =================[ HANDLE isOnGround ]=================
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
