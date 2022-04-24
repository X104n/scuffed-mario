package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScuffedMario extends Game {

    public static ScuffedMario INSTANCE;
    private int widthScreen, heightScreen;
    private OrthographicCamera orthographicCamera;
    public SpriteBatch batch;

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
        //setScreen(new GameScreen(orthographicCamera));
        setScreen(new MainMenu(this, orthographicCamera));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

