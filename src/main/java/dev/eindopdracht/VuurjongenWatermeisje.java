package dev.eindopdracht;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import dev.eindopdracht.scenes.Level1;
import dev.eindopdracht.scenes.TitleScene;
import dev.eindopdracht.scenes.levelScene;

public class VuurjongenWatermeisje extends YaegerGame {
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

        //others
        addScene(101, new levelScene(this));
    }
}