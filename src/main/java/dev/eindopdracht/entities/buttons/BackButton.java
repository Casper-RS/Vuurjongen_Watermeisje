package dev.eindopdracht.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import dev.eindopdracht.VuurjongenWatermeisje;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class BackButton extends BaseButton {

    private final VuurjongenWatermeisje vuurjongenWatermeisje;
    private int sceneID;

    public BackButton(Coordinate2D initialPosition, int sceneID, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(initialPosition, "X");
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
        this.sceneID = sceneID;
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.DARKRED);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.RED);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        vuurjongenWatermeisje.setActiveScene(sceneID);
    }
}
