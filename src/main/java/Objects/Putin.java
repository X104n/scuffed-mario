package Objects;

import Tools.EntetyBuilder;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class Putin extends Entity{

    long lastTurn;
    long lastShot;
    boolean turnRight = false;

    int timeBeforeTurn = 2000;
    int reloadSpeed = 1000;
    int gunDamage = 50;


    public Putin(float width, float height, Body body, GameScreen screen) {
        super(width, height, body);
        super.type = ObjectType.PUTIN;
        HP = 1;
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
            shoot();
            lastShot = time;
        }
        body.setLinearVelocity(velX, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
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
        spawnSmallPutin((int) this.getBody().getPosition().x * (int) PPM, (int) this.getBody().getPosition().y * (int) PPM + 1, (int) this.getWidth()*3, (int) this.getHeight());
        screen.getWorld().destroyBody(this.getBody());
        screen.enemies.remove(this);
    }

    private void spawnSmallPutin(int x, int y, int w, int h){
        com.badlogic.gdx.math.Rectangle rectangle = new com.badlogic.gdx.math.Rectangle(x,y,w,h/2);

        Body body = EntetyBuilder.createBody(
                rectangle.getX() + rectangle.getWidth() / 2,
                rectangle.getY() - rectangle.getHeight() / 2,
                rectangle.getWidth(),
                rectangle.getHeight(),
                false,
                screen.getWorld()
        );
       screen.enemies.add(new SmallPutin(rectangle.getWidth(), rectangle.getHeight(), body, super.screen));
    }

    private void shoot(){
        float w = -2f*width;
        if(turnRight)
            w = -w;
        com.badlogic.gdx.math.Rectangle rectangle = new com.badlogic.gdx.math.Rectangle(x+w/2,y,20,10);

        Body body = EntetyBuilder.createBody(
                rectangle.getX() + rectangle.getWidth() / 2,
                rectangle.getY() - rectangle.getHeight() * 0.8f,
                rectangle.getWidth(),
                rectangle.getHeight(),
                false,
                screen.getWorld()
        );
        new Bullet(20, 10, body, screen, (boolean) turnRight, false, gunDamage);
    }

    public boolean deathCriterium(Entity player){
        if((int) (player.getBody().getPosition().y + 1)* PPM - (int) player.getHeight() > (int) this.getBody().getPosition().y * PPM)
            return true;
        return false;
    }
}
