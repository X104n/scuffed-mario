package Objects;

import Tools.EntetyBuilder;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;
import screens.YouWonScreen;

import java.awt.*;

import static Tools.Constants.PPM;
import static org.apache.commons.lang.math.RandomUtils.nextFloat;

public class Boss extends Entity{

    long lastTurn;
    long lastShot;
    boolean turnRight = false;

    int timeBeforeTurn = 2000;
    int reloadSpeed = 80;
    int gunDamage = 50;


    public Boss(float width, float height, Body body, GameScreen screen) {
        super(width, height, body);
        super.type = ObjectType.PUTIN;
        HP = 2000;
        lastTurn = System.currentTimeMillis();
        lastShot = System.currentTimeMillis();
        velX = 1.5f;
        super.screen = screen;
        this.entityTexture = new Texture("assets/Images/putin.png");
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        long time = System.currentTimeMillis();
        if(time - lastTurn > timeBeforeTurn){
            velX -= 2*velX;
            turnRight = !turnRight;
            lastTurn = time;
        }
        if(time-lastShot > reloadSpeed){
            shoot(true);
            shoot(false);
            lastShot = time;
        }
        body.setLinearVelocity(0, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    @Override
    public boolean collide(Player player){
        if(deathCriterium(player)) {
            this.die();
            return true;
        }
        return false;
    }

    @Override
    public void die(){
        screen.getWorld().destroyBody(this.getBody());
        screen.enemies.remove(this);
        screen.victory();
    }


    private void shoot(boolean Right){
        float w = -2f*width;
        if(turnRight)
            w = -w;
        com.badlogic.gdx.math.Rectangle rectangle = new com.badlogic.gdx.math.Rectangle(x+w/2,y  + ((nextFloat() - 0.5f)*1.5f*this.getHeight()),20,10);

        Body body = EntetyBuilder.createBody(
                rectangle.getX() + rectangle.getWidth() / 2,
                rectangle.getY() - rectangle.getHeight() * 0.8f,
                rectangle.getWidth(),
                rectangle.getHeight(),
                false,
                screen.getWorld()
        );
        new Bullet(20, 10, body, screen, (boolean) Right, false, gunDamage);
    }

    public boolean deathCriterium(Entity player){
        if((int) (player.getBody().getPosition().y + 1)* PPM - (int) player.getHeight() > (int) this.getBody().getPosition().y * PPM)
            return true;
        return false;
    }
}
