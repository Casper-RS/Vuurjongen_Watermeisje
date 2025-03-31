package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.scenes.TileMapContainer;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.map.Level_1;
import dev.eindopdracht.entities.map.Level_2;

public class Level2 extends LevelCreator implements TileMapContainer {

    public Level2(VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(vuurjongenWatermeisje);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.png");

    }
    @Override
    public void setupTileMaps() {
        addTileMap(new Level_2());
    }

    @Override
    public void setupEntities() {
        createCharacters(20, 20);
    }
}