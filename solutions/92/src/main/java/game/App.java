
package game;

import engine.scene;
import engine.window;
import engine.ui.text;
import game.DoublePendulum;

public class App extends window{

    public static void main(String[] args) {
        window.main("game.App", args);
    }

    @Override
    public void keyUpdate() {

    }

    @Override
    public void mouseClick() {

    }

    @Override
    public void mouseWheel() {
    }

    @Override
    public void settings() {
        size(900,800);
        addScene(new scene(this, "start"));
        selectScene("start");
        getScene("start").addEntity(new DoublePendulum(400,400,100,getScene("start"),this), "title");

    }

    @Override
    public void setup() {
        
    }

    @Override
    public void update() {

    }
}
