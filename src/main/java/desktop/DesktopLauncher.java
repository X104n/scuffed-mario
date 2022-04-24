package desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import screens.ScuffedMario;

public class DesktopLauncher {
    public static int width = 800;
    public static int height = 480;
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("Glory to Ukraine");
        config.setWindowIcon("assets/Images/Icon.png");
        config.setWindowSizeLimits(width, height, 9999, 9999);
        new Lwjgl3Application(new ScuffedMario(), config);
    }
}