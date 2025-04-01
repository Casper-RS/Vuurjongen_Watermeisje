package dev.eindopdracht.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import dev.eindopdracht.VuurjongenWatermeisje;
import dev.eindopdracht.entities.GameObjects.EscapeDoor;
import dev.eindopdracht.entities.GameObjects.FireboyGemstone;
import dev.eindopdracht.entities.GameObjects.WatergirlGemstone;
import dev.eindopdracht.entities.map.Level_1;

public class Level1 extends LevelCreator implements TileMapContainer {

    VuurjongenWatermeisje v;

    public Level1(VuurjongenWatermeisje v) {
        super(v);
        this.v = v;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/1.png");

    }
    @Override
    public void setupTileMaps() {
        addTileMap(new Level_1());
    }

    @Override
    public void setupEntities() {
        createCharacters(20, 20);
        createUI();

        var fireboyGem = new FireboyGemstone(new Coordinate2D(450, 700), this);
        addEntity(fireboyGem);

        var watergirlGem = new WatergirlGemstone(new Coordinate2D(400, 700), this);
        addEntity(watergirlGem);

        var escapeDoor = new EscapeDoor(new Coordinate2D(100, 700), this, v);
        addEntity(escapeDoor);
    }
}
