package dev.eindopdracht.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.scenes.TitleScene;
import javafx.scene.input.MouseButton;

public class SelectLevelButton extends BaseButton {

    private final VuurjongenWatermeisje vuurjongenWatermeisje;
    private final int levelNumber;

    public SelectLevelButton(Coordinate2D initialPosition, int levelNumber, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(initialPosition, "Level " + levelNumber);
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
        this.levelNumber = levelNumber;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }


    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        TitleScene.setLevelSelection(levelNumber);
    }
}