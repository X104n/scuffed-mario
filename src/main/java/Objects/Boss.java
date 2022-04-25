package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

public class Boss extends Entity{

    GameScreen screen;
    long lastjump;
    double JUMPCD = 5000;
    public Boss(float width, float height, Body body, GameScreen screen) {
        super(width, height, body);
        velY = 0;
        this.screen = screen;
        super.type = ObjectType.BOSS;
        lastjump = System.currentTimeMillis();
        //this.entityTexture = new Texture("assets/Images/Icon.png");
    }

    @Override
    public void update() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastjump > JUMPCD) {
            lastjump = currentTime;
            velY = 7;
        }
        velY = velY - 0.1f;
        body.setLinearVelocity(0, velY);
        System.out.println(velY);
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
