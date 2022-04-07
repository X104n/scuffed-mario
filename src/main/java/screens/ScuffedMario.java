package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ScuffedMario extends Game {

    public static ScuffedMario INSTANCE;
    private int widthScreen, heightScreen;
    private OrthographicCamera orthographicCamera;

    public ScuffedMario(){
        INSTANCE = this;
    }

    @Override
    public void create() {
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        //setScreen(new GameScreen(orthographicCamera));
        setScreen(new MainMenu(this, orthographicCamera));
    }
}

