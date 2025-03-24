package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.sprite.dynamic.Fireboy;

public class testScene extends DynamicScene {
    private VuurjongenWatermeisje vuurjongenWatermeisje;

    public testScene(VuurjongenWatermeisje vuurjongenWatermeisje) {
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.png");

    }

    @Override
    public void setupEntities() {
        var fireboy = new Fireboy(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(fireboy);
    }
}
