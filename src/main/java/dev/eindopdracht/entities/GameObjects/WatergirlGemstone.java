package dev.eindopdracht.entities.GameObjects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import dev.eindopdracht.entities.sprite.dynamic.Watergirl;
import dev.eindopdracht.scenes.LevelCreator;

import java.util.List;

public class WatergirlGemstone extends Gemstone {

    LevelCreator level;

    public WatergirlGemstone(Coordinate2D initialLocation, LevelCreator level) {
        super("sprites/WatergirlGemstone.png", initialLocation);
        this.level = level;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider c : collidingObjects) {
            if (c instanceof Watergirl) {
                level.watergirlGemstoneObtained = true;

                System.out.println(level.watergirlGemstoneObtained);
            }
        }
    }
}
