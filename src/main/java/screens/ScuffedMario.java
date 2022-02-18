package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.GameScreen;

public class ScuffedMario extends Game {

    // We should only use one sprite batch, so we make this one public.
    public SpriteBatch batch;

    // Can be used to create front in the future.
    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();

        this.setScreen(new GameScreen(this));
    }

    public void render(){super.render();}

    public void dispose(){
        batch.dispose();
    }
}

