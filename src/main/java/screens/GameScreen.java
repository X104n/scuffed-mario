package screens;

import Sprite.Mario;
import Sprite.Opponent;
import Tools.B2WorldCreator;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.lwjgl.opengl.GL30;

public class GameScreen implements Screen {

    final ScuffedMario game;

    OrthographicCamera camera;
    Stage stage;
    SpriteBatch batch;
    //Texture playerTexture;
    Mario player;
    //Mario-player #2
    Opponent enemy;

    Music backgroundMusic;

    float playerX = 0; // where mario is placed on the board
    float playerY = 0;
    float Speed = 300.0f;

    int SCENE_HEIGHT = 208;
    int SCENE_WIDTH = 500;

    FitViewport gamePort;

    private TmxMapLoader mapLoader;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;

    // box2d
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    public GameScreen(final ScuffedMario game) {
        this.game = game;
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/widePutin.mp3"));
        backgroundMusic.setLooping(true);

        // load the test image
        //marioImage = new Texture(Gdx.files.internal("assets/notFinalScuffedMario.png"));
        //backGroundImage = new Texture(Gdx.files.internal("assets/testBackground.png"));

        // Creates a new camera for the game screen
        camera = new OrthographicCamera();

        // Note that we make the camera a fixed size here so if we want to show more at a time we need to upscale it here
        camera.setToOrtho(false, SCENE_WIDTH, SCENE_HEIGHT);

        gamePort = new FitViewport(SCENE_WIDTH, SCENE_HEIGHT, camera);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("assets/level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        //camera.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2), 0;

        world = new World(new Vector2(0, -10), true);
        box2DDebugRenderer = new Box2DDebugRenderer();

        new B2WorldCreator(world, map);

        this.player = new Mario(world);
        this.enemy = new Opponent(world);
    }

    public void mapRenderer() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL30.GL_SRC0_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        renderer.setView(camera.combined, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {
        backgroundMusic.play();
        mapRenderer();
        //playerTexture = new Texture("assets/notFinalScuffedMario.png");
        // backGroundImage = new Texture("assets/testBackground.png");
        // objectImage = new Texture("assets/black_box.png");

        stage = new Stage();

        //System.out.println("width: " + objectImage.getWidth());
        //System.out.println("height: " + objectImage.getHeight());

        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
    }

    public void update(float dt) {
        handleInput(dt);

        camera.position.x = player.b2body.getPosition().x;
        world.step(1 / 60f, 6, 2);
        camera.update();
        renderer.setView(camera);
    }

    private void handleInput(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            player.b2body.applyLinearImpulse(new Vector2(0, 10f),
                    player.b2body.getWorldCenter(), true);
            //For testing if enemy can move with the same input as player.
            //enemy.b2body.applyLinearImpulse(new Vector2(0, 10f), player.b2body.getWorldCenter(), true);
            System.out.println("pressed: W");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && player.b2body.getLinearVelocity().x <= 2) {
            player.b2body.applyLinearImpulse(new Vector2(2f, 0),
                    player.b2body.getWorldCenter(), true);
            //For testing if enemy can move with the same input as player.
            //enemy.b2body.applyLinearImpulse(new Vector2(2f, 0), player.b2body.getWorldCenter(), true);
            System.out.println("pressed: D");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && player.b2body.getLinearVelocity().x >= -2) {
            player.b2body.applyLinearImpulse(new Vector2(-2, 0),
                    player.b2body.getWorldCenter(), true);
            //For testing if enemy can move with the same input as player.
            //enemy.b2body.applyLinearImpulse(new Vector2(-2f, 0), player.b2body.getWorldCenter(), true);
            System.out.println("pressed: A");
        }
        //The "enemy's" input commands.
        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            enemy.b2body.applyLinearImpulse(new Vector2(0, 10f),
                    enemy.b2body.getWorldCenter(), true);
            System.out.println("pressed: I");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L) && player.b2body.getLinearVelocity().x <= 2) {
            enemy.b2body.applyLinearImpulse(new Vector2(2f, 0),
                    enemy.b2body.getWorldCenter(), true);
            System.out.println("pressed: L");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.J) && player.b2body.getLinearVelocity().x >= -2) {
            enemy.b2body.applyLinearImpulse(new Vector2(-2, 0),
                    enemy.b2body.getWorldCenter(), true);
            System.out.println("pressed: J");
        }

    }

    @Override
    public void render(float v) {
        update(v);
        //screen part:
        ScreenUtils.clear(0, 0, 0, 1);

        renderer.render();

        box2DDebugRenderer.render(world, camera.combined);

        //Character part:
        batch.begin();
        //batch.draw(backGroundImage, 0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        //batch.draw(objectImage, 300, 300);
        //batch.draw(object_rectangle, 300, 300);
        //batch.draw(playerTexture, playerX, playerY, 30, 30);


       /* if (Gdx.input.isKeyPressed(Input.Keys.W)) {
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
        }*/

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
        map.dispose();
        renderer.dispose();
        world.dispose();
        box2DDebugRenderer.dispose();
        backgroundMusic.dispose();
    }
}
