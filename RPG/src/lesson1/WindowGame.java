package lesson1;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class WindowGame extends BasicGame {
	
	private GameContainer container;
	private TiledMap map;
	
    public WindowGame() {
        super("Lesson 1 :: WindowGame");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.container = container;
        this.map = new TiledMap("src/main/resources/map/map.tmx");
    }

    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	this.map.render(0, 0);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    }

	public static void main(String[] args)  throws SlickException {
        new AppGameContainer(new WindowGame(), 950, 580, false).start();
		// TODO Auto-generated method stub

	}

}
