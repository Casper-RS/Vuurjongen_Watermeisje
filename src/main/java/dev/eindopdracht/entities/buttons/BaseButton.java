package dev.eindopdracht.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class BaseButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    protected BaseButton(Coordinate2D initialPosition, String text) {
        super(initialPosition, text);
        setFill(Color.ORANGE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    public void onMouseEntered() {
        setFill(Color.ORANGERED);
        setCursor(Cursor.HAND);
    }

    public void onMouseExited() {
        setFill(Color.ORANGE);
        setCursor(Cursor.DEFAULT);
    }

    public abstract void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D);
}
