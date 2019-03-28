package simplestategame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainMenu extends BasicGameState{
	public static final int ID = 0;
	float pos_x;
	float pos_y;
	int screen = 0;
	int level_choose;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input input = gc.getInput();
		this.pos_x = input.getMouseX();
		this.pos_y = input.getMouseY();
		if(this.screen == 0) {
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				if(this.pos_x >= 540 && this.pos_x <= 740 && this.pos_y >= 400 && this.pos_y <= 500) {
					this.screen = 1;
				}
			}
		}
		else if(this.screen == 1) {
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				if(this.pos_x >= 100 && this.pos_x <= 150 && this.pos_y >= 100 && this.pos_y <= 150) {
					level_choose = 1;
					sbg.enterState(1);
				}
				else if(this.pos_x >= 200 && this.pos_x <= 250 && this.pos_y >= 100 && this.pos_y <= 150) {
					level_choose = 2;
					sbg.enterState(2);
				}
			}
		}
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(this.screen == 0) {
			g.setBackground(Color.black);
			g.setColor(Color.white);
			g.fillRect(540, 400, 200, 100);
		}
		else if(this.screen == 1) {
			g.setBackground(Color.black);
			g.setColor(Color.white);
			g.fillRect(100, 100, 50, 50);
			g.fillRect(200, 100, 50, 50);
		}
	}

	@Override
	public int getID() {
		return MainMenu.ID;
	}
}
