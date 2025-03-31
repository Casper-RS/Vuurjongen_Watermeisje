package dev.eindopdracht.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Door extends SpriteEntity implements Collider {

    public Door(final Coordinate2D location, final Size size, final String resource) {
        super(resource, location, size);
    }

}
