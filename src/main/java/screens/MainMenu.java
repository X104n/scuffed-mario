package screens;

import Tools.Assets;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import desktop.DesktopLauncher;

import static Tools.Assets.SKIN;

public class MainMenu implements Screen {
    Viewport viewport;
    Stage stage;
    OrthographicCamera camera;
    SpriteBatch batch;
    ScuffedMario mario;
    Table table;
    Skin skin;
    AssetManager assetManager;

    Music backgroundMusic;
    Texture background;

    public MainMenu(AssetManager assetManager) {
        this.assetManager = assetManager;
        skin = assetManager.get(SKIN);
    }

    public MainMenu(ScuffedMario mario, OrthographicCamera camera) {
        this.mario = mario;
        this.camera = camera;
        this.batch = new SpriteBatch();


        viewport = new FitViewport(DesktopLauncher.width, DesktopLauncher.height, new OrthographicCamera());
        stage = new Stage(viewport, batch);

        background = new Texture("assets/Images/thomas.jpg");
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/thomas.mp3"));
    }

    private TextButton addButton(String text) {
        TextButton button = new TextButton(text, skin);
        table.add(button);
        table.row();
        return button;
    }

    @Override
    public void show() {
        backgroundMusic.play();
        backgroundMusic.setVolume(0.01f); // sets volume to 0.1%

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        addButton( "play");
    }


    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        /*stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, DesktopLauncher.width, DesktopLauncher.height);
        stage.getBatch().end();*/
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

    }
}