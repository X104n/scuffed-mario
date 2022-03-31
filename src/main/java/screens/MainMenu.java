package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.lwjgl.opengl.GL20;

public class MainMenu implements Screen {
    SpriteBatch batch;
    OrthographicCamera camera;
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
        batch.draw(playButton, 100, 100);
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
