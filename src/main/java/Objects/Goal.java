package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;
import java.util.ArrayList;

import static Tools.Constants.PPM;

public class Goal extends Entity{

    public Goal(float width, float height, Body body, GameScreen gameScreen){
        super(width, height, body);
        body.setGravityScale(0);
        super.screen = gameScreen;
        HP = 1;
        this.entityTexture = new Texture("assets/Images/Door.png");
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        body.setLinearVelocity(0,0);
    }

    @Override
    public void die() {
        screen.reloadMap(1);
    }

    public boolean collide(Player player){
        player.score(1);
        this.die();
        return false;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    @Override
    public boolean deathCriterium(Entity player) {
        return true;
    }
}
