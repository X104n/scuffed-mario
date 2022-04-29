package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class ScuffedMario extends Game {

    public static ScuffedMario INSTANCE;
    private int widthScreen, heightScreen;
    private OrthographicCamera orthographicCamera;
    public MainMenu menu;

    public ScuffedMario(){
        INSTANCE = this;
    }

    @Override
    public void create() {
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        menu = new MainMenu(this, orthographicCamera);
        //setScreen(new GameScreen(orthographicCamera));
        setScreen(new MainMenu(this, orthographicCamera));
    }

    public GameScreen getGame (){
        return menu.getGame();
    }

    public MainMenu getMenu() {
        return menu;
    }
}

