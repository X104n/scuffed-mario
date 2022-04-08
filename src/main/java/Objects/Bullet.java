package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class Bullet extends Entity{

    Texture image;
    GameScreen screen;
    boolean right;

    public Bullet(float width, float height, Body body, GameScreen gameScreen){
        super(width, height, body);
        screen = gameScreen;

        image = new Texture("bullet.png");
        velX = 3f;
    }

    public void setDirectionRight(){
        right = true;
    }
    public void setDirectionLeft(){
        right = false;
    }


    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        body.setLinearVelocity(velX, 0);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image,x,y);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public boolean deathCriterium(Entity player) {
        return false;
    }
}
