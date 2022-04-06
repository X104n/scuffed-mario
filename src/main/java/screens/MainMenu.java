package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import desktop.DesktopLauncher;
import org.lwjgl.opengl.GL20;

public class MainMenu implements Screen {
    Music backgroundMusic;
    private static final int EXIT_BUTTON_WIDTH = 300;
    private static final int EXIT_BUTTON_HEIGHT = 150;
    private static final int EXIT_BUTTON_Y = 100;

    private static final int PLAY_BUTTON_WIDTH = 330;
    private static final int PLAY_BUTTON_HEIGHT = 150;
    private static final int PLAY_BUTTON_Y = 300;


    private static final int SETTINGS_BUTTON_WIDTH = 300;
    private static final int SETTINGS_BUTTON_HEIGHT = 300;

    SpriteBatch batch;
    ScuffedMario mario;

    Texture exitButton;
    Texture activeExitButton;
    Texture playButton;
    Texture activePlayButton;
    Texture settingsButton;
    Texture activeSettingsButton;

    public MainMenu(ScuffedMario mario) {
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/thomas.mp3"));
        backgroundMusic.setLooping(true);

        this.batch = new SpriteBatch();
        this.mario = mario;

        playButton = new Texture("assets/Buttons/play.png");
        activePlayButton = new Texture("assets/Buttons/active_play.png");

        exitButton = new Texture("assets/Buttons/exit.png");
        activeExitButton = new Texture("assets/Buttons/active_exit.png");

        settingsButton = new Texture("assets/Buttons/settings.png");
        activeSettingsButton = new Texture("assets/Buttons/active_settings.png");
    }
    @Override
    public void show() {
        //backgroundMusic.play();
        backgroundMusic.setVolume(0.1f); // sets volume to 10%
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        int x = DesktopLauncher.width / 2 - DesktopLauncher.height / 2; // center of the screen, used to center the buttons
        if (checkMouseHover(x)) {
            batch.draw(activePlayButton, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        } else {
            batch.draw(playButton, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }
        batch.end();
    }

    /**
     * Checks if the mouse is hovering over the button
     * @param x the x coordinate of the button
     *          (the center of the button)
     * @return true if the mouse is hovering over the button
     */
    private boolean checkMouseHover(int x) {
        if (Gdx.input.getX() < x + PLAY_BUTTON_WIDTH){
            if (Gdx.input.getX() > x){
                if (Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT){
                    return Gdx.input.getY() > PLAY_BUTTON_Y;
                }
            }
        }
        return false;
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
        backgroundMusic.dispose();
    }
}
