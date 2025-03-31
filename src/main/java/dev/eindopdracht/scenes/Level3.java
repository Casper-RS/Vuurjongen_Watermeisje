package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.scenes.TileMapContainer;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.map.Level_1;

public class Level3 extends LevelCreator implements TileMapContainer {

    public Level3(VuurjongenWatermeisje vuurjongenWatermeisje) {
        super(vuurjongenWatermeisje);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.png");

    }
    @Override
    public void setupTileMaps() {
        addTileMap(new Level_3());
    }

    @Override
    public void setupEntities() {
        createCharacters();
    }
}