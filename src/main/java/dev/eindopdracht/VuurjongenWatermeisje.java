package dev.eindopdracht;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import dev.eindopdracht.scenes.*;

public class VuurjongenWatermeisje extends YaegerGame {

    public int[] starsObtained = {0, 0, 0};

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Vuurjongen & Watermeisje");
        setSize(new Size(1024, 800));
    }

    @Override
    public void setupScenes(){

        //titlescene
        addScene(0, new TitleScene(this));

        //levelscenes
        addScene(1, new Level1(this));
        addScene(2, new Level2(this));
        addScene(3, new Level3(this));

        //menu's
        addScene(101, new levelScene(this));
    }
}