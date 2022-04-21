package Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import screens.GameScreen;

import java.awt.*;

public class Boss extends Entity{


    GameScreen screen;
    public Boss(float width, float height, Body body, GameScreen screen) {
        super(width, height, body);

        this.screen = screen;
        super.type = ObjectType.BOSS;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) this.x - (int) this.width / 2, (int) this.y - (int) this.height / 2, (int) this.width, (int) this.height);
    }

    @Override
    public boolean deathCriterium(Entity player) {
        return false;
    }
}
