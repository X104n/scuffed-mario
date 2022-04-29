package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public class ScuffedMario extends Game {

    public static ScuffedMario INSTANCE;
    private int widthScreen, heightScreen;
    private OrthographicCamera orthographicCamera;
    public MainMenu menu;
    public SpriteBatch batch;
    public GameScreen game;

    public List<String> levels = List.of("assets/Map/level1.tmx", "assets/Map/level2.tmx","assets/Map/level3.tmx");

    public ScuffedMario(){
        INSTANCE = this;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        setScreen(new MainMenu(INSTANCE, orthographicCamera));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    public GameScreen getGame() {
        return game;
    }

    public OrthographicCamera getOrthographicCamera() {
        return this.orthographicCamera;
    }
}

