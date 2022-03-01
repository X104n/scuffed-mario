package desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import screens.ScuffedMario;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("Scuffed mario");
        config.setWindowSizeLimits(800, 480, 9999, 9999);
        config.setWindowIcon("assets/Glory.png");
        new Lwjgl3Application(new ScuffedMario(), config);
    }
}