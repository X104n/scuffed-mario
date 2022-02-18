package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final ScuffedMario game;

    OrthographicCamera camera;

    Stage stage;
    SpriteBatch batch;

    Texture player;
    Texture backGroundImage;

    float playerX = 0;
    float playerY = 0;
    float Speed = 50.0f;

    public GameScreen(final ScuffedMario game) {
        this.game = game;


        // load the test image
        //marioImage = new Texture(Gdx.files.internal("assets/notFinalScuffedMario.png"));
        //backGroundImage = new Texture(Gdx.files.internal("assets/testBackground.png"));

        // Creates a new camera for the game screen
        camera = new OrthographicCamera();

        // Note that we make the camera a fixed size here so if we want to show more at a time we need to upscale it here
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {
        player = new Texture("assets/notFinalScuffedMario.png");
        backGroundImage = new Texture("assets/testBackground.png");

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float v) {
        //screen part:
        ScreenUtils.clear(0, 0, 0, 1);

        //Character part
        batch.begin();
        batch.draw(backGroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(player, playerX, playerY, 64, 64);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            System.out.println("w, was pressed"); // just for debugging
            playerY += Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            System.out.println("s, was pressed");
            playerY -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            System.out.println("a, was pressed");
            playerX -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            System.out.println("d, was pressed");
            playerX += Gdx.graphics.getDeltaTime() * Speed;
        }


        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);


        batch.setProjectionMatrix(camera.combined);
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
        backGroundImage.dispose();
        player.dispose();
    }
}
