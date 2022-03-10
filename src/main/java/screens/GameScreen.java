package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.lwjgl.opengl.GL30;

public class GameScreen implements Screen {

    final ScuffedMario game;

    OrthographicCamera camera;
    Stage stage;
    SpriteBatch batch;
    Texture player;

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

        world = new World(new Vector2(0,0), true);
        box2DDebugRenderer = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){

            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);

        }

    }

    public void mapRenderer() {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glBlendFunc(GL30.GL_SRC0_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        renderer.setView(camera.combined, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {
        mapRenderer();
        player = new Texture("assets/notFinalScuffedMario.png");
        // backGroundImage = new Texture("assets/testBackground.png");
        // objectImage = new Texture("assets/black_box.png");

        stage = new Stage();

        //System.out.println("width: " + objectImage.getWidth());
        //System.out.println("height: " + objectImage.getHeight());

        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
    }

    public void update(float dt) {
        handleinput(dt);
        camera.update();
        renderer.setView(camera);
    }

    private void handleinput(float dt) {
        if (Gdx.input.isTouched()) {
            camera.position.x += 100 * dt;
        }
    }

    @Override
    public void render(float v) {
        update(v);
        //screen part:
        ScreenUtils.clear(0, 0, 0, 1);

        renderer.render();

        //Character part:
        batch.begin();
        //batch.draw(backGroundImage, 0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        //batch.draw(objectImage, 300, 300);
        //batch.draw(object_rectangle, 300, 300);
        batch.draw(player, playerX, playerY, 30, 30);


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
        //backGroundImage.dispose();
        //objectImage.dispose();
        player.dispose();
    }
}
