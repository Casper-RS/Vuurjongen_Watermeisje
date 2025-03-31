package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.buttons.BackButton;
import dev.eindopdracht.entities.buttons.SelectLevelButton;
import dev.eindopdracht.entities.sprite.fixed.GameImage;
import dev.eindopdracht.entities.sprite.fixed.ImageLoader;
import dev.eindopdracht.shapes.Circle;
import dev.eindopdracht.shapes.Rectangle;
import javafx.scene.paint.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class levelScene extends DynamicScene {

    private VuurjongenWatermeisje vuurjongenWatermeisje;
    private static double MARGIN;

    private int[] starsObtained = {0, 0, 0};

    private List<String> levelImages;

    public levelScene(VuurjongenWatermeisje v) {
        this.vuurjongenWatermeisje = v;
        //this.levelImages = ImageLoader.getImagePaths("C:\\Users\\Daan van Vliet\\Documents\\GitHub\\Vuurjongen_Watermeisje\\src\\main\\resources\\LevelImages");
        this.levelImages = ImageLoader.getImagePaths("resources/LevelImages");
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.png");
    }

    @Override
    public void setupEntities() {

        double numBoxes = 3;
        double sectionWidth = getWidth() / numBoxes;
        double yPosition = getHeight() / 2;

        for (int i = 0; i < numBoxes; i++) {
            createLevelBox(new Coordinate2D(sectionWidth * (i + 0.5), yPosition), starsObtained[i], i + 1);
        }

        addBackButton(0);
    }

    public void createLevelBox(Coordinate2D position, int starsObtained, int levelNumber) {

        MARGIN = getWidth() / 30;

        double boxWidth = getWidth() / 4;
        double boxHeight = getHeight() / 4 * 3;

        var levelBox = new Rectangle(position, AnchorPoint.CENTER_CENTER, boxWidth, boxHeight,
                Color.DARKSLATEGRAY, 0.6, 15, 15);
        addEntity(levelBox);

        displayStars(position, starsObtained);

        displayImage(position, levelNumber, boxWidth);

        addLevelButton(position, levelNumber);
    }

    private void displayStars(Coordinate2D boxCenter, int starsObtained) {

        double starRadius = 15;
        double spacing = 40;
        double startX = boxCenter.getX() - spacing;
        double startY = boxCenter.getY() - getHeight() / 5;

        for (int i = 0; i < 3; i++) {
            boolean filled = i < starsObtained;
            Color fillColor = filled ? Color.YELLOW : Color.GRAY;

            Circle starCircle = new Circle(new Coordinate2D(startX + (i * spacing), startY), starRadius, fillColor);
            addEntity(starCircle);
        }
    }

    private void displayImage(Coordinate2D boxCenter, int levelNumber, double boxWidth) {

        //String path = (levelNumber - 1 < levelImages.size()) ? levelImages.get(levelNumber - 1) : "LevelImages/default.png";
        String path = "LevelImages/" + levelNumber + ".jpg";

        GameImage myImage = new GameImage(path, boxCenter, 150, new Size(boxWidth * 0.8, (boxWidth * 0.8) / 2 ));
        myImage.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(myImage);
    }

    private void addLevelButton(Coordinate2D boxCenter, int levelNumber) {
        double buttonY = boxCenter.getY() + getHeight() / 6;
        SelectLevelButton levelButton = new SelectLevelButton(new Coordinate2D(boxCenter.getX(), buttonY), levelNumber, vuurjongenWatermeisje);
        addEntity(levelButton);
    }

    private void addBackButton(int sceneID) {
        BackButton backButton = new BackButton(new Coordinate2D(getWidth() / 50, getHeight() / 50), sceneID, vuurjongenWatermeisje);
        addEntity(backButton);
    }
}
