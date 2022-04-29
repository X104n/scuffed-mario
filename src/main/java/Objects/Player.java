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

    private boolean hasPistol = false;
    private boolean hasAR = false;
    private int gunDamage = 0;


    private long reloadTime = 1000;
    private long lastShot = System.currentTimeMillis();;

    private String IdleSmallPlayerRight = "assets/Images/SmallPlayer.png";
    private String IdleSmallPlayerLeft = "assets/Images/SmallPlayer.png";
    private String IdleBigPlayerRight = "assets/Images/BigPlayer.png";
    private String IdleBigPlayerLeft = "assets/Images/BigPlayer.png";
    private String RunningLeft = "assets/Images/RunningLeft.png";
    private String RunningRight = "assets/Images/RunningRight.png";


    public Player(float width, float height, Body body, GameScreen gameScreen) {
        super(width, height, body);
        this.speed = 10f;
        this.jumpCounter = 0;
        screen = gameScreen;
        HP = 100;
        this.entityTexture = new Texture(IdleSmallPlayerRight);
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
        if(time % 1500 > 750){
            if(turnRight)this.entityTexture = new Texture(IdleSmallPlayerRight);
            else this.entityTexture = new Texture(IdleSmallPlayerLeft);
        }else{
            if(turnRight) this.entityTexture = new Texture(IdleBigPlayerRight);
            else this.entityTexture = new Texture(IdleBigPlayerLeft);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            this.entityTexture = new Texture(RunningRight);
            velX = SPEED;
            turnRight = true;

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            this.entityTexture = new Texture(RunningLeft);
            velX = -SPEED;
            turnRight = false;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && jumpCounter < 2){
            float force = body.getMass() * 18;
            body.setLinearVelocity(body.getLinearVelocity().x, 0);
            body.applyLinearImpulse(new Vector2(0, force), body.getPosition(), true);
            jumpCounter++;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q) && (hasAR || hasPistol) && time - lastShot > reloadTime){
            shoot();
            lastShot = time;
        }


        // reset jump counter
        if(body.getLinearVelocity().y == 0){
            jumpCounter = 0;
        }

        body.setLinearVelocity(velX * speed, body.getLinearVelocity().y < 25 ? body.getLinearVelocity().y : 25);
        if(x < width/2){
            body.setTransform(1, body.getPosition().y, 0);
        }
        if(x > screen.mapPixelWidth - width/2){
            body.setTransform((screen.mapPixelWidth - width)/PPM, body.getPosition().y, 0);
        }

    }


    //Method returns a rectangle covering the players hitbox, but with +1 in every direction, such that the rectangle overlaps other rectangles within distance 1
    public Rectangle getBounds(){
        return new Rectangle((int) this.x - (int) this.width / 2 - 1, (int) this.y - (int) this.height / 2 - 1, (int) (this.width) + 2,(int) (this.height) + 2);
    }

    private void shoot(){
        float w = -1.5f*width;
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
        new Bullet(20, 10, body, screen, (boolean) turnRight, true, gunDamage);
    }

    public void die(){ this.isAlive = false; }

    public void getDrunk(){
        isDrunk = true;
        SPEED = SPEED += 0.5;
    }

    public void pickupAR(){
        hasAR = true;
        gunDamage = 10;
        reloadTime = (long) 180;
        IdleSmallPlayerLeft = "assets/Images/SmallPlayerAKLeft.png";
        IdleSmallPlayerRight = "assets/Images/SmallPlayerAKRight.png";
        IdleBigPlayerLeft = "assets/Images/BigPlayerAKleft.png";
        IdleBigPlayerRight = "assets/Images/BigPlayerAKRight.png";
        RunningLeft = "assets/Images/RunningLeftAK.png";
        RunningRight = "assets/Images/RunningRightAK.png";
    }

    public boolean deathCriterium(Entity player){
        if(false)
            return true;
        return false;
    }

    public void pickupPistol() {
        if(hasAR) return;
        gunDamage = 20;
        hasPistol = true;
        reloadTime = (long) 1200;
        IdleSmallPlayerLeft = "assets/Images/SmallPlayerPistolLeft.png";
        IdleSmallPlayerRight = "assets/Images/SmallPlayerPistolRight.png";
        IdleBigPlayerLeft = "assets/Images/BigPlayerPistolleft.png";
        IdleBigPlayerRight = "assets/Images/BigPlayerPistolRight.png";
        RunningLeft = "assets/Images/RunningLeftPistol.png";
        RunningRight = "assets/Images/RunningRightPistol.png";
    }
}