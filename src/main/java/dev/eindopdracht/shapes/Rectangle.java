package dev.eindopdracht.shapes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Rectangle extends RectangleEntity {

    public Rectangle(Coordinate2D coordinate2D, AnchorPoint anchorPoint, double width, double height, Color fill, double opacity, double arcwidth, double archeight) {
        super(coordinate2D);
        setAnchorPoint(anchorPoint);
        setOpacity(opacity);
        setArcHeight(archeight);
        setArcWidth(arcwidth);
        setWidth(width);
        setHeight(height);
        setFill(fill);
    }
}