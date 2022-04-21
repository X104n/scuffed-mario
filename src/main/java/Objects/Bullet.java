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
    float lastX;

    public Bullet(float width, float height, Body body, GameScreen gameScreen, boolean goesRight){
        super(width, height, body);
        screen = gameScreen;

        image = new Texture("assets/Images/bullet.png");
        if(goesRight)
            velX = 3f;
        else
            velX = -3f;
        super.type = ObjectType.BULLET;
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
        body.setLinearVelocity(velX, 0.45f);
        if(Math.abs(body.getPosition().x - lastX) < 0.03){
            screen.getWorld().destroyBody(body);
            screen.enemies.remove(this);
        }
        lastX = body.getPosition().x;
    }

    @Override
    public void render(SpriteBatch batch) {
        //batch.draw(new Texture("assets/Images/Bullet.png"), x, y, width, height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    @Override
    public boolean deathCriterium(Entity player) {
        return true;
    }
}
