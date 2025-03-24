package dev.eindopdracht.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import dev.eindopdracht.VuurjongenWatermeisje;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private final VuurjongenWatermeisje vuurjongenWatermeisje;

    public StartButton(Coordinate2D initialPosition, VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(initialPosition, "Play Game");
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
        setFill(Color.ORANGE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        vuurjongenWatermeisje.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.ORANGERED);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.ORANGE);
        setCursor(Cursor.DEFAULT);
    }
}