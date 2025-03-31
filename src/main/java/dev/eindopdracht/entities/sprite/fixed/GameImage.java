package dev.eindopdracht.entities.sprite.fixed;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;

public class GameImage extends SpriteEntity {

    public GameImage(String imagePath, Coordinate2D location, double cornerRadius, Size size) {
        super(imagePath, location, size);
        applyRoundedCorners(cornerRadius);
    }

    private void applyRoundedCorners(double cornerRadius) {
        GaussianBlur blur = new GaussianBlur(cornerRadius);
        DropShadow dropShadow = new DropShadow(cornerRadius, Color.BLACK);
        dropShadow.setSpread(0.2);
        // Rip
    }
}
