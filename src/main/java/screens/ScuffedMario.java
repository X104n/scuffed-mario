package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ScuffedMario extends Game {



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

