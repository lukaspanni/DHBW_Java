package dhbw.exercise.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Gazetteer {

	public Gazetteer() {
	}

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse("https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml");
			org.w3c.dom.Element root = doc.getDocumentElement();
			org.w3c.dom.Node result = root.getElementsByTagName("result").item(0);
			for (int i = 0; i < result.getChildNodes().getLength(); i++) {
				if (result.getChildNodes().item(i).getNodeName().equals("formatted_address")) {
					System.out.println("Address: " + result.getChildNodes().item(i).getTextContent());
				}
				if (result.getChildNodes().item(i).getNodeName().equals("address_component")) {
					if (result.getChildNodes().item(i).hasChildNodes()) {
						if (result.getChildNodes().item(i).getChildNodes().item(2).getNodeValue().equals("locality")) {
							System.out.println("Long Name: "
									+ result.getChildNodes().item(i).getChildNodes().item(0).getTextContent());
						}
					}
				}
				if (result.getChildNodes().item(i).getNodeName().equals("geometry")) {
					org.w3c.dom.Node geom = result.getChildNodes().item(i);
					for (int j = 0; j < geom.getChildNodes().getLength(); j++) {
						if (geom.getChildNodes().item(j).getNodeName().equals("location")) {
							System.out.print("Location: [lat: "
									+ geom.getChildNodes().item(j).getChildNodes().item(1).getTextContent());
							System.out.println(", lng: "
									+ geom.getChildNodes().item(j).getChildNodes().item(3).getTextContent() + "]");
						}
						if (geom.getChildNodes().item(j).getNodeName().equals("bounds")) {
							System.out.print("Bounds: [east: " + geom.getChildNodes().item(j).getChildNodes().item(1)
									.getChildNodes().item(1).getTextContent());
							System.out.print(", north: " + geom.getChildNodes().item(j).getChildNodes().item(1)
									.getChildNodes().item(3).getTextContent());
							System.out.print(", west: " + geom.getChildNodes().item(j).getChildNodes().item(3)
									.getChildNodes().item(1).getTextContent());
							System.out.println(", south: " + geom.getChildNodes().item(j).getChildNodes().item(3)
									.getChildNodes().item(3).getTextContent() + "]");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
