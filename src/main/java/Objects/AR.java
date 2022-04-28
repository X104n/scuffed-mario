package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class AR extends Entity{
    GameScreen screen;

    public AR(float width, float height, Body body, GameScreen gameScreen){
        super(width, height, body);
        screen = gameScreen;

        this.entityTexture = new Texture("assets/Images/AR.png.crdownload");
        super.type = ObjectType.VODKA;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
    }

    @Override
    public void die() {
        screen.getWorld().destroyBody(this.getBody());
        screen.enemies.remove(this);
    }

    public boolean collide(Player player){
        player.pickupAR();
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
