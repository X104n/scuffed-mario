package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
        marioImage = new Texture(Gdx.files.internal("assets/test.png"));
        backGroundImage = new Texture(Gdx.files.internal("assets/testBackground.png"));

        // Creates a new camera for the game screen
        camera = new OrthographicCamera();

        // Note that we make the camera a fixed size here so if we want to show more at a time we need to upscale it here
        camera.setToOrtho(false, 800, 480);

        // make Mario
        mario = new Rectangle();
        mario.x = 800/2 - 64/2;
        mario.y = 20;

        mario.width = 64;
        mario.height = 64;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);


        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backGroundImage, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.draw(marioImage, mario.x, mario.y, mario.width, mario.height);
        game.batch.end();

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
