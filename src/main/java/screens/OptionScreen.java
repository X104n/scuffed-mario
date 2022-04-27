package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import desktop.DesktopLauncher;

public class OptionScreen implements Screen {
    Viewport viewport;
    Stage stage;
    OrthographicCamera camera;
    SpriteBatch batch;
    ScuffedMario game;
    Skin skin;
    TextureAtlas textureAtlas;
    Music backgroundMusic;

    public static float gameVolume = 1.0f;
    public static float menuVolume = 0.1f;

    public OptionScreen(ScuffedMario game, OrthographicCamera camera) {
        this.game = game;
        this.camera = camera;
        this.batch = new SpriteBatch();

        viewport = new FitViewport(DesktopLauncher.width, DesktopLauncher.height, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        skin = new Skin(Gdx.files.internal("assets/UI/uiskin.json"));
        textureAtlas = new TextureAtlas(Gdx.files.internal("assets/UI/uiskin.atlas"));
        skin.addRegions(textureAtlas);
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/thomas.mp3"));
    }
    @Override
    public void show() {
        TextButton backButton = new TextButton("Back", skin);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label mainMenuMusicLabel = new Label("Main menu music", font);
        Label gameMusicButtonLabel = new Label("Game music", font);

        Gdx.input.setInputProcessor(stage);

        Slider gameSlider = new Slider((float) 0.1, 1, 0.1f, false, skin);
        gameSlider.setValue((float) 0.1);

        Slider menuSlider = new Slider((float) 0.1, 1, 0.1f, false, skin);
        menuSlider.setValue((float) 0.1);

        Table table = new Table();
        table.setFillParent(true); // This table will take up the entire screen

        table.setWidth(400);
        table.add(mainMenuMusicLabel).padRight(20);
        table.add(menuSlider).center();
        table.row().padTop(20);
        table.add(gameMusicButtonLabel).padRight(20);
        table.add(gameSlider).center();
        table.row().padTop(100);
        table.add(backButton).center();

        table.pack();

        stage.addActor(table);

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new MainMenu(game, camera));
            }
        });

        // Slider listener
        gameSlider.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gameVolume = gameSlider.getValue();
                //System.out.println("slider changed to: " + gameSlider.getValue()); // Prints the slider value
                System.out.println("game volume: " + gameVolume);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        menuSlider.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                menuVolume = menuSlider.getValue();
                //System.out.println("slider changed to: " + gameSlider.getValue()); // Prints the slider value
                System.out.println("menu volume: " + menuVolume);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    public float getGameVolume() {
        return gameVolume;
    }

    public float getMenuVolume() {
        return menuVolume;
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
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
        batch.dispose();
        stage.dispose();
        skin.dispose();
        textureAtlas.dispose();
        backgroundMusic.dispose();
    }
}
