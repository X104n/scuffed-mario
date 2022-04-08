package Objects;

import Tools.EntetyBuilder;
import com.badlogic.gdx.Game;
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

    GameScreen screen;

    public Putin(float width, float height, Body body, GameScreen screen) {
        super(width, height, body);
        super.isPutin = true;

        lastTurn = System.currentTimeMillis();
        lastShot = System.currentTimeMillis();
        velX = 1.5f;
        this.screen = screen;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        long time = System.currentTimeMillis();
        if(time - lastTurn > timeBeforeTurn){
            velX -= 2*velX;
            System.out.println(velX);
            turnRight = !turnRight;
            lastTurn = time;
        }
        if(time-lastShot > reloadSpeed){
            shoot();
            lastShot = time;
        }
        body.setLinearVelocity(velX, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
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

    private void shoot(){
        float w = -width;
        if(turnRight)
            w = -w;
        com.badlogic.gdx.math.Rectangle rectangle = new com.badlogic.gdx.math.Rectangle(x+w/2,y,20,10);

        Body body = EntetyBuilder.createBody(
                rectangle.getX() + rectangle.getWidth() / 2,
                rectangle.getY() - rectangle.getHeight() / 2,
                rectangle.getWidth(),
                rectangle.getHeight(),
                false,
                screen.getWorld()
        );
        screen.enemies.add(new Bullet(20, 10, body, screen, (boolean) turnRight));
    }

    public boolean deathCriterium(Entity player){
        if((int) (player.getBody().getPosition().y + 1)* PPM - (int) player.getHeight() > (int) this.getBody().getPosition().y * PPM)
            return true;
        return false;
    }
}
