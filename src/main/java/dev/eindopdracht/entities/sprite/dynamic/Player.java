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
    private List<Collider> lastCollisions;
    private double speed = 1;
    protected boolean touchingWall = false;
    private VuurjongenWatermeisje vuurjongenWatermeisje;

    public Player(String resource, Coordinate2D location, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(resource, location, new Size(60, 80), 1, 1);
        setGravityConstant(0.08);
        setFrictionConstant(0.04);
    }


    @Override
    public void onCollision(List<Collider> collidingObjects) {
        lastCollisions = collidingObjects; // store for later use

        boolean wallCollision = false;

        for (Collider collider : collidingObjects) {
            if (collider instanceof Wall) {
                wallCollision = true;
                isOnground = true;
                // If the wall is beneath the player, they are "on ground"
                if (collider.getBoundingBox().getMinY() >= this.getBoundingBox().getMaxY() - 1) {
                    isOnground = true;
                }
            }
        }

        if (wallCollision) {
            setMotion(0, 0);
        }
    }



    public boolean isStandingOnWall() {
        for (Collider collider : lastCollisions) {
            if (collider instanceof Wall) {
                if (collider.getBoundingBox().getMinY() >= this.getBoundingBox().getMaxY() - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public final void moveLeft() {
        //check 1 pixel voor kant die de speler oploopt
        if (getAnchorLocation().getX() - 1 >= 12) {
            setMotion(speed, 270d);
            setCurrentFrameIndex(0);
            System.out.println("Bewogen naar:");
            System.out.println("X-Pos: " + getAnchorLocation().getX());
            System.out.println("Y-Pos: " + getAnchorLocation().getY());

        } else {
            System.out.println("Muur geraakt");
            System.out.println("X-Pos: " + getAnchorLocation().getX());
            System.out.println("Y-Pos: " + getAnchorLocation().getY());
        }
    }

    public final void moveRight() {
        //check 1 pixel voor kant die de speler oploopt
        if (getAnchorLocation().getX() + 1 >= getWidth() - 50) {
            setMotion(speed, 90d);
            setCurrentFrameIndex(0);
            System.out.println("Bewogen naar:");
            System.out.println("X-Pos: " + getAnchorLocation().getX());
            System.out.println("Y-Pos: " + getAnchorLocation().getY());

        } else {
            System.out.println("Muur geraakt");
            System.out.println("X-Pos: " + getAnchorLocation().getX());
            System.out.println("Y-Pos: " + getAnchorLocation().getY());
        }
    }


    @Override
    public Coordinate2D getAnchorLocation() {
        return super.getAnchorLocation();
    }


    // 800 x 1024 / 35
    public void jump(Player p) {
        double jumpStrength = 4;

        if (p instanceof Fireboy && p.isOnground) {
            setMotion(jumpStrength, 180d);
            p.isOnground = false;
        }
        if (p instanceof Watergirl && p.isOnground) {
            setMotion(jumpStrength, 180d);
            p.isOnground = false;
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
