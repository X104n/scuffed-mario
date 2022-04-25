package Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

public class Boss extends Entity{

    GameScreen screen;
    long lastjump;
    double JUMPCD = 5.0;
    public Boss(float width, float height, Body body, GameScreen screen) {
        super(width, height, body);
        velY = 0;
        this.screen = screen;
        super.type = ObjectType.BOSS;
        lastjump = System.currentTimeMillis();
    }

    @Override
    public void update() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastjump > JUMPCD) {
            lastjump = currentTime;
            velY = 5;
        }
        velY -= 2;
        body.setLinearVelocity(body.getLinearVelocity().x, velY < 25 ? body.getLinearVelocity().y : 25);
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    @Override
    public boolean deathCriterium(Entity player) {
        return false;
    }
}
