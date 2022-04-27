package Objects;

import Tools.EntetyBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class Player extends Entity {

    private int jumpCounter;
    GameScreen gameScreen;
    private float SPEED = 0.5f;

    private boolean turnRight;
    private boolean isDrunk = false;

    private boolean hasGun = false;

    private long reloadTime = 1000;
    private long lastShot = System.currentTimeMillis();;


    public Player(float width, float height, Body body, GameScreen gameScreen) {
        super(width, height, body);
        this.speed = 10f;
        this.jumpCounter = 0;
        screen = gameScreen;
        this.entityTexture = new Texture("assets/Images/SmallPlayer.png");
    }

    @Override
    public void update() {
        //setPosition(body.getPosition().x * PPM, body.getPosition().y * PPM);

        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;

        checkUserInput();
    }

    public boolean playerDead(){
        return y <= 0f;
    }


    @Override
    public boolean collide(Player player) {
        return false;
    }

    private void checkUserInput(){
        velX = 0;
        long time = System.currentTimeMillis();
        if(time % 1000 > 500){
            this.entityTexture = new Texture("assets/Images/SmallPlayer.png");
        }else{
            this.entityTexture = new Texture("assets/Images/BigPlayer.png");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            this.entityTexture = new Texture("assets/Images/RunningRight.png");
            velX = SPEED;
            turnRight = true;

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            this.entityTexture = new Texture("assets/Images/RunningLeft.png");
            velX = -SPEED;
            turnRight = false;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && jumpCounter < 2){
            float force = body.getMass() * 18;
            body.setLinearVelocity(body.getLinearVelocity().x, 0);
            body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
            jumpCounter++;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q) && this.isDrunk && time - lastShot > reloadTime){
            shoot();
            lastShot = time;
        }


        // reset jump counter
        if(body.getLinearVelocity().y == 0){
            jumpCounter = 0;
        }

        body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
        System.out.println(width);
        if(x < width/2){
            body.setTransform(1, body.getPosition().y, 0);
        }
    }


    //Method returns a rectangle covering the players hitbox, but with +1 in every direction, such that the rectangle overlaps other rectangles within distance 1
    public Rectangle getBounds(){
        return new Rectangle((int) this.x - (int) this.width / 2 - 1, (int) this.y - (int) this.height / 2 - 1, (int) (this.width) + 2,(int) (this.height) + 2);
    }

    private void shoot(){
        float w = -2*width;
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

    public void getDrunk(){
        isDrunk = true;
        SPEED = SPEED*2;
        //entityTexture = new Texture("assets/Images/drunkzelensky.png");
    }

    public boolean deathCriterium(Entity player){
        if(false)
            return true;
        return false;
    }
}