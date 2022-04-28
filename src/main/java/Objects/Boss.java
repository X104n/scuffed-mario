package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

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
    public void die() {
        screen.getWorld().destroyBody(this.getBody());
        screen.enemies.remove(this);
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
