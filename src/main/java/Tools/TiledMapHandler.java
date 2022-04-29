package Tools;

import Objects.*;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import screens.GameScreen;

import static Tools.Constants.PPM;

public class TiledMapHandler {

    int mapWidth;
    int mapHeight;
    int tilePixelWidth;
    int tilePixelHeight;

    public int mapPixelWidth;
    int mapPixelHeight;
    public TiledMap tiledMap;
    private GameScreen gameScreen;
    public TiledMapHandler(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public OrthoCachedTiledMapRenderer setupMap(String mapName){
        tiledMap = new TmxMapLoader().load(mapName);


/*
        MapProperties prop = tiledMap.getProperties();
        int mapWidth = prop.get("width", Integer.class);
        int mapHeight = prop.get("height", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);

        int mapPixelWidth = mapWidth * tilePixelWidth;
        int mapPixelHeight = mapHeight * tilePixelHeight;
*/

        parseMapObjects(tiledMap.getLayers().get("objects").getObjects());
        return new OrthoCachedTiledMapRenderer(tiledMap);



    }

    public int getMapPixelWidth(){
        return mapPixelWidth;
    }

    public int getMapPixelHeight(){
        return mapPixelHeight;
    }

    private void parseMapObjects(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {
            if (mapObject instanceof PolygonMapObject) {
                createStaticBody((PolygonMapObject) mapObject);
            }

            if (mapObject instanceof RectangleMapObject){
                Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();
                String rectangleName = mapObject.getName();
                if(rectangleName == null || rectangleName == "") continue;
                if(rectangleName.equals("Player")){
                    Body body = createBody(rectangle);
                    gameScreen.setPlayer(new Player(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("Putin"))
                {
                    Body body = createBody(rectangle);
                    gameScreen.enemies.add(new Putin(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("Obstacle"))
                {
                    Body body =createBody(rectangle);
                    gameScreen.enemies.add(new Obstacle(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("Vodka"))
                {
                    Body body = createBody(rectangle);
                    gameScreen.enemies.add(new Vodka(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("AR"))
                {
                    Body body = createBody(rectangle);
                    gameScreen.enemies.add(new AR(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("Pistol"))
                {
                    Body body = createBody(rectangle);
                    gameScreen.enemies.add(new Pistol(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("Coin"))
                {
                    Body body = createBody(rectangle);
                    gameScreen.enemies.add(new Coin(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("Goal"))
                {
                    Body body = createBody(rectangle);
                    gameScreen.enemies.add(new Goal(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }
                if(rectangleName.equals("Boss"))
                {
                    Body body = createBody(rectangle);
                    gameScreen.enemies.add(new Boss(rectangle.getWidth(), rectangle.getHeight(), body, gameScreen));
                }

            }
        }
    }

    private Body createBody(Rectangle rectangle){
        Body body = EntetyBuilder.createBody(
                rectangle.getX() + rectangle.getWidth() /2,
                rectangle.getY() + rectangle.getHeight() / 2,
                rectangle.getWidth(),
                rectangle.getHeight(),
                false,
                gameScreen.getWorld()
        );
        return body;
    }

    private void createStaticBody(PolygonMapObject polygonMapObject) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = gameScreen.getWorld().createBody(bodyDef);
        Shape shape = createPolygonShape(polygonMapObject);
        body.createFixture(shape, 1000);
        shape.dispose();
    }

    private Shape createPolygonShape(PolygonMapObject polygonMapObject) {
        float[] vertices = polygonMapObject.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < vertices.length / 2; i++) {
            Vector2 current = new Vector2(vertices[i * 2] / PPM, vertices[i * 2 + 1] / PPM);
            worldVertices[i] = current;
        }

        PolygonShape shape = new PolygonShape();
        shape.set(worldVertices);
        return shape;
    }

}
