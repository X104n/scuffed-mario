package Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import java.awt.*;

import static Tools.Constants.PPM;

public class Putin extends Entity{
    public boolean alive = true;
    long lastTurn;
    boolean turnRight = false;

    int timeBeforeTurn = 2000;

    public Putin(float width, float height, Body body) {
        super(width, height, body);
        System.out.println(width);
        System.out.println(height);

        this.speed = 5f;
        lastTurn = System.currentTimeMillis();
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        long time = System.currentTimeMillis();
        if(time - lastTurn > timeBeforeTurn){
            if(turnRight){
                velX = (float) -0.3;
                turnRight = false;
            }else{
                velX = (float) 0.3;
                turnRight = true;
            }
            lastTurn = time;
            body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    public Putin getPutin(){
        return this;
    }
}
