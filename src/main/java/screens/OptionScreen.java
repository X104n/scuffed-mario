package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
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

    public OptionScreen(ScuffedMario game, OrthographicCamera camera) {
        this.game = game;
        this.camera = camera;
        this.batch = new SpriteBatch();

        viewport = new FitViewport(DesktopLauncher.width, DesktopLauncher.height, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        skin = new Skin(Gdx.files.internal("assets/UI/uiskin.json"));
        textureAtlas = new TextureAtlas(Gdx.files.internal("assets/UI/uiskin.atlas"));
        skin.addRegions(textureAtlas);
    }
    @Override
    public void show() {
        /*Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label mainMenuMusic = new Label("Main menu music", skin);
        Label gameMusic = new Label("Game music", skin);*/

        TextButton mainMenuMusicButton = new TextButton("Main menu music", skin);
        TextButton gameMusicButton = new TextButton("Game music", skin);

        Gdx.input.setInputProcessor(stage);

        Slider slider = new Slider(0, 100, 0.1f, false, skin);
        slider.setValue(1);
        Container<Slider> sliderContainer = new Container<Slider>(slider);
        sliderContainer.setTransform(true);

        sliderContainer.setOrigin(slider.getWidth() / 2, slider.getHeight() / 2);
        sliderContainer.setSize(slider.getWidth(), slider.getHeight());
        sliderContainer.setScale(2);

        Table table = new Table();
        table.center();
        table.setFillParent(true); // This table will take up the entire screen
        table.setWidth(400);
        table.add(mainMenuMusicButton).center();
        table.row();
        table.add(sliderContainer).width(sliderContainer.getWidth()).center();
        table.add(gameMusicButton).expandX();
        table.row();
        table.add(sliderContainer).width(sliderContainer.getWidth()).center();

        stage.addActor(table);
        stage.addActor(slider);
    }

    @Override
    public void render(float v) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();
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
    }
}
