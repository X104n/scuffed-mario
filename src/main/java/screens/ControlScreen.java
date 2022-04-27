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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import desktop.DesktopLauncher;

public class ControlScreen implements Screen {
    Viewport viewport;
    Stage stage;
    OrthographicCamera camera;
    SpriteBatch batch;
    ScuffedMario game;
    Skin skin;
    TextureAtlas textureAtlas;
    Music backgroundMusic;

    public ControlScreen(ScuffedMario game, OrthographicCamera camera) {
        this.game = game;
        this.camera = camera;
        this.batch = new SpriteBatch();

        viewport = new FitViewport(DesktopLauncher.width, DesktopLauncher.height, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        skin = new Skin(Gdx.files.internal("assets/UI/uiskin.json"));
        textureAtlas = new TextureAtlas(Gdx.files.internal("assets/UI/uiskin.atlas"));
        skin.addRegions(textureAtlas);

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/dankRussia.mp3"));

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        batch.setProjectionMatrix(camera.combined);
        camera.update();

        stage = new Stage(viewport, batch);

    }
    @Override
    public void show() {
        backgroundMusic.play();
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.5f);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label movementLabel = new Label("Move with WASD", font);
        Label resetGameLabel = new Label("Press 'R' to reset the game", font);
        Label quitGameLabel = new Label("Press 'esc' to quit the game", font);

        TextButton backButton = new TextButton("Back", skin);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.add(movementLabel).expandX().padTop(10);
        table.row();
        table.add(resetGameLabel).expandX().padTop(10);
        table.row();
        table.add(quitGameLabel).expandX().padTop(10);
        table.row();
        table.add(backButton).expandX().padTop(10);

        stage.addActor(table);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new MainMenu(game, camera));
            }
        });
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
