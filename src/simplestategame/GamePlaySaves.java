package simplestategame;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class GamePlaySaves {
	
	Document doc;
	ArrayList<String> comp_level = new ArrayList<String>();
	ArrayList<String> curr_level = new ArrayList<String>();
	String load_level;
	
	public GamePlaySaves() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.doc = builder.parse(new File("lib/Saves.xml"));
			Element saves = doc.getDocumentElement();
			
			NodeList completed = saves.getElementsByTagName("completed");
			Element comp = (Element) completed.item(0);
			String comp1 = comp.getElementsByTagName("one").item(0).getTextContent();
			String comp2 = comp.getElementsByTagName("two").item(0).getTextContent();
			this.comp_level.add(comp1);
			this.comp_level.add(comp2);
			
			NodeList current = saves.getElementsByTagName("current");
			Element curr = (Element) current.item(0);
			String curr1 = curr.getElementsByTagName("one").item(0).getTextContent();
			String curr2 = curr.getElementsByTagName("two").item(0).getTextContent();
			this.curr_level.add(curr1);
			this.curr_level.add(curr2);
			
			NodeList load = saves.getElementsByTagName("load");
			String sLoad = load.item(0).getTextContent();
			this.load_level = sLoad;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> Completed() {
		return this.comp_level;
	}
	public ArrayList<String> Current() {
		return this.curr_level;
	}
	public String Load() {
		return this.load_level;
	}
	public void UpdateLoad(String selected) {
		
	}
}
