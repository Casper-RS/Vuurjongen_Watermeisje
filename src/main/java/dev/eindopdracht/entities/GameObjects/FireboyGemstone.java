package dev.eindopdracht.entities.GameObjects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import dev.eindopdracht.entities.sprite.dynamic.Fireboy;
import dev.eindopdracht.scenes.LevelCreator;

import java.util.List;

public class FireboyGemstone extends Gemstone {

    LevelCreator level;

    public FireboyGemstone(Coordinate2D initialLocation, LevelCreator level) {
        super("sprites/FireboyGemstone.png", initialLocation);
        this.level = level;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider c : collidingObjects) {
            if (c instanceof Fireboy) {
                level.fireboyGemstoneObtained = true;

                System.out.println(level.fireboyGemstoneObtained);
            }
        }
    }
}
