package simplestategame;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.*;

public class GamePlaySaves {
	
	public GamePlaySaves() {}
	
	public ArrayList<String> Completed() {
		ArrayList<String> comp_level = new ArrayList<String>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("lib/Saves.xml"));
			
			Element saves = doc.getDocumentElement();
			String comp1 = saves.getElementsByTagName("one").item(0).getTextContent();
			String comp2 = saves.getElementsByTagName("two").item(0).getTextContent();
			comp_level.add(comp1);
			comp_level.add(comp2);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return comp_level;
	}
	public void UpdateCompleted(String level, String status) {
		try {
			DocumentBuilderFactory factory_v2 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder_v2 = factory_v2.newDocumentBuilder();
			Document doc_v2 = builder_v2.parse(new File("lib/Saves.xml"));
			
			Element saves_v2 = doc_v2.getDocumentElement();
			saves_v2.getElementsByTagName(level).item(0).setTextContent(status);
			
			TransformerFactory transformerfactory_v2 = TransformerFactory.newInstance();
			Transformer transformer_v2 = transformerfactory_v2.newTransformer();
			DOMSource source_v2 = new DOMSource(doc_v2);
			StreamResult console_v2 = new StreamResult(new File("lib/saves.xml"));
			transformer_v2.transform(source_v2, console_v2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String Load() {
		String load_level = "0";
		try {
			DocumentBuilderFactory factory_v3 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder_v3 = factory_v3.newDocumentBuilder();
			Document doc_v3 = builder_v3.parse(new File("lib/Saves.xml"));
			
			Element saves_v3 = doc_v3.getDocumentElement();
			load_level = saves_v3.getElementsByTagName("load").item(0).getTextContent();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return load_level;
	}
	public void UpdateLoad(String selected) {
		try {
			DocumentBuilderFactory factory_v4 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder_v4 = factory_v4.newDocumentBuilder();
			Document doc_v4 = builder_v4.parse(new File("lib/Saves.xml"));
			
			Element saves_v4 = doc_v4.getDocumentElement();
			saves_v4.getElementsByTagName("load").item(0).setTextContent(selected);
			
			TransformerFactory transformerfactory_v4 = TransformerFactory.newInstance();
			Transformer transformer_v4 = transformerfactory_v4.newTransformer();
			DOMSource source_v4 = new DOMSource(doc_v4);
			StreamResult console_v4 = new StreamResult(new File("lib/saves.xml"));
			transformer_v4.transform(source_v4, console_v4);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
