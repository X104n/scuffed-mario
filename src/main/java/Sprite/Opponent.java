package Sprite;

import com.badlogic.gdx.physics.box2d.*;

public class Opponent {
    public World world;
    public Body b2body;

    public Opponent(World world) {
        this.world = world;
        defineOpponent();
    }
    public void defineOpponent() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(50, 32);
        bdef.type = BodyDef.BodyType.DynamicBody;

        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);

        fdef.shape = shape;
        b2body.createFixture(fdef);

    }
}
