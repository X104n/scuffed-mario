package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationClass {
        public static Texture run_sprite;
        private static int sheet_row = 4;
        private static int sheet_col = 5;

        Animation run_animation;
        static TextureRegion[] run_frames;
        static TextureRegion current_frames;
        static float running_time;

        boolean is_running;

        public void create(){
                run_sprite = new Texture("asset/MarioRunSheet.png");
                TextureRegion[][] temp = TextureRegion.split(run_sprite,
                        run_sprite.getWidth()/sheet_col,
                        run_sprite.getHeight()/sheet_row);

                run_frames = new TextureRegion[5];
                run_frames[0] = temp[3][0];
                run_frames[1] = temp[4][0];
                run_frames[2] = temp[0][1];
                run_frames[3] = temp[1][1];
                run_frames[4] = temp[2][1];

                run_animation = new Animation(0.1f, run_frames);
                running_time = 0f;
        }
}
