package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;

public class Watergirl extends Player{
    public Watergirl(Coordinate2D location) {
        super("sprites/watergirl.png", location);
    }

    @Override
    public void onCollision() {

    }
}
