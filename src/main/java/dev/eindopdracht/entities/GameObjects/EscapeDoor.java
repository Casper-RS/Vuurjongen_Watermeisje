package dev.eindopdracht.entities.GameObjects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.sprite.dynamic.Fireboy;
import dev.eindopdracht.entities.sprite.dynamic.Watergirl;
import dev.eindopdracht.scenes.LevelCreator;

import java.util.List;

public class EscapeDoor extends SpriteEntity implements Collided {
    LevelCreator level;
    VuurjongenWatermeisje v;

    public EscapeDoor(Coordinate2D initialLocation, LevelCreator level, VuurjongenWatermeisje v) {
        super("sprites/door.png", initialLocation);
        this.level = level;
        this.v = v;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        boolean fb = false;
        boolean wg = false;

        for (Collider c : collidingObjects) {
            if (c instanceof Watergirl) {
                wg = true;
            }
            if (c instanceof Fireboy) {
                fb = true;
            }
        }
        if (fb && wg) {
            if (level.fireboyGemstoneObtained && level.watergirlGemstoneObtained) {
                v.starsObtained[0] = 3;
            }
            v.setActiveScene(0);
        }
    }
}
