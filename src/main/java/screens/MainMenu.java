package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import desktop.DesktopLauncher;
import screens.OptionScreen;

import java.awt.*;

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
    OrthographicCamera camera;
    SpriteBatch batch;
    ScuffedMario mario;
    Skin skin;
    TextureAtlas textureAtlas;

    Music backgroundMusic;
    Texture background;


    public MainMenu(ScuffedMario mario, OrthographicCamera camera) {
        this.mario = mario;
        this.camera = camera;
        this.batch = new SpriteBatch();

        textureAtlas = new TextureAtlas(Gdx.files.internal("assets/UI/uiskin.atlas"));
        skin = new Skin(Gdx.files.internal("assets/UI/uiskin.json"));
        skin.addRegions(textureAtlas);
        //Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        viewport = new FitViewport(DesktopLauncher.width, DesktopLauncher.height, new OrthographicCamera());
        viewport.apply();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        batch.setProjectionMatrix(camera.combined);
        camera.update();

        stage = new Stage(viewport, batch);

        background = new Texture("assets/Images/thomas.jpg");
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/thomas.mp3"));
    }

    @Override
    public void show() {
        backgroundMusic.play();
        System.out.println("menuVolume from options: " + OptionScreen.menuVolume);
        backgroundMusic.setVolume(OptionScreen.menuVolume); // set the menu volume to the volume from the options screen
        backgroundMusic.setLooping(true);

        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton playButton = new TextButton("Play", skin);
        TextButton optionButton = new TextButton("Options", skin);
        TextButton controlsButton = new TextButton("Controls", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                mario.setScreen(new GameScreen(mario, camera, 0, true)); // sets the screen to the game screen
            }
        });
        optionButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                mario.setScreen(new OptionScreen(mario, camera)); // sets the screen to the option screen
            }
        });
        controlsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                mario.setScreen(new ControlScreen(mario, camera)); // sets the screen to the control screen
            }
        });
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        table.add(playButton).expandX().pad(10).size(100, 50);
        table.row();
        table.add(optionButton).expandX().pad(10).size(100, 50);
        table.row();
        table.add(controlsButton).expandX().pad(10).size(100, 50);
        table.row();
        table.add(exitButton).expandX().pad(10).size(100, 50);

        stage.addActor(table);
    }


    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, DesktopLauncher.width, DesktopLauncher.height);
        stage.getBatch().end();

        stage.act();
        stage.draw();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
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
        stage.getViewport().update(DesktopLauncher.width,DesktopLauncher.height);
        Camera camera=stage.getCamera();
        camera.position.set(camera.viewportWidth/2.0f,camera.viewportHeight/2.0f,0);
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
        skin.dispose();
        textureAtlas.dispose();
        stage.dispose();
        batch.dispose();
        backgroundMusic.dispose();
    }

    public GameScreen getGame() {
        return game;
    }

}