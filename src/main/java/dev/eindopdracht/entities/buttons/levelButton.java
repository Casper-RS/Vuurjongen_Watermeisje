package dev.eindopdracht.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import dev.eindopdracht.VuurjongenWatermeisje;
import javafx.scene.input.MouseButton;

public class levelButton extends BaseButton {

    private final VuurjongenWatermeisje vuurjongenWatermeisje;

    public levelButton(Coordinate2D initialPosition, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(initialPosition, "Levels");
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        vuurjongenWatermeisje.setActiveScene(101);
    }
}
