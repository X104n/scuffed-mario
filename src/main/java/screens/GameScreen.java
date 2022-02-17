package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class GameScreen implements Screen {

    final ScuffedMario game;

    Texture backGroundImage;
    Texture marioImage;
    OrthographicCamera camera;
    Rectangle mario;

    public GameScreen(final ScuffedMario game){
        this.game = game;

        // load the test image
        //marioImage = new Texture(Gdx.files.internal("assets/notFinalScuffedMario.png"));
        backGroundImage = new Texture(Gdx.files.internal("assets/testBackground.png"));

        // Creates a new camera for the game screen
        camera = new OrthographicCamera();

        // Note that we make the camera a fixed size here so if we want to show more at a time we need to upscale it here
        camera.setToOrtho(false, 800, 480);

        // make Mario
/*        mario = new Rectangle();
        mario.x = 800/2 - 64/2;
        mario.y = 20;

        mario.width = 64;
        mario.height = 64;*/
    }

    Stage stage;
    SpriteBatch batch;
    Texture player;

    float playerX = 0;
    float playerY = 0;
    float Speed = 50.0f;
    float height = 64;
    float width = 64;

    @Override
    public void show() {
        player = new Texture("assets/notFinalScuffedMario.png");
        //player = new Texture(mario);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float v) {
        //Character part
        Gdx.gl.glClearColor(1,1,1,0); // white, to avoid flickering
        batch.begin();
        stage.draw();
        batch.draw(player, playerX, playerY, width, height);
        batch.draw(backGroundImage, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            System.out.println("w, was pressed"); // just for debugging
            playerY += Gdx.graphics.getDeltaTime()*Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            System.out.println("s, was pressed");
            playerY -= Gdx.graphics.getDeltaTime()*Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            System.out.println("a, was pressed");
            playerX -= Gdx.graphics.getDeltaTime()*Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            System.out.println("d, was pressed");
            playerX += Gdx.graphics.getDeltaTime()*Speed;
        }

        //screen part:
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);


        game.batch.setProjectionMatrix(camera.combined);
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
        marioImage.dispose();
    }
}
