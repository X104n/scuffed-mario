package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class Obstacle extends Entity{

    long lastjump;
    double JUMPCD = 5000;
    public Obstacle(float width, float height, Body body, GameScreen screen) {
        super(width, height, body);
        velY = 0;
        HP = 10;
        super.screen = screen;
        super.type = ObjectType.BOSS;
        lastjump = System.currentTimeMillis();
        this.entityTexture = new Texture("assets/Images/black_box.png");
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastjump > JUMPCD) {
            lastjump = currentTime;
            velY = 7;
        }
        velY = velY - 0.1f;
        body.setLinearVelocity(0, velY);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    public boolean collide(Player player){
        return false;
    }


    @Override
    public boolean deathCriterium(Entity player) {
        return false;
    }
}
