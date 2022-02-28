package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class GameScreen implements Screen {

    final ScuffedMario game;

    OrthographicCamera camera;

    Stage stage;
    SpriteBatch batch;

    Texture player;
    Texture backGroundImage;
    Texture objectImage;

    float playerX = 0; // where mario is placed on the board
    float playerY = 0;
    float Speed = 300.0f;

    com.badlogic.gdx.math.Rectangle player_rectangle; // creates a rectangle around the player
    com.badlogic.gdx.math.Rectangle object_rectangle;
    float prevX = 0; // last x pos
    float prevY = 0; // last y pos

    int SCENE_HEIGHT = 480;
    int SCENE_WIDTH = 800;

    public GameScreen(final ScuffedMario game) {
        this.game = game;


        // load the test image
        //marioImage = new Texture(Gdx.files.internal("assets/notFinalScuffedMario.png"));
        //backGroundImage = new Texture(Gdx.files.internal("assets/testBackground.png"));

        // Creates a new camera for the game screen
        camera = new OrthographicCamera();

        // Note that we make the camera a fixed size here so if we want to show more at a time we need to upscale it here
        camera.setToOrtho(false, SCENE_WIDTH, SCENE_HEIGHT);
    }

    @Override
    public void show() {
        player = new Texture("assets/notFinalScuffedMario.png");
        backGroundImage = new Texture("assets/testBackground.png");
        objectImage = new Texture("assets/black_box.png");

        stage = new Stage();

        player_rectangle = new com.badlogic.gdx.math.Rectangle(playerX, playerY, player.getWidth(), player.getHeight());
        object_rectangle = new com.badlogic.gdx.math.Rectangle(playerX, playerY, objectImage.getWidth(), objectImage.getHeight());
        System.out.println("width: " + objectImage.getWidth());
        System.out.println("height: " + objectImage.getHeight());

        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float v) {
        //screen part:
        ScreenUtils.clear(0, 0, 0, 1);

        //Character part
        batch.begin();
        batch.draw(backGroundImage, 0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        batch.draw(objectImage, 480, 160, 32, 32);
        batch.draw(player, playerX, playerY, 64, 64);

        if (object_rectangle.overlaps(player_rectangle)) {
            System.out.println("collided"); // just for debugging
            playerY = prevY;
            playerX = prevX;
        }  

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            System.out.println("w, was pressed"); // just for debugging
            prevY = playerY;
            playerY += Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            System.out.println("s, was pressed");
            prevY = playerY;
            playerY -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            System.out.println("a, was pressed");
            prevX = playerX;
            playerX -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            System.out.println("d, was pressed");
            prevX = playerX;
            playerX += Gdx.graphics.getDeltaTime() * Speed;
        }

        player_rectangle = new com.badlogic.gdx.math.Rectangle(playerX, playerY, player.getWidth(), player.getHeight()); // updates rectangle around the player
        // object_rectangle = new Rectangle(Math.round(playerX), Math.round(playerY), objectImage.getWidth(), objectImage.getHeight()); // we use this if the player is going to move an object

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
        objectImage.dispose();
        player.dispose();
    }
}
