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
import dev.eindopdracht.entities.map.Door;
import dev.eindopdracht.entities.map.Wall;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider, Collided {
    public boolean isOnground = true;
    private final double speed = 1;
    private VuurjongenWatermeisje vuurjongenWatermeisje;

    public Player(String resource, Coordinate2D location, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(resource, location, new Size(30, 45), 1, 1);
        setGravityConstant(0.12);
        setFrictionConstant(0.04);
    }


    @Override
    public void onCollision(List<Collider> collidingObjects) {
        isOnground = false; // Reset every frame

        for (Collider collider : collidingObjects) {
            if (collider instanceof Door door){
                vuurjongenWatermeisje.setActiveScene(0);
                System.out.println("Deur geraakt");
            }
            if (collider instanceof Wall wall) {
                var wallBox = wall.getBoundingBox();
                var playerBox = this.getBoundingBox();

                double overlapTop = Math.abs(playerBox.getMaxY() - wallBox.getMinY());
                double overlapBottom = Math.abs(playerBox.getMinY() - wallBox.getMaxY());
                double overlapLeft = Math.abs(playerBox.getMaxX() - wallBox.getMinX());
                double overlapRight = Math.abs(playerBox.getMinX() - wallBox.getMaxX());

                double smallestOverlap = Math.min(Math.min(overlapTop, overlapBottom), Math.min(overlapLeft, overlapRight));

                // ============ TOP COLLISION ============
                if (smallestOverlap == overlapTop) {
                    isOnground = true;
                    setAnchorLocationY(wallBox.getMinY() - getHeight() - 0.5); // margin added
                    setMotion(0, 0);
                }

                // ============ BOTTOM COLLISION ============
                if (smallestOverlap == overlapBottom) {
                    setAnchorLocationY(wallBox.getMaxY() + 0.5); // small push down
                    // Allow falling
                }

                // ============ LEFT COLLISION ============
                if (smallestOverlap == overlapLeft) {
                    setAnchorLocationX(wallBox.getMinX() - getWidth() - 0.5); // small push left
                    // Allow falling
                }

                // ============ RIGHT COLLISION ============
                if (smallestOverlap == overlapRight) {
                    setAnchorLocationX(wallBox.getMaxX() + 0.5); // small push right
                    // Allow falling
                }
            }
        }
    }

    public final void moveLeft(boolean verbose) {
        //check 1 pixel voor kant die de speler oploopt
        if (getAnchorLocation().getX() - 1 >= 12) {
            setMotion(speed, 270d);
            if (verbose) {
                System.out.println("Bewogen naar:");
                System.out.println("X-Pos: " + getAnchorLocation().getX());
                System.out.println("Y-Pos: " + getAnchorLocation().getY());
            }
        }
    }

    public final void moveRight(boolean verbose) {
        //check 1 pixel voor kant die de speler oploopt
        if (getAnchorLocation().getX() + 1 >= getWidth() - 50) {
            setMotion(speed, 90d);
            if (verbose) {
                System.out.println("Bewogen naar:");
                System.out.println("X-Pos: " + getAnchorLocation().getX());
                System.out.println("Y-Pos: " + getAnchorLocation().getY());
            }
        }
    }


    @Override
    public Coordinate2D getAnchorLocation() {
        return super.getAnchorLocation();
    }


    // 800 x 1024 / 35
    public void jump(Player p) {
        double jumpStrength = 7;

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
                if (getAnchorLocation().getX() < 0) {
                    setSpeed(0); // stop leftward movement
                }
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                if (getAnchorLocation().getX() > 0) {
                    setSpeed(0); // stop rightward movement
                }
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        handleMovement(pressedKeys);
    }

    public void handleMovement(Set<KeyCode> pressedKeys) {
    }
}
