package dev.eindopdracht.entities.GameObjects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.List;

public abstract class Gemstone extends SpriteEntity implements Collided {


    protected Gemstone(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public abstract void onCollision(List<Collider> collidingObjects);
}
