package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.StaticScene;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.sprite.dynamic.Fireboy;
import dev.eindopdracht.entities.sprite.dynamic.Player;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private VuurjongenWatermeisje vuurjongenWatermeisje;

    public TitleScene(VuurjongenWatermeisje vuurjongenWatermeisje){

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
    }
}
