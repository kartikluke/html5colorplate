import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParserKuler extends DefaultHandler {
	SwatchAcceptor sa = new SwatchAcceptor();
	public void startDocument() {
	}
	public void endDocument() {
		System.out.println("HexCodes: ");
		sa.display();
	}
	public void startElement(String nameSpaceURI, String localName, String qName, Attributes atts) {
		sa.SwatchHexColor(qName);
	}
	public void endElement(String nameSpaceURI, String localName, String qName) {
		sa.close();
	}
	public void characters(char[] ch, int start, int length) {
		String color = "";
		for(int i=start;i<(start+length);i++){
			color+=ch[i];
		}
		sa.readColor(color);
	}
	
}
