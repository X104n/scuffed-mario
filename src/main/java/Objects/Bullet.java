package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class Bullet extends Entity{

    Texture image;
    boolean right;
    float lastX;
    public boolean friendly;
    public int gunDamage;
    public long spawnTime;

    public Bullet(float width, float height, Body body, GameScreen gameScreen, boolean goesRight, boolean friendly, int gunDamage){
        super(width, height, body);
        super.screen = gameScreen;
        HP = 1;
        spawnTime = System.currentTimeMillis();
        this.gunDamage = gunDamage;
        this.entityTexture = new Texture("assets/Images/bullet.png");
        if(goesRight)
            velX = 12f;
        else
            velX = -12f;
        super.type = ObjectType.BULLET;
        this.friendly = friendly;
        gameScreen.bullets.add(this);
    }

    public void setDirectionRight(){
        right = true;
    }
    public void setDirectionLeft(){
        right = false;
    }

    public boolean isFriendly(){
        return this.friendly;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        body.setLinearVelocity(velX, 0.45f);
        if(System.currentTimeMillis() - spawnTime > 5000){
            this.die();
            return;
        }
        if(Math.abs(body.getPosition().x - lastX) < 0.06){
            this.die();
            return;
        }
        lastX = body.getPosition().x;
    }

    @Override
    public void die() {
        screen.getWorld().destroyBody(body);
        screen.bullets.remove(this);
    }

    public boolean collide(Player player){
        player.die();
        return false;
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
