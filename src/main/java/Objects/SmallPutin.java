package Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import java.awt.*;

import static Tools.Constants.PPM;

public class SmallPutin extends Entity{
    public boolean alive = true;
    long lastTurn;
    int turnRight = 1;

    int timeBeforeTurn = 2000;

    public SmallPutin(float width, float height, Body body) {
        super(width, height, body);
        System.out.println(width);
        System.out.println(height);

        lastTurn = System.currentTimeMillis();
        super.type = ObjectType.SMALLPUTIN;
        velX = 1.5f;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        long time = System.currentTimeMillis();
        if(time - lastTurn > timeBeforeTurn){
            velX -= 2*velX;
            System.out.println(velX);
            turnRight -= turnRight;
            lastTurn = time;
        }
        body.setLinearVelocity(velX, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    public SmallPutin getPutin(){
        return this;
    }

    public boolean deathCriterium(Entity player){
        if((int) (player.getBody().getPosition().y + 1) * PPM - (int) player.getHeight() < (int) this.getBody().getPosition().y * PPM)
            return true;
        return false;
    }
}
