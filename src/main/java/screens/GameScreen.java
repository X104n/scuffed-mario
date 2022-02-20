package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final ScuffedMario game;

    OrthographicCamera camera;

    Stage stage;
    SpriteBatch batch;

    Texture player;
    Texture backGroundImage;

    //variables to make the running animations
    Animation<TextureRegion> rightRun;
    Animation<TextureRegion> leftRun;
    Texture runSheet;
    SpriteBatch sprite;
    float spriteTime;


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
            rightRunning();
            playerY += Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            System.out.println("s, was pressed");
            leftRunning();
            playerY -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            System.out.println("a, was pressed");
            leftRunning();
            playerX -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            System.out.println("d, was pressed");
            rightRunning();
            playerX += Gdx.graphics.getDeltaTime() * Speed;
        }


        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);


        batch.setProjectionMatrix(camera.combined);
        batch.end();

    }

    //class that makes the running animations
    public void createSprite() {

        //adding the sprite sheet
        runSheet = new Texture((Gdx.files.internal("assets/MarioRunSheet")));

        //splitting the sheet based on the number of columns and rows,
        // so we gain access to each individual sprite
        TextureRegion[][] temp = TextureRegion.split
                (runSheet, runSheet.getWidth()/5, runSheet.getHeight()/4);

        TextureRegion[] runningRight = new TextureRegion[5];
        TextureRegion[] runningLeft = new TextureRegion[5];

        //adding the SPECIFIC sprites to make the character run to the right.
        runningRight[0] = temp[3][0];
        runningRight[1] = temp[4][0];
        runningRight[2] = temp[0][1];
        runningRight[3] = temp[1][1];
        runningRight[4] = temp[2][1];
        runningRight[5] = temp[3][1];

        //and again, but to make the character run to the right.
        runningLeft[0] = temp[1][2];
        runningLeft[1] = temp[2][2];
        runningLeft[2] = temp[3][2];
        runningLeft[3] = temp[4][2];
        runningLeft[4] = temp[0][3];
        runningLeft[5] = temp[1][3];

        rightRun = new Animation<TextureRegion>(0.025f, runningRight);
        leftRun = new Animation<TextureRegion>(0.025f, runningLeft);

        sprite = new SpriteBatch();
        spriteTime = 0f;
    }

    //specific class to make the player run to the right
    public void rightRunning(){
        TextureRegion rightPlayer = rightRun.getKeyFrame(spriteTime, true);
        sprite.begin();
        sprite.draw(rightPlayer, playerX, playerY);
        sprite.end();
    }

    //specific class to make the player run to the left
    public void leftRunning(){
        TextureRegion leftPlayer = leftRun.getKeyFrame(spriteTime, true);
        sprite.begin();
        sprite.draw(leftPlayer, playerX, playerY);
        sprite.end();
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
        sprite.dispose();
        runSheet.dispose();
    }
}
