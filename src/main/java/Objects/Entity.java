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

    public void render(SpriteBatch batch) {
        batch.draw(entityTexture, x-width/2, y-height/2, width, height);
    }

    public float getHeight(){ return this.height; }

    public float getWidth(){ return this.width; }

    public Body getBody(){
        return body;
    }

    public abstract boolean collide(Player player);

    public ObjectType getObjType() { return type; }

    public boolean isAlive(){ return this.isAlive; }

    public void die(){ this.isAlive = false; }

    public abstract Rectangle getBounds();

    public abstract boolean deathCriterium(Entity player);
}
