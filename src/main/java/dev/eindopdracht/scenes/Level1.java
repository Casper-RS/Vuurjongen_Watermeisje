package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.scenes.TileMapContainer;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.map.Level_1;

public class Level1 extends LevelCreator implements TileMapContainer {

    public Level1(VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(vuurjongenWatermeisje);
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
        createCharacters(20, 20);
    }
}
