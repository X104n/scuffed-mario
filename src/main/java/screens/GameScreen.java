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
    TextureRegion player;
    Texture backGroundImage;
    float playerX = 0;
    float playerY = 0;
    float Speed = 50.0f;

    public static Texture mario = new Texture("assets/MarioRunSheet.png");
    static Animation mario_run;
    static TextureRegion[] run_frame;
    static TextureRegion current_frame;
    static float state_time;

    boolean running;


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

    public void create() {
        mario = new Texture(Gdx.files.internal("bounce_sprite.png"));
        TextureRegion[][] tmp = TextureRegion.split(mario, mario.getWidth()/13, mario.getHeight());
        run_frame = new TextureRegion[3];
        int index = 0;
        for(int y=1; y<4; y++) {
            for(int x=0; x<1; x++) {
                run_frame[index++] = tmp[y][x];
            }
        }
        mario_run = new Animation(1f/4f, run_frame);
        state_time = 0f;

        // set this variable true when you want the animation to run once
        running = true;

    }

    @Override
    public void show() {
        player = new TextureRegion(mario, 0, 0, 16, 16);

        //player = new TextureRegion(texture, 0,0,16,16);
                //new Texture("assets/notFinalScuffedMario.png");
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

        state_time += Gdx.graphics.getDeltaTime() * Speed;
        current_frame = (TextureRegion) mario_run.getKeyFrame(state_time, true);

        //MarioRun runRight = new MarioRun(new TextureRegion(texture), 3, 0.5f, 1, 3);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            //System.out.println("w, was pressed"); // just for debugging
            playerY += Gdx.graphics.getDeltaTime() * Speed;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            //System.out.println("s, was pressed");
            playerY -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            //System.out.println("a, was pressed");
            playerX -= Gdx.graphics.getDeltaTime() * Speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            //System.out.println("d, was pressed");
            playerX += Gdx.graphics.getDeltaTime() * Speed;
            batch.draw(current_frame, playerX, playerY, 64, 64);
            if(mario_run.isAnimationFinished(state_time)) {
                state_time = Gdx.graphics.getDeltaTime() * Speed;
                running = false;
            }
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
        //player.dispose();
        /*
        * Is not used since player is just a region of texture.
        * texture is disposed instead.
        * */
    }
}