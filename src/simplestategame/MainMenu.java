package simplestategame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainMenu extends BasicGameState{
	public static final int ID = 0;
	float pos_x;
	float pos_y;
	int screen = 0;
	String level_choose;
	GamePlaySaves game_saves = new GamePlaySaves();

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input input = gc.getInput();
		this.pos_x = input.getMouseX();
		this.pos_y = input.getMouseY();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			if(this.pos_x >= 540 && this.pos_x <= 740 && this.pos_y >= 400 && this.pos_y <= 500) {
				sbg.enterState(1);
			}
		}
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.black);
		g.setColor(Color.white);
		g.fillRect(540, 400, 200, 100);
	}

	@Override
	public int getID() {
		return MainMenu.ID;
	}
}
