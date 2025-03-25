package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.buttons.StartButton;
import dev.eindopdracht.entities.buttons.levelButton;
import dev.eindopdracht.shapes.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private VuurjongenWatermeisje vuurjongenWatermeisje;

    public TitleScene(VuurjongenWatermeisje vuurjongenWatermeisje){
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.png");
    }

    @Override
    public void setupEntities(){
        var fireBoy = new TextEntity(
                new Coordinate2D(getWidth() / 4, getHeight() / 6),"Vuurjongen");
        fireBoy.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        fireBoy.setFill(Color.CRIMSON);
        fireBoy.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        addEntity(fireBoy);

        var watergirl = new TextEntity(
                new Coordinate2D(getWidth() - getWidth()/ 4, getHeight() / 6),"Watermeisje");
        watergirl.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        watergirl.setFill(Color.AQUA);
        watergirl.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        addEntity(watergirl);


        var andSymbol = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 6),"&");
        andSymbol.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        andSymbol.setFill(Color.DARKGRAY);
        andSymbol.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        addEntity(andSymbol);

        var selectLevelBorder = new Rectangle(new Coordinate2D(getWidth() / 2, getHeight() - getHeight() / 3),
                AnchorPoint.CENTER_CENTER,
                300, 60,
                Color.DARKSLATEGRAY,
                0.6,
                15,
                15);

        addEntity(selectLevelBorder);

        var selectLevelText = new levelButton(new Coordinate2D(getWidth() / 2, getHeight() - getHeight() / 3), vuurjongenWatermeisje);
        selectLevelText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(selectLevelText);

        var playGameBorder = new Rectangle(new Coordinate2D(getWidth() / 2, getHeight() - getHeight() / 5),
                AnchorPoint.CENTER_CENTER,
                300, 60,
                Color.DARKSLATEGRAY,
                0.6,
                15,
                15);


        addEntity(playGameBorder);

        var playGameText = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() - getHeight()/ 5), vuurjongenWatermeisje);
        playGameText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playGameText);
    }
}
