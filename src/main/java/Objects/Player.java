package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class Player extends Entity {

    private int jumpCounter;
    GameScreen gameScreen;
    Texture playerTexture;
    ShapeRenderer shapeRenderer;

    public Player(float width, float height, Body body, GameScreen gameScreen) {
        super(width, height, body);
        System.out.println(width);
        System.out.println(height);
        this.speed = 10f;
        this.jumpCounter = 0;
        this.gameScreen = gameScreen;
        this.playerTexture = new Texture("assets/Images/Icon.png");
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void update() {
        //setPosition(body.getPosition().x * PPM, body.getPosition().y * PPM);

        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;

        checkUserInput();
    }

    public boolean playerDead(){
        return y <= 0f;
    }

    @Override
    public void render(SpriteBatch batch) {
        shapeRenderer.setProjectionMatrix(gameScreen.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(x-height/2, y-width/2, width, height);
        shapeRenderer.end();
        //batch.draw(playerTexture, body.getPosition().x * PPM, body.getPosition().y * PPM, width, height);
        //batch.draw(playerTexture, x - ((float)playerTexture.getWidth())/2, y - ((float)playerTexture.getHeight())/2, width, height);
        //batch.draw(new Texture("assets/Images/Zelensky.png"), x, y, width, height);
    }

    private void checkUserInput(){
        velX = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            velX = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            velX = -1;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && jumpCounter < 2){
            float force = body.getMass() * 18;
            body.setLinearVelocity(body.getLinearVelocity().x, 0);
            body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
            jumpCounter++;
        }

        // reset jump counter
        if(body.getLinearVelocity().y == 0){
            jumpCounter = 0;
        }

        body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);

    }


    //Method returns a rectangle covering the players hitbox, but with +1 in every direction, such that the rectangle overlaps other rectangles within distance 1
    public Rectangle getBounds(){
        return new Rectangle((int) this.x - (int) this.width / 2 - 1, (int) this.y - (int) this.height / 2 - 1, (int) (this.width) + 2,(int) (this.height) + 2);
    }

    public boolean deathCriterium(Entity player){
        if(false)
            return true;
        return false;
    }
}