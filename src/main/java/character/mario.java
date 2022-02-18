package character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import screens.GameScreen;
import screens.ScuffedMario;

public class mario extends GameScreen {
    public mario(ScuffedMario game) {
        super(game);

        Stage stage;
        SpriteBatch batch;
        Texture player;

        float playerX = 0;
        float playerY = 0;
        float Speed = 50.0f;
    }
    @Override
    public void show() {
    }
}
