package screens;

import Objects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import desktop.DesktopLauncher;

public class YouWonScreen implements Screen {
    Viewport viewport;
    Stage stage;
    OrthographicCamera camera;
    SpriteBatch batch;
    ScuffedMario mario;
    Player player;

    public YouWonScreen(ScuffedMario mario, OrthographicCamera camera, Player player) {
        this.mario = mario;
        this.camera = camera;
        this.batch = new SpriteBatch();
        this.player = player;

        viewport = new FitViewport(DesktopLauncher.width, DesktopLauncher.height, new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Label youWonLabel = new Label("You Won!", font);
        Label scoreLabel = new Label("You got: " + player.score + " rubles!", font);
        Label scoreLabel2 = new Label("( 0.00000" + (int)Math.round(player.score) + " dollars)", font);
        Label playAgainLabel = new Label("Press ENTER to play again", font);
        Label quiGameLabel = new Label("Press esc to quit the game", font);

        Table table = new Table();
        table.center();
        table.setFillParent(true); // This table will take up the entire screen

        table.add(youWonLabel).expandX().pad(10);
        table.row();
        table.add(scoreLabel).expandX().pad(10);
        table.row();
        table.add(scoreLabel2).expandX().pad(10);
        table.row();
        table.add(playAgainLabel).expandX().pad(10);
        table.row();
        table.add(quiGameLabel).expandX().pad(10);

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            this.dispose();
            mario.setScreen(new GameScreen(mario, camera, 0));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
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
