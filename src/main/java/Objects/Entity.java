package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

public abstract class Entity {
    protected float x, y, velX, velY, speed;
    protected float width, height;
    protected Body body;
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    Texture entityTexture;
    protected boolean isAlive = true;
    GameScreen screen;
    public ObjectType type;
    public int HP;

    public Entity(float width, float height, Body body){
        this.x = body.getPosition().x;
        this.y = body.getPosition().y;
        this.width = width;
        this.height = height;
        this.body = body;
        this.velX = 0;
        this.velY = 0;
        this.speed = 0;
        this.spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
    }

    public abstract void update();

    public void takeDamage(int damage){
        HP -= damage;
        if(HP <= 0){
            this.die();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(entityTexture, x-width/2, y-height/2, width, height);
    }

    public float getHeight(){ return this.height; }

    public float getWidth(){ return this.width; }

    public Body getBody(){
        return body;
    }

    public void die(){
        screen.getWorld().destroyBody(this.getBody());
        screen.enemies.remove(this);
    }

    public abstract boolean collide(Player player);

    public ObjectType getObjType() { return type; }

    public boolean isAlive(){ return this.isAlive; }

    public abstract Rectangle getBounds();

    public abstract boolean deathCriterium(Entity player);

    public double getPosition() {
        return body.getPosition().x;
    }

    public double movePosition(String d, double position) {
        if(d.equals("left")){
            position -= 0.1;
        }
        else if(d.equals("right")){
            position += 0.1;
        }
        return position;
    }
}
