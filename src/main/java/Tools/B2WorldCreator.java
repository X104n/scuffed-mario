package Tools;

import Sprite.Brick;
import Sprite.Coin;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import screens.ScuffedMario;

public class B2WorldCreator {
    public B2WorldCreator(World world, TiledMap map) {
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        /**
         * All of these for loops should not be in the constructor, this is just to test if the code works
         */


        // Create ground object
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {

            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / ScuffedMario.PPM, (rect.getY() + rect.getHeight() / 2) / ScuffedMario.PPM);

            body = world.createBody(bdef);

            shape.setAsBox((rect.getWidth() / 2) / ScuffedMario.PPM, (rect.getHeight() / 2) / ScuffedMario.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);

        }

        // Create pipe objects
        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Pipes(world, map, rect);
        }

        // Create coin objects
        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Coin(world, map, rect);
        }

        // Create brick objects
        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            new Brick(world, map, rect);
        }
    }
}
