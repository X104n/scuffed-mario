package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ScuffedMario extends Game {

    public static ScuffedMario INSTANCE;
    private OrthographicCamera orthographicCamera;
    public GameScreen game;

    public ScuffedMario(){
        INSTANCE = this;
    }

    @Override
    public void create() {
        int widthScreen = Gdx.graphics.getWidth();
        int heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        game = new GameScreen(orthographicCamera);
        setScreen(game);
    }

    public GameScreen getGame() {
        return game;
    }

    public OrthographicCamera getOrthographicCamera() {
        return this.orthographicCamera;
    }
}

