package simplestategame;

import java.util.*;
import org.newdawn.slick.geom.Rectangle;

public class LoadLevels {
	
	public LoadLevels() {}
	
	public static ArrayList<Rectangle> LevelOne() {
		Rectangle ground = new Rectangle(0, 660, 1280, 80);
		Rectangle floor1 = new Rectangle(200, 550, 880, 25);
		Rectangle wall1 = new Rectangle(0, 0, 25, 720);
		Rectangle wall2 = new Rectangle(1255, 0, 25, 720);
		Rectangle ceiling = new Rectangle(0, 0, 1280, 25);
		ArrayList<Rectangle> barriers = new ArrayList<Rectangle>();
		barriers.add(ground);
		barriers.add(floor1);
		barriers.add(wall1);
		barriers.add(wall2);
		barriers.add(ceiling);
		return barriers;
	}
	
	public static float[] LevelOneStart() {
		float[] spawns = {300, 489, 900, 599};
		return spawns;
	}
	
	public static ArrayList<Rectangle> LevelTwo() {
		Rectangle ground = new Rectangle(0, 660, 1280, 80);
		Rectangle wall1 = new Rectangle(0, 0, 25, 720);
		Rectangle wall2 = new Rectangle(1255, 0, 25, 720);
		Rectangle ceiling = new Rectangle(0, 0, 1280, 25);
		ArrayList<Rectangle> barriers = new ArrayList<Rectangle>();
		barriers.add(ground);
		barriers.add(wall1);
		barriers.add(wall2);
		barriers.add(ceiling);
		return barriers;
	}
	
	public static float[] LevelTwoStart() {
		float[] spawns = {300, 599, 900, 599};
		return spawns;
	}
}
