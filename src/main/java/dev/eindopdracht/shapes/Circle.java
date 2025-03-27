package dev.eindopdracht.shapes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.Optional;

public class Circle extends YaegerEntity {

    private final Polygon star;

    public Circle(Coordinate2D position, double size, Color color) {
        super(position);
        this.star = createStar(size, color);
    }

    protected Circle(Coordinate2D initialLocation, Polygon star) {
        super(initialLocation);
        this.star = star;
    }

    private Polygon createStar(double size, Color color) {
        Polygon star = new Polygon();
        Double[] points = {
                0.0, -size,
                size * 0.3, -size * 0.3,
                size, 0.0,
                size * 0.3, size * 0.3,
                0.0, size,
                -size * 0.3, size * 0.3,
                -size, 0.0,
                -size * 0.3, -size * 0.3
        };
        star.getPoints().addAll(points);
        star.setFill(Color.YELLOW);
        return star;
    }

        @Override
    public Optional<? extends Node> getNode() {
        return Optional.of(star);
    }
}