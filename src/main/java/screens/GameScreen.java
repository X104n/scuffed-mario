package screens;

import Objects.Entity;
import Objects.ObjectType;
import Objects.Player;
import Objects.SmallPutin;
import Tools.EntetyBuilder;
import Tools.TiledMapHandler;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import org.lwjgl.opengl.GL20;

import java.util.ArrayList;

import static Tools.Constants.PPM;

public class GameScreen extends Game implements Screen {

    SpriteBatch batch;
    OrthographicCamera camera;

    ScuffedMario mario;

    Player player;

    public ArrayList<Entity> enemies = new ArrayList<>(); // When spawning an enemy, add them to this list. When an enemy dies, remove them.

    Music backgroundMusic;

    private TiledMapHandler tiledMapHandler;
    private OrthoCachedTiledMapRenderer renderer;

    // box2d
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;


    public GameScreen(OrthographicCamera camera) {
        this.batch = new SpriteBatch();
        this.camera = camera;
        this.mario = new ScuffedMario();

        this.world = new World(new Vector2(0, -25f), false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();

        this.tiledMapHandler = new TiledMapHandler(this);
        this.renderer = tiledMapHandler.setupMap();

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/widePutinEarrape.mp3"));
        backgroundMusic.setLooping(true);
    }

    public World getWorld(){
        return this.world;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void resetPlayer(){
        world.destroyBody(player.getBody());
        this.renderer = tiledMapHandler.setupMap();
    }

    @Override
    public void show() {
        backgroundMusic.play();
        backgroundMusic.setVolume(0.11f);
    }

    public void update() {
        world.step(1 / 60f, 6, 2);
        cameraUpdate();
        renderer.setView(camera);
        player.update();

        // Make a method for this mess :))
        for(int i = 0 ; i < enemies.size() ; i++) { // Loop through all living enemies
            Entity enemy = enemies.get(i);
            enemy.update();
            if (checkPlayerCollision(player, enemy) && enemy.deathCriterium(player)) {
                ObjectType objtype = enemy.getObjType();
                switch(objtype) { //Determine how different collisions should affect the game
                    case PUTIN:
                        spawnSmallPutin((int) enemy.getBody().getPosition().x * (int) PPM,  (int) enemy.getBody().getPosition().y * (int) PPM + 1, (int) enemy.getWidth(), (int) enemy.getHeight());
                        world.destroyBody(enemy.getBody());
                        enemy.die();
                        enemies.remove(enemy);
                        break;
                    case BULLET:
                        player.die();
                        break;
                    case SMALLPUTIN:
                        world.destroyBody(enemy.getBody());
                        enemy.die();
                        enemies.remove(enemy);
                }
                i -= 1;
            }
        }

        // Conditions
        if (player.playerDead() || !player.isAlive()) {
            //resetPlayer();
            mario.setScreen(new GameOverScreen(this, camera));
            dispose();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)) { // if the player should get stuck in the game
            resetPlayer();
        }
    }

    private void cameraUpdate(){
        Vector3 position = camera.position;

        // Multiplying and dividing by 10 to round off the number
        position.x = Math.round(player.getBody().getPosition().x * PPM * 10) / 10f;
        position.y = Math.round(player.getBody().getPosition().y * PPM * 10) / 10f;
        if(position.y < Gdx.graphics.getHeight()/2){
            position.y = Gdx.graphics.getHeight()/2;
        }
        camera.position.set(position);
        camera.update();
    }

    @Override
    public void render(float v) {
        this.update();
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();

        batch.begin();
        // Render things here
        player.render(batch);

        batch.end();

        box2DDebugRenderer.render(world, camera.combined.scl(PPM));
    }


    @Override
    public void create() {

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
        batch.dispose();
    }

    private void spawnSmallPutin(int x, int y, int w, int h){
        Rectangle rectangle = new Rectangle(x,y,w,h/2);

            Body body = EntetyBuilder.createBody(
                    rectangle.getX() + rectangle.getWidth() / 2,
                    rectangle.getY() - rectangle.getHeight() / 2,
                    rectangle.getWidth(),
                    rectangle.getHeight(),
                    false,
                    this.getWorld()
            );
            enemies.add(new SmallPutin(rectangle.getWidth(), rectangle.getHeight(), body));
    }

    private boolean checkPlayerCollision(Player player, Entity ent2){
        if(player.getBounds().intersects(ent2.getBounds()))
            return true;
        return false;
    }

    public Player getPlayer(){
        return this.player;
    }
}
