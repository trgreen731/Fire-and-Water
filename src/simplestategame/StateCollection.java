package simplestategame;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class StateCollection extends StateBasedGame{
	
	public static final int MAINMENU = 0;
	public static final int GAMEPLAY = 1;
	
	public StateCollection(String gamename) {
		super(gamename);
	}
	
    public void initStatesList(GameContainer gc) throws SlickException {
    	this.addState(new MainMenu());
    	this.addState(new Gameplay(1));
    }
	
    public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new StateCollection("Fire and Water"));
			appgc.setDisplayMode(1280, 720, false);
			appgc.setVSync(true);
			appgc.start();
			//sets the screen size and creates the container
		}
		catch (SlickException ex) {
			Logger.getLogger(StateCollection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
