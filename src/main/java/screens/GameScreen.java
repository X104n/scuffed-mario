package screens;

import Objects.Player;
import Tools.TiledMapHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import static Tools.Constants.PPM;

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

    private TiledMapHandler tiledMapHandler;
    private OrthoCachedTiledMapRenderer renderer;

    // box2d
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;


    public GameScreen(final ScuffedMario game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCENE_WIDTH, SCENE_HEIGHT);

        world = new World(new Vector2(0, -25), false);
        box2DDebugRenderer = new Box2DDebugRenderer();

        this.tiledMapHandler = new TiledMapHandler(this);
        this.renderer = tiledMapHandler.setupMap();


        //new B2WorldCreator(world, map);

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/widePutin.mp3"));
        backgroundMusic.setLooping(true);
    }

    public World getWorld(){
        return this.world;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    @Override
    public void show() {
        backgroundMusic.play();
        backgroundMusic.setVolume(0.1f);
    }

    public void update() {
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
        this.update();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
        renderer.dispose();
        world.dispose();
        box2DDebugRenderer.dispose();
        backgroundMusic.dispose();
    }
}
