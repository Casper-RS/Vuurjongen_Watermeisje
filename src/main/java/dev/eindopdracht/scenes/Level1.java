package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.map.Level_1;
import dev.eindopdracht.entities.sprite.dynamic.Fireboy;
import dev.eindopdracht.entities.sprite.dynamic.Watergirl;

public class Level1 extends DynamicScene implements TileMapContainer {
    private VuurjongenWatermeisje vuurjongenWatermeisje;

    public Level1(VuurjongenWatermeisje vuurjongenWatermeisje) {
        this.vuurjongenWatermeisje = vuurjongenWatermeisje;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.png");

    }
    @Override
    public void setupTileMaps() {
        addTileMap(new Level_1());
    }

    @Override
    public void setupEntities() {

        var fireboy = new Fireboy(new Coordinate2D(getWidth() / 2, getHeight() / 2), vuurjongenWatermeisje);
        addEntity(fireboy);

        var watergirl = new Watergirl(new Coordinate2D(getWidth() / 2, getHeight() / 2), vuurjongenWatermeisje);
        addEntity(watergirl);
    }
}
