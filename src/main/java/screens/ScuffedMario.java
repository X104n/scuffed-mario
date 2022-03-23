package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.GameScreen;

public class ScuffedMario extends Game {

    public static final float PPM = 10f;

    // Can be used to create front in the future.
    public BitmapFont font;

    @Override
    public void create() {
        this.setScreen(new GameScreen(this));
    }

    public void render(){super.render();}

    public void dispose(){
    }
}

