package dev.eindopdracht.shapes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import javafx.scene.paint.Color;

public class Circle extends CircleEntity {

    public Circle(Coordinate2D initialLocation, double radius, Color color) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRadius(radius);
        setFill(color);
    }
}