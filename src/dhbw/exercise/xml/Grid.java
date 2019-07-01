package dhbw.exercise.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Grid {

	public Grid() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser;
		try {
			parser = factory.newDocumentBuilder();
			Document doc = parser.newDocument();
			Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
			Element document = doc.createElement("Document");
			kml.appendChild(document);
			doc.appendChild(kml);

			Gazetteer gaz = new Gazetteer();
			double dist_lng = (gaz.getBounds_ne_lng() - gaz.getBounds_sw_lng()) / 5;
			double dist_lat = (gaz.getBounds_ne_lat() - gaz.getBounds_sw_lat()) / 5;
			System.out.println(dist_lng + " " + dist_lat);
			double base_lng = gaz.getBounds_sw_lng();
			double lng = base_lng;
			double lat = gaz.getBounds_ne_lat();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					Node placemark = doc.createElement("Placemark");
					Node point = doc.createElement("Point");
					Node coor = doc.createElement("coordinates");
					coor.setTextContent(String.valueOf(lng) + ", " + String.valueOf(lat));
					point.appendChild(coor);
					placemark.appendChild(point);
					document.appendChild(placemark);
					lng += dist_lng;
				}
				lng = base_lng;
				lat -= dist_lat;
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(String.valueOf(Math.random()) + ".kml"));
			transformer.transform(source, result);
			System.out.println("Finished");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Grid();
	}

}
