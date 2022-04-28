package Tools;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    private final AssetManager assetManager = new AssetManager();

    public static final AssetDescriptor<TextureAtlas> TILESET_01 = new AssetDescriptor<TextureAtlas>("assets/UI/uiskin.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Skin> SKIN = new AssetDescriptor<Skin>("uiskin.json", Skin.class, new SkinLoader.SkinParameter("uiskin.json"));

    public void loadAll() {
        assetManager.load(TILESET_01);
        assetManager.load(SKIN);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
