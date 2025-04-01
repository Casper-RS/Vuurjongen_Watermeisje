package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.buttons.BackButton;
import dev.eindopdracht.entities.sprite.dynamic.Fireboy;
import dev.eindopdracht.entities.sprite.dynamic.Watergirl;

public abstract class LevelCreator extends DynamicScene implements TileMapContainer {
    protected VuurjongenWatermeisje vuurjongenWatermeisje;

    public boolean watergirlGemstoneObtained = false;
    public boolean fireboyGemstoneObtained = false;

    public LevelCreator(VuurjongenWatermeisje v) {
        this.vuurjongenWatermeisje = v;
    }
    @Override
    public abstract void setupTileMaps();

    @Override
    public abstract void setupScene();

    @Override
    public abstract void setupEntities();

    public void createUI() {
        BackButton backButton = new BackButton(new Coordinate2D(getWidth() / 50, getHeight() / 50), 0, vuurjongenWatermeisje);
        addEntity(backButton);
    }

    public void createCharacters(double x, double y) {
        var fireboy = new Fireboy(new Coordinate2D(getWidth() / 2, getHeight() / 2), vuurjongenWatermeisje);
        addEntity(fireboy);

        var watergirl = new Watergirl(new Coordinate2D(getWidth() / 2, getHeight() / 2), vuurjongenWatermeisje);
        addEntity(watergirl);
    }
}
