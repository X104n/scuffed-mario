package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import desktop.DesktopLauncher;
import org.lwjgl.opengl.GL20;

public class MainMenu implements Screen {
    private static final int EXIT_BUTTON_WIDTH = 300;
    private static final int EXIT_BUTTON_HEIGHT = 150;
    private static final int EXIT_BUTTON_Y = 50;

    private static final int PLAY_BUTTON_WIDTH = 330;
    private static final int PLAY_BUTTON_HEIGHT = 150;
    private static final int PLAY_BUTTON_Y = 250;

    private static final int SETTINGS_BUTTON_WIDTH = 300;
    private static final int SETTINGS_BUTTON_HEIGHT = 150;

    SpriteBatch batch;
    ScuffedMario mario;
    OrthographicCamera camera;
    Viewport viewport;
    Stage stage;

    Music backgroundMusic;

    Texture exitButton;
    Texture activeExitButton;
    Texture playButton;
    Texture activePlayButton;
    Texture settingsButton;
    Texture activeSettingsButton;
    Texture background;

    public MainMenu(ScuffedMario mario, OrthographicCamera camera) {
        viewport = new FitViewport(DesktopLauncher.width, DesktopLauncher.height, camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/thomas.mp3"));
        backgroundMusic.setLooping(true);

        this.batch = new SpriteBatch();
        this.mario = mario;
        this.camera = camera;

        stage = new Stage(viewport, batch);

        playButton = new Texture("assets/Buttons/play.png");
        activePlayButton = new Texture("assets/Buttons/active_play.png");

        exitButton = new Texture("assets/Buttons/exit.png");
        activeExitButton = new Texture("assets/Buttons/active_exit.png");

        settingsButton = new Texture("assets/Buttons/settings.png");
        activeSettingsButton = new Texture("assets/Buttons/active_settings.png");

        background = new Texture("assets/Images/thomas.jpg");
    }
    @Override
    public void show() {
        backgroundMusic.play();
        backgroundMusic.setVolume(0.01f); // sets volume to 1%
    }

    @Override
    public void render(float v) {
        batch.begin();
        batch.draw(background, 0, 0, DesktopLauncher.width, DesktopLauncher.height);
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int x = (int) (camera.viewportWidth / 2 - PLAY_BUTTON_WIDTH / 2);
        if (checkMouseHover(x, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT, EXIT_BUTTON_Y)) {
            batch.draw(activeExitButton, (float) DesktopLauncher.width / 2 - (float) DesktopLauncher.height / 2, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if (Gdx.input.isButtonPressed(0)) {
                Gdx.app.exit();
            }
        } else {
            batch.draw(exitButton, (float) DesktopLauncher.width / 2 - (float) DesktopLauncher.height / 2, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }

        int i = (int) (camera.viewportWidth / 2 - PLAY_BUTTON_WIDTH / 2);
        if (checkMouseHover(i, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT, PLAY_BUTTON_Y)) {
            batch.draw(activePlayButton, (float) DesktopLauncher.width / 2 - (float) DesktopLauncher.height / 2, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
            if (Gdx.input.isButtonPressed(0)) {
                this.dispose();
                mario.setScreen(new GameScreen(camera)); // problem here
            }
        } else {
            batch.draw(playButton, (float) DesktopLauncher.width / 2 - (float) DesktopLauncher.height / 2, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }

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

    /**
     * Checks if the mouse is hovering over the button
     * @param x the x coordinate of the button
     * @param width the width of the button
     * @param height the height of the button
     * @param y the y coordinate of the button
     * @return true if the mouse is hovering over the button, false otherwise
     */
    private boolean checkMouseHover(int x, int width, int height, int y) {
        return Gdx.input.getX() < x + width && Gdx.input.getX() > x && DesktopLauncher.height - Gdx.input.getY() < y + height && DesktopLauncher.height - Gdx.input.getY() > y;
    }

    @Override
    public void dispose() {
        background.dispose();
        batch.dispose();
        backgroundMusic.dispose();
    }
}