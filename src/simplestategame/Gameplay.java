package simplestategame;
import java.util.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import simplestategame.CharacterCollision;
import simplestategame.LoadLevels;

public class Gameplay extends BasicGameState implements InputProviderListener{
	
	public static final int ID = 1;
	
	float[] spawns;
	ArrayList<Rectangle> barriers;
	float mpos_x;
	float mpos_y;
	
	float char1_x;
	float char1_y;
	float char1_dx = 0;
	float char1_dy = 0;
	float char1_ddy = 600;
	//fire character initials
	
	float char2_x;
	float char2_y;
	float char2_dx = 0;
	float char2_dy = 0;
	float char2_ddy = 600;
	//water character initials
	
	boolean char_choose = true;
	private Command color = new BasicCommand("color");
	private Command reload = new BasicCommand("reload");
	String level_select;
	int screen = 0;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		InputProvider keys = new InputProvider(gc.getInput());
		keys.addListener(this);
		keys.bindCommand(new KeyControl(Input.KEY_S), color);
		keys.bindCommand(new KeyControl(Input.KEY_R), reload);
		//binds space key to the command to switch characters
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		float miliseconds = i;
		float conv = 1000;
		float seconds = miliseconds / conv;
		//sets seconds since the last frame was loaded
		
		Input input = gc.getInput();
		this.mpos_x = input.getMouseX();
		this.mpos_y = input.getMouseY();
		
		if(this.screen == 0) {
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				if(this.mpos_x >= 100 && this.mpos_x <= 150 && this.mpos_y >= 100 && this.mpos_y <= 150) {
					this.screen = 1;
					this.level_select = "1";
					this.spawns = LoadLevels.LevelOneStart();
					this.barriers = LoadLevels.LevelOne();
					this.char1_x = this.spawns[0];
					this.char1_y = this.spawns[1];
					this.char2_x = this.spawns[2];
					this.char2_y = this.spawns[3];
				}
				else if(this.mpos_x >= 200 && this.mpos_x <= 250 && this.mpos_y >= 100 && this.mpos_y <= 150) {
					this.screen = 1;
					this.level_select = "2";
					this.spawns = LoadLevels.LevelTwoStart();
					this.barriers = LoadLevels.LevelTwo();
					this.char1_x = this.spawns[0];
					this.char1_y = this.spawns[1];
					this.char2_x = this.spawns[2];
					this.char2_y = this.spawns[3];
				}
			}		
		}
		
		if(this.screen == 1) {
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				if(this.mpos_x >= 20 && this.mpos_x <= 40 && this.mpos_y >= 20 && this.mpos_y <= 40) {
					this.char1_x = this.spawns[0];
					this.char1_y = this.spawns[1];
					this.char1_dx = 0;
					this.char1_dy = 0;
					this.char1_ddy = 0;
					//fire character initials
					
					this.char2_x = this.spawns[2];
					this.char2_y = this.spawns[3];
					this.char2_dx = 0;
					this.char2_dy = 0;
					this.char2_ddy = 0;
					
					this.screen = 0;
					sbg.enterState(0);
				}
			}
			
			if(this.char_choose == true) {
				if(input.isKeyDown(Input.KEY_LEFT) || input.isControllerLeft(1)) {
					this.char1_dx = -150;
				}
				else if(input.isKeyDown(Input.KEY_RIGHT) || input.isControllerRight(1)) {
					this.char1_dx = 150;
				}
				else {
					this.char1_dx = 0;
				}
				if((input.isKeyPressed(Input.KEY_UP) || input.isControlPressed(4, 1)) && this.char1_ddy == 0) {
					this.char1_y -= 2;
					this.char1_dy = -370;
					this.char1_ddy = 600;
				}
				//changes the movement values based on the pressed key for red character
			}
			else {
				if(input.isKeyDown(Input.KEY_LEFT) || input.isControllerLeft(1)) {
					this.char2_dx = -150;
				}
				else if(input.isKeyDown(Input.KEY_RIGHT) || input.isControllerRight(1)) {
					this.char2_dx = 150;
				}
				else {
					this.char2_dx = 0;
				}
				if((input.isKeyPressed(Input.KEY_UP) || input.isControlPressed(4, 1)) && this.char2_ddy == 0) {
					this.char2_y -= 2;
					this.char2_dy = -370;
					this.char2_ddy = 600;
				}
				//changes the movement values based on the pressed key for the blue character
			}
	
			Rectangle char1 = new Rectangle(this.char1_x, this.char1_y, 30, 60);
			Rectangle char2 = new Rectangle(this.char2_x, this.char2_y, 30, 60);
			
			this.char1_ddy = 600;
			for(Rectangle element: this.barriers) {
				CharacterCollision collide = new CharacterCollision(char1, element, this.char1_x, this.char1_y, this.char1_dx, this.char1_dy, this.char1_ddy);
				this.char1_x = collide.characterX();
				this.char1_y = collide.characterY();
				this.char1_dx = collide.characterDX();
				this.char1_dy = collide.characterDY();
				this.char1_ddy = collide.characterDDY();
				//collision for character 1 with any barrier
			}
			
			this.char2_ddy = 600;
			for(Rectangle element: this.barriers) {
				CharacterCollision collide = new CharacterCollision(char2, element, this.char2_x, this.char2_y, this.char2_dx, this.char2_dy, this.char2_ddy);
				this.char2_x = collide.characterX();
				this.char2_y = collide.characterY();
				this.char2_dx = collide.characterDX();
				this.char2_dy = collide.characterDY();
				this.char2_ddy = collide.characterDDY();
				//collision for character 2
			}
			
			this.char1_x += this.char1_dx * seconds;
			this.char1_y += this.char1_dy * seconds;
			this.char1_dy += this.char1_ddy * seconds;
			
			this.char2_x += this.char2_dx * seconds;
			this.char2_y += this.char2_dy * seconds;
			this.char2_dy += this.char2_ddy * seconds;
			//changes the character position and speed values based on their derivatives
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(this.screen == 1) {
			Image fire_stand = new Image("lib/fireboy.png");
			Image water_stand = new Image("lib/watergirl.png");
			Color floor_color = new Color(0, 0, 0);
			
			g.setBackground(Color.gray);
			g.setColor(floor_color);
			for(Rectangle element: barriers) {
				g.fill(element);
			}
			//creates the barriers
	
			g.setColor(Color.white);
			g.fillRect(20, 20, 20, 20);
			g.drawRect(this.char1_x,  this.char1_y,  30,  60);
			g.drawRect(this.char2_x, this.char2_y, 30, 60);
			fire_stand.draw(this.char1_x, this.char1_y, 30, 60);
			water_stand.draw(this.char2_x, this.char2_y, 30, 60);
			//renders the blue and red character to the screen
		}
		else if(this.screen == 0){
			g.setBackground(Color.black);
			g.setColor(Color.white);
			g.fillRect(100, 100, 50, 50);
			g.fillRect(200, 100, 50, 50);
		}
	}
	
	public void controlPressed(Command command) {
		if(command == color) {
			this.char_choose = !this.char_choose;
			if(this.char_choose == true) {
				this.char2_dx = 0;
			}
			else {
				this.char1_dx = 0;
			}
			//when space is pressed, the character variable changes allowing you to change control
		}
		else if(command == reload) {
			this.char1_x = this.spawns[0];
			this.char1_y = this.spawns[1];
			this.char1_dx = 0;
			this.char1_dy = 0;
			this.char1_ddy = 0;
			//fire character initials
			
			this.char2_x = this.spawns[2];
			this.char2_y = this.spawns[3];
			this.char2_dx = 0;
			this.char2_dy = 0;
			this.char2_ddy = 0;
			//water character initials
		}
	}
	public void controlReleased(Command command) {}
	
	@Override
	public int getID() {
		return Gameplay.ID;
	}
}
