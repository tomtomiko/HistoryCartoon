package Classes;

import javafx.beans.property.SimpleStringProperty;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;

public class Cartoon {
    private SimpleStringProperty caption;
    private SimpleStringProperty symbols;
    private SimpleStringProperty briefInterpretation;
    private SimpleStringProperty imagePath;

    public Cartoon(String caption, String symbols, String briefInterpretation, String imagePath) throws ParserConfigurationException {
        this.caption = new SimpleStringProperty(caption);
        this.symbols = new SimpleStringProperty(symbols);
        this.briefInterpretation = new SimpleStringProperty(briefInterpretation);
        this.imagePath = new SimpleStringProperty(imagePath);

        if (documentFactory != null) {
            documentFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentFactory.newDocumentBuilder();
        }
    }

    public String getImageName() {
        File file = new File(this.imagePath.get());

        return file.getName();
    }

    public String getXmlPath() {
        return "/Users/Tomi/IdeaProjects/HistoryGame/src/txtFiles/" + getImageName() + ".txt";
    }

    public String getCaption() {
        return caption.get();
    }

    public SimpleStringProperty captionProperty() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption.set(caption);
    }

    public String getSymbols() {
        return symbols.get();
    }

    public SimpleStringProperty symbolsProperty() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols.set(symbols);
    }

    public String getBriefInterpretation() {
        return briefInterpretation.get();
    }

    public SimpleStringProperty briefInterpretationProperty() {
        return briefInterpretation;
    }

    public void setBriefInterpretation(String briefInterpretation) {
        this.briefInterpretation.set(briefInterpretation);
    }

    public String getImagePath() {
        return imagePath.get();
    }

    public SimpleStringProperty imagePathProperty() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath.set(imagePath);
    }

    public static DocumentBuilderFactory documentFactory;
    public static DocumentBuilder documentBuilder;

    public void saveToTextFile() {
        try {

            Document document = documentBuilder.newDocument();

            Element root = document.createElement("root");
            document.appendChild(root);

            Element caption = document.createElement("caption");
            caption.appendChild(document.createTextNode(this.getCaption()));
            root.appendChild(caption);

            Element briefInterpretation = document.createElement("briefInterpretation");
            briefInterpretation.appendChild(document.createTextNode(this.getBriefInterpretation()));
            root.appendChild(briefInterpretation);

            Element symbols = document.createElement("symbols");
            symbols.appendChild(document.createTextNode(this.getSymbols()));
            root.appendChild(symbols);

            //create new xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(this.getXmlPath()));

            transformer.transform(domSource, streamResult);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ArrayList<Cartoon> LoadTextFile()
    {
        ArrayList<Cartoon> cartoons = new ArrayList<Cartoon>();


        try{
            Document document = documentBuilder.parse(new File(this.getXmlPath()));

            NodeList nodeList = document.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);

                NodeList childNodes = node.getChildNodes();
                String symbols;
                String briefInt;
                String caption;
                String imagePath;

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);

                }
            }

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return cartoons;
    }
}
