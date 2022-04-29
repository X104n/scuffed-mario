package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

import static Tools.Constants.PPM;

public class Pistol extends Entity{

    public Pistol(float width, float height, Body body, GameScreen gameScreen){
        super(width, height, body);
        super.screen = gameScreen;
        HP = 50;
        this.entityTexture = new Texture("assets/Images/Pistol.png");
        super.type = ObjectType.VODKA;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
    }

    public boolean collide(Player player){
        player.pickupPistol();
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
