package Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

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

    public Body getBody(){
        return body;
    }
//    protected World world;
//    protected TiledMap map;
//    protected TiledMapTile tile;
//    protected Rectangle bounds;
//    protected Body body;
//
//    public Entity(World world, TiledMap map, Rectangle bounds){
//        this.world = world;
//        this.map = map;
//        this.bounds = bounds;
//    }
}
