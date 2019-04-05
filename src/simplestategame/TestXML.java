package simplestategame;
import java.util.*;

public class TestXML {
	public static void main(String[] args) {
		GamePlaySaves save_states = new GamePlaySaves();
		ArrayList<String> before = save_states.Completed();
		System.out.println(before);
		save_states.UpdateCompleted("one", "1");
		ArrayList<String> after = save_states.Completed();
		System.out.println(after);
	}
}
