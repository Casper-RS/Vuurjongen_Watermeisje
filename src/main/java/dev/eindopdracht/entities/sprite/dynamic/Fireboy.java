package dev.eindopdracht.entities.sprite.dynamic;

import com.github.hanyaeger.api.Coordinate2D;

public class Fireboy extends Player{
    public Fireboy(Coordinate2D location) {
        super("sprites/fireboy.png", location);
    }

    @Override
    public void onCollision() {

    }
}

