package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.lwjgl.opengl.GL20;

public class MainMenu implements Screen {
    private static final int EXIT_BUTTON_WIDTH = 300;
    private static final int EXIT_BUTTON_HEIGHT = 150;

    private static final int PLAY_BUTTON_WIDTH = 330;
    private static final int PLAY_BUTTON_HEIGHT = 150;

    private static final int SETTINGS_BUTTON_WIDTH = 300;
    private static final int SETTINGS_BUTTON_HEIGHT = 300;

    SpriteBatch batch;
    ScuffedMario mario;

    Texture exitButton;
    Texture playButton;
    Texture settingsButton;

    public MainMenu(ScuffedMario mario) {
        this.batch = new SpriteBatch();
        this.mario = mario;
        playButton = new Texture("assets/Images/black_box.png");
        exitButton = new Texture("assets/Images/black_box1.png");
        settingsButton = new Texture("assets/Images/black_box2.png");
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        // 800, and 480 is form width and height on game window
        // to center the button
        batch.draw(playButton, 800/2 - 480/2, 100, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
