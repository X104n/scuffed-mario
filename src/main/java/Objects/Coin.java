package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;
import java.util.ArrayList;

import static Tools.Constants.PPM;

public class Coin extends Entity{
    GameScreen screen;

    public Coin(float width, float height, Body body, GameScreen gameScreen){
        super(width, height, body);
        screen = gameScreen;
        HP = 50;
        this.entityTexture = new Texture("assets/Images/Coin");
        super.type = ObjectType.VODKA;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;
        long time= System.currentTimeMillis();
        time %= 1200;
        if(0<time && time < 200) this.entityTexture = new Texture("assets/Images/Coin");
        else if(200 < time && time < 400) this.entityTexture = new Texture("assets/Images/Coin2");
        else if(400 < time && time < 600) this.entityTexture = new Texture("assets/Images/Coin2");
        else if(600 < time && time < 800) this.entityTexture = new Texture("assets/Images/Coin2");
        else if(800 < time && time < 1000) this.entityTexture = new Texture("assets/Images/Coin2");
        else this.entityTexture = new Texture("assets/Images/Coin2");
    }

    @Override
    public void die() {
        screen.getWorld().destroyBody(this.getBody());
        screen.enemies.remove(this);
    }

    public boolean collide(Player player){
        player.getDrunk();
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
