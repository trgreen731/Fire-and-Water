package simplestategame;
import org.newdawn.slick.geom.*;

public class CharacterCollision {
	
	float char_x;
	float char_y;
	float char_dx;
	float char_dy;
	float char_ddy;
	
	public CharacterCollision(Rectangle character, Rectangle rect1, float pos_x, float pos_y, float spd_x, float spd_y, float acc_y) {
		if(character.intersects(rect1)) {
			boolean deltaN = false, deltaS = false, deltaE = false, deltaW = false;
			float a = 0;
			float b = 0;
			
			while(a <= rect1.getWidth()) {
				if(character.contains(rect1.getX() + a, rect1.getY())) {
					deltaN = true;
					break;
				}
				a += 1;
			}
			a = 0;
			while(a <= rect1.getWidth()) {
				if(character.contains(rect1.getX() + a, rect1.getMaxY())) {
					deltaS = true;
					break;
				}
				a += 1;
			}
			a = 0;
			while(a <= rect1.getHeight()) {
				if(character.contains(rect1.getX(), rect1.getY() + a)) {
					deltaW = true;
					break;
				}
				a += 1;
			}
			a = 0;
			while(a <= rect1.getHeight()) {
				if(character.contains(rect1.getMaxX(), rect1.getY() + a)) {
					deltaE = true;
					break;
				}
				a += 1;
			}
			
			if(deltaN && deltaW && !deltaS && !deltaE) {
				a = 0;
				do {
					a += 1;
				} while(rect1.contains(character.getMaxX() - a, character.getMaxY()));
				do {
					b += 1;
				} while(rect1.contains(character.getMaxX(), character.getMaxY() - b));
				if(a <= b) {
					deltaN = false;
				}
				else {
					deltaW = false;
				}
			}
			else if(deltaN && deltaE && !deltaS && !deltaW) {
				a = 0;
				do {
					a += 1;
				} while(rect1.contains(character.getX() + a, character.getMaxY()));
				do {
					b += 1;
				} while(rect1.contains(character.getX(), character.getMaxY() - b));
				if(a <= b) {
					deltaN = false;
				}
				else {
					deltaE = false;
				}
			}
			else if(deltaS && deltaW && !deltaN && !deltaE) {
				a = 0;
				do {
					a += 1;
				} while(rect1.contains(character.getMaxX() - a, character.getY()));
				do {
					b += 1;
				} while(rect1.contains(character.getMaxX(), character.getY() + b));
				if(a <= b) {
					deltaS = false;
				}
				else {
					deltaW = false;
				}
			}
			else if(deltaS && deltaE && !deltaN && !deltaW) {
				a = 0;
				do {
					a += 1;
				} while(rect1.contains(character.getX() + a, character.getY()));
				do {
					b += 1;
				} while(rect1.contains(character.getX(), character.getY() + b));
				if(a <= b) {
					deltaW = false;
				}
				else {
					deltaE = false;
				}
			}
			
			if(deltaN != deltaS) {
				if(deltaN) {
					this.char_y = rect1.getY() - character.getHeight() + 1;
					this.char_dy = 0;
					this.char_ddy = 0;
				}
				else {
					this.char_y = rect1.getMaxY();
					this.char_dy = 0;
					this.char_ddy = acc_y;
				}
			}
			else {
				this.char_y = pos_y;
				this.char_dy = spd_y;
				this.char_ddy = acc_y;
			}
			if(deltaE != deltaW) {
				if(deltaE) {
					this.char_x = rect1.getMaxX();
					this.char_dx = 0;
				}
				else {
					this.char_x = rect1.getX() - character.getWidth();
					this.char_dx = 0;
				}
			}
			else {
				this.char_x = pos_x;
				this.char_dx = spd_x;
			}
		}
		else {
			this.char_x = pos_x;
			this.char_y = pos_y;
			this.char_dx = spd_x;
			this.char_dy = spd_y;
			this.char_ddy = acc_y;
		}
	}
	
	public float characterX() {
		return this.char_x;
	}
	public float characterY() {
		return this.char_y;
	}
	public float characterDX() {
		return this.char_dx;
	}
	public float characterDY() {
		return this.char_dy;
	}
	public float characterDDY() {
		return this.char_ddy;
	}
}
