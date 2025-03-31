package dev.eindopdracht.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.scenes.TitleScene;
import javafx.scene.input.MouseButton;

public class StartButton extends BaseButton {

    private final VuurjongenWatermeisje vuurjongenWatermeisje;

    public StartButton(Coordinate2D initialPosition, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(initialPosition, "Play Game");
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        vuurjongenWatermeisje.setActiveScene(TitleScene.getLevelSelection());
    }
}