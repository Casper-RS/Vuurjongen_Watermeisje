package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.shapes.Circle;
import dev.eindopdracht.shapes.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class levelScene extends DynamicScene {

    private VuurjongenWatermeisje vuurjongenWatermeisje;
    private static double MARGIN;

    public levelScene(VuurjongenWatermeisje v) {
        this.vuurjongenWatermeisje = v;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.png");
    }

    @Override
    public void setupEntities() {

        MARGIN = getWidth() / 30;

        double numBoxes = 3;
        double sectionWidth = getWidth() / numBoxes;
        double boxWidth = getWidth() / 4;
        double boxHeight = getHeight() / 4 * 3;
        double yPosition = getHeight() / 2;

        var firstLevelBox = new Rectangle(new Coordinate2D(sectionWidth * 0.5, yPosition),
                AnchorPoint.CENTER_CENTER,
                boxWidth, boxHeight,
                Color.DARKSLATEGRAY,
                0.6,
                15,
                15);

        var secondLevelBox = new Rectangle(new Coordinate2D(sectionWidth * 1.5, yPosition),
                AnchorPoint.CENTER_CENTER,
                boxWidth, boxHeight,
                Color.DARKSLATEGRAY,
                0.6,
                15,
                15);

        var thirdLevelBox = new Rectangle(new Coordinate2D(sectionWidth * 2.5, yPosition),
                AnchorPoint.CENTER_CENTER,
                boxWidth, boxHeight,
                Color.DARKSLATEGRAY,
                0.6,
                15,
                15);

        var star = new Circle(new Coordinate2D(500, 500), 40, Color.YELLOW);
        addEntity(star);

        addEntity(firstLevelBox);
        addEntity(secondLevelBox);
        addEntity(thirdLevelBox);
    }
}
