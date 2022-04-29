package screens;

import Objects.*;
import Tools.EntetyBuilder;
import Tools.TiledMapHandler;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.sun.tools.javac.Main;
import org.lwjgl.opengl.GL20;

import java.util.ArrayList;

import static Tools.Constants.PPM;

public class GameScreen extends Game implements Screen {

    SpriteBatch batch;
    OrthographicCamera camera;
    Player player;
    public ArrayList<Entity> enemies = new ArrayList<>(); // When spawning an enemy, add them to this list. When an enemy dies, remove them.
    public ArrayList<Bullet> bullets = new ArrayList<>(); // When spawning a Bullet, add it to this list. When a Bullet "dies", remove it.
    Music backgroundMusic;
    private TiledMapHandler tiledMapHandler;
    private OrthoCachedTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;
    ScuffedMario game;

    public int mapPixelWidth;
    public int mapPixelHeight;
    public int mapNr;
    public GameScreen(ScuffedMario game, OrthographicCamera camera, int nr) {
        this.batch = new SpriteBatch();
        this.camera = camera;
        this.game = game;
        this.mapNr = nr;

        this.world = new World(new Vector2(0, -25f), false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();

        this.tiledMapHandler = new TiledMapHandler(this);
        this.renderer = tiledMapHandler.setupMap(game.levels.get(mapNr));
        setMapBoundaries();

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/Sound/widePutinEarrape.mp3"));
        backgroundMusic.setLooping(true);
    }

    private void setMapBoundaries(){
        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMapHandler.tiledMap.getLayers().get(0);
        int tilePixelWidth = layer.getTileWidth();
        int tilePixelHeight = layer.getTileHeight();
        int mapWidth = layer.getWidth();
        int mapHeight = layer.getHeight();
        this.mapPixelWidth = mapWidth * tilePixelWidth;
        this.mapPixelHeight = mapHeight * tilePixelHeight;
    }


    public OrthographicCamera getCamera() {
        return camera;
    }

    public World getWorld(){
        return this.world;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public TiledMapHandler getTiledMapHandler() {
        return tiledMapHandler;
    }

    @Override
    public void show() {
        backgroundMusic.play();
        backgroundMusic.setVolume(OptionScreen.gameVolume);
    }

    public void update() {
        world.step(1 / 60f, 6, 2);
        cameraUpdate();
        renderer.setView(camera);
        player.update();
        updateBullets();
        updateEnemies();
        // Conditions
        if (player.playerDead() || !player.isAlive()) {
            game.setScreen(new GameOverScreen(game, camera));
            this.dispose();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)) { // if the player should get stuck in the game
            reloadMap(0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.M)) { // if the player should get stuck in the game
            this.dispose();
            game.setScreen(new MainMenu(game, camera));
        }
    }

    public void reloadMap(int nr){
        this.dispose();
        game.setScreen(new GameScreen(game, camera, mapNr+nr));
    }

    public void victory(){
        this.dispose();
        game.setScreen(new YouWonScreen(game, camera, player));
    }

    private void cameraUpdate(){
        Vector3 position = camera.position;

        // Multiplying and dividing by 10 to round off the number
        position.x = Math.round(player.getBody().getPosition().x * PPM * 10) / 10f;
        position.y = Math.round(player.getBody().getPosition().y * PPM * 10) / 10f;
        if(position.y < Gdx.graphics.getHeight()/2){
            position.y = Gdx.graphics.getHeight()/2;
        }
        if(position.x < Gdx.graphics.getWidth()/2){
            position.x = Gdx.graphics.getWidth()/2;
        }
        if(position.x > mapPixelWidth - Gdx.graphics.getWidth()/2){
            position.x = mapPixelWidth - Gdx.graphics.getWidth()/2;
        }
        if(position.y > mapPixelHeight - Gdx.graphics.getHeight()/2){
            position.y = mapPixelHeight - Gdx.graphics.getHeight()/2;
        }
        camera.position.set(position);
        camera.update();
    }

    public void updateEnemies(){
        for(int i = 0 ; i < enemies.size() ; i++) { // Loop through all living enemies
            Entity enemy = enemies.get(i);
            enemy.update();
            if (checkEntityCollision(player, enemy)) {
                if(enemy.collide(player)) //Returns true if enemy dies
                    i -= 1;
            }
        }
    }

    public void updateBullets(){
        for(int i = 0 ; i < bullets.size() ; i++){
            Bullet bullet = bullets.get(i);
            bullet.update();
            if(!bullets.contains(bullet)) i -= 1; //If bullet died in update, update i
            else {
                for(int j = 0 ; j < enemies.size() ; j++){
                    Entity enemy = enemies.get(j);
                    if(checkEntityCollision(bullet,enemy)) {
                        if(bullet.isFriendly()){
                            enemy.takeDamage(bullet.gunDamage);
                            bullet.die();
                            i -= 1;
                        }else{
                            bullet.die();
                            i -= 1;
                        }
                    }
                }
                if(checkEntityCollision(player,bullet) && !bullet.isFriendly()){
                    player.takeDamage(bullet.gunDamage);
                    bullet.die();
                    i -= 1;
                }
            }
        }
    }

    @Override
    public void render(float v) {
        this.update();
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        batch.begin();
        // Render things here
        batch.setProjectionMatrix(camera.combined);
        player.render(batch);
        for(Entity enemy : enemies) enemy.render(batch);
        for(Bullet bullet : bullets) bullet.render(batch);
        batch.end();
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
        backgroundMusic.dispose();
    }

    private boolean checkEntityCollision(Entity ent1, Entity ent2){
        if(ent1.getBounds().intersects(ent2.getBounds()))
            return true;
        return false;
    }

    public Player getPlayer(){
        return this.player;
    }

}
