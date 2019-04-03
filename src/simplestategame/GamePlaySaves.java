package simplestategame;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;
import java.util.*;

public class GamePlaySaves {
	
	ArrayList<String> comp_level = new ArrayList<String>();
	
	public GamePlaySaves() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("lib/Saves.xml"));
			Element saves = doc.getDocumentElement();
			
			NodeList completed = saves.getElementsByTagName("completed");
			Element comp = (Element) completed.item(0);
			String comp1 = comp.getElementsByTagName("one").item(0).getTextContent();
			String comp2 = comp.getElementsByTagName("two").item(0).getTextContent();
			this.comp_level.add(comp1);
			this.comp_level.add(comp2);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> Completed() {
		return this.comp_level;
	}
	public String Current() {
		String current = "0";
		for(int a = this.comp_level.size() - 1; this.comp_level.get(a) == "0"; a -= 1) {
			current = String.valueOf(a + 1);
		}
		return current;
	}
	public void UpdateCompleted(String level, String status) {
		try {
			DocumentBuilderFactory factory_v2 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder_v2 = factory_v2.newDocumentBuilder();
			Document doc_v2 = builder_v2.parse(new File("lib/Saves.xml"));
			Element saves_v2 = doc_v2.getDocumentElement();
			NodeList completed_v2 = saves_v2.getElementsByTagName("completed");
			Element comp_v2 = (Element) completed_v2.item(0);
			comp_v2.getElementsByTagName(level).item(0).setTextContent(status);
			TransformerFactory transformerfactory = TransformerFactory.newInstance();
			Transformer transformer = transformerfactory.newTransformer();
			DOMSource source = new DOMSource(doc_v2);
			StreamResult console = new StreamResult(System.out);
			transformer.transform(source, console);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
