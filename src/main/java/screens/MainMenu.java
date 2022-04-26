package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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

import java.awt.*;

public class MainMenu implements Screen {
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

/*    private TextButton addButton(String text) {
        TextButton button = new TextButton(text, skin);
        table.add(button);
        table.row();
        return button;
    }*/

    @Override
    public void show() {
        backgroundMusic.play();
        backgroundMusic.setVolume(0.01f); // sets volume to 0.1%

        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton playButton = new TextButton("Play", skin);
        TextButton optionButton = new TextButton("Option", skin);
        TextButton controlsButton = new TextButton("Controls", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                mario.setScreen(new GameScreen(mario, camera)); // sets the screen to the game screen
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
                mario.setScreen(new OptionScreen(mario, camera)); // sets the screen to the control screen
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
    }

    @Override
    public void resize(int i, int i1) {
        camera.viewportWidth = DesktopLauncher.width;
        camera.viewportHeight = DesktopLauncher.height;
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
}