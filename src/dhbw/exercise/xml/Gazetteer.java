package dhbw.exercise.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Gazetteer {

	private String formatted_address;
	private String long_name;
	private double location_lat;
	private double location_lng;
	private double bounds_sw_lat;
	private double bounds_sw_lng;
	private double bounds_ne_lat;
	private double bounds_ne_lng;

	public String getFormatted_address() {
		return formatted_address;
	}

	public String getLong_name() {
		return long_name;
	}

	public double getLocation_lat() {
		return location_lat;
	}

	public double getLocation_lng() {
		return location_lng;
	}

	public double getBounds_sw_lat() {
		return bounds_sw_lat;
	}

	public double getBounds_sw_lng() {
		return bounds_sw_lng;
	}

	public double getBounds_ne_lat() {
		return bounds_ne_lat;
	}

	public double getBounds_ne_lng() {
		return bounds_ne_lng;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}

	public void setLocation_lat(double location_lat) {
		this.location_lat = location_lat;
	}

	public void setLocation_lng(double location_lng) {
		this.location_lng = location_lng;
	}

	public void setBounds_sw_lat(double bounds_sw_lat) {
		this.bounds_sw_lat = bounds_sw_lat;
	}

	public void setBounds_sw_lng(double bounds_sw_lng) {
		this.bounds_sw_lng = bounds_sw_lng;
	}

	public void setBounds_ne_lat(double bounds_ne_lat) {
		this.bounds_ne_lat = bounds_ne_lat;
	}

	public void setBounds_ne_lng(double bounds_ne_lng) {
		this.bounds_ne_lng = bounds_ne_lng;
	}

	@Override
	public String toString() {
		return "Gazetteer [formatted_address=" + formatted_address + ", long_name=" + long_name + ", location_lat="
				+ location_lat + ", location_lng=" + location_lng + ", bounds_sw_lat=" + bounds_sw_lat
				+ ", bounds_sw_lng=" + bounds_sw_lng + ", bounds_ne_lat=" + bounds_ne_lat + ", bounds_ne_lng="
				+ bounds_ne_lng + "]";
	}

	public Gazetteer() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse("https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml");
			org.w3c.dom.Element root = doc.getDocumentElement();
			org.w3c.dom.Node result = root.getElementsByTagName("result").item(0);
			for (int i = 0; i < result.getChildNodes().getLength(); i++) {
				if (result.getChildNodes().item(i).getNodeName().equals("formatted_address")) {
					formatted_address = result.getChildNodes().item(i).getTextContent();
				}
				if (result.getChildNodes().item(i).getNodeName().equals("address_component")) {
					if (result.getChildNodes().item(i).hasChildNodes()) {
						if (result.getChildNodes().item(i).getChildNodes().item(5).getTextContent()
								.equals("locality")) {
							long_name = result.getChildNodes().item(i).getChildNodes().item(1).getTextContent();
						}
					}
				}
				if (result.getChildNodes().item(i).getNodeName().equals("geometry")) {
					org.w3c.dom.Node geom = result.getChildNodes().item(i);
					for (int j = 0; j < geom.getChildNodes().getLength(); j++) {
						if (geom.getChildNodes().item(j).getNodeName().equals("location")) {
							location_lat = Double
									.parseDouble(geom.getChildNodes().item(j).getChildNodes().item(1).getTextContent());
							location_lng = Double
									.parseDouble(geom.getChildNodes().item(j).getChildNodes().item(3).getTextContent());
						}
						if (geom.getChildNodes().item(j).getNodeName().equals("bounds")) {
							bounds_sw_lat = Double.parseDouble(geom.getChildNodes().item(j).getChildNodes().item(1)
									.getChildNodes().item(1).getTextContent());
							bounds_sw_lng = Double.parseDouble(geom.getChildNodes().item(j).getChildNodes().item(1)
									.getChildNodes().item(3).getTextContent());
							bounds_ne_lat = Double.parseDouble(geom.getChildNodes().item(j).getChildNodes().item(3)
									.getChildNodes().item(1).getTextContent());
							bounds_ne_lng = Double.parseDouble(geom.getChildNodes().item(j).getChildNodes().item(3)
									.getChildNodes().item(3).getTextContent());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Gazetteer gaz = new Gazetteer();
		System.out.println(gaz.toString());
	}

}
