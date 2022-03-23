package screens;

import Sprite.Player;
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
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.lwjgl.opengl.GL30;

import static screens.ScuffedMario.PPM;

public class GameScreen implements Screen {

    final ScuffedMario game;

    OrthographicCamera camera;
    SpriteBatch batch;
    Stage stage;

    Player player;

    Music backgroundMusic;


    int SCENE_HEIGHT = Gdx.graphics.getHeight();
    int SCENE_WIDTH = Gdx.graphics.getWidth();

    FitViewport gamePort;

    private TmxMapLoader mapLoader;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;

    // box2d
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    public GameScreen(final ScuffedMario game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCENE_WIDTH, SCENE_HEIGHT);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("assets/level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        //camera.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2), 0;

        world = new World(new Vector2(0, -10), true);
        box2DDebugRenderer = new Box2DDebugRenderer();

        new B2WorldCreator(world, map);

        this.player = new Player(world);

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/widePutin.mp3"));
        backgroundMusic.setLooping(true);
    }

    public void setPlayer(Player player){
        this.player = player;
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
        backgroundMusic.setVolume(0.1f);
        mapRenderer();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
    }

    public void update(float dt) {
        world.step(1 / 60f, 6, 2);
        cameraUpdate();


        renderer.setView(camera);

        player.update();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }

    }

    private void cameraUpdate(){
        Vector3 position = camera.position;
        position.x = Math.round(player.getBody().getPosition().x * PPM * 10) / 10f;
        position.y = Math.round(player.getBody().getPosition().y * PPM * 10) / 10f;
        camera.position.set(position);
        camera.update();
    }

    @Override
    public void render(float v) {
        update(v);

        renderer.render();

        batch.begin();
        // Render

        batch.end();

        box2DDebugRenderer.render(world, camera.combined);
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
