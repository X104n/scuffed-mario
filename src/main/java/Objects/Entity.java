package Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import java.awt.*;

public abstract class Entity {
    protected float x, y, velX, velY, speed;
    protected float width, height;
    protected Body body;

    public Entity(float width, float height, Body body){
        this.x = body.getPosition().x;
        this.y = body.getPosition().y;
        this.width = width;
        this.height = height;
        this.body = body;
        this.velX = 0;
        this.velY = 0;
        this.speed = 0;
    }

    public abstract void update();

    public abstract void render(SpriteBatch batch);

    public float getHeight(){ return this.height; }

    public float getWidth(){ return this.width; }

    public Body getBody(){
        return body;
    }

    public abstract Rectangle getBounds();
}
