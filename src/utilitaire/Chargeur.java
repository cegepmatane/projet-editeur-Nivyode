package utilitaire;

import com.sun.media.jfxmedia.logging.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import modele.Animal;
import modele.Assets;
import modele.ElementChargable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Chargeur {

    public ArrayList<ElementChargable> chargerSauvegarde() {
        Logger.logMsg(Logger.INFO, "Chargeur.chargerSauvegarde()");

        File source = new File(".");
        File[] fichiers = source.listFiles();
        if (fichiers == null) return null;

        File fichierSauvegarde = null;
        for (File fichier : fichiers) {
            if (fichier.getName().equals("export.xml")) {
                fichierSauvegarde = fichier;
                break;
            }
        }
        if (fichierSauvegarde == null) return null;

        System.out.println("fichierSauvegarde : " + fichierSauvegarde.getName());
        return parserXML(fichierSauvegarde);
    }

    public ArrayList<ElementChargable> parserXML(File fichierSauvegarde) {
        System.out.println("Chargeur.parserXML()");

        ArrayList<ElementChargable> objets = new ArrayList<ElementChargable>();
        // Parser le fichier XML et retourner les objets
        try {
            // Charger le fichier XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fichierSauvegarde);

            // Récupérer la racine du document
            Element root = document.getDocumentElement();

            // Naviguer et extraire les données du document XML
            String rootElementName = root.getNodeName();
            System.out.println("Root Element: " + rootElementName);

            // Pour chaque asset, récupérer le nom et les coordonnées
            for (Assets.ASSETS asset : Assets.ASSETS.values()) {
                Element assetElement = (Element) root.getElementsByTagName(asset.toString().toLowerCase()).item(0);
                if (assetElement == null || asset == Assets.ASSETS.ANIMAL) continue;

                if (asset != Assets.ASSETS.LABEL) {
                    // Récupérer le nom de l'asset
                    String assetName = assetElement.getTextContent();
                    System.out.println("Asset Name: " + assetName);

                    ElementChargable elementChargable = new ElementChargable(assetName);
                    objets.add(elementChargable);
                }
                else {
                    // <label><titre>LABEL</titre><couleurNom>0x666666ff</couleurNom></label>
                    Element titreElement = (Element) assetElement.getElementsByTagName("titre").item(0);
                    Element couleurNomElement = (Element) assetElement.getElementsByTagName("couleurNom").item(0);
                    System.out.println("titreElement : " + titreElement.getTextContent() + " couleurNomElement : " + couleurNomElement.getTextContent());

                    ElementChargable elementChargable = new ElementChargable(asset.toString().toLowerCase(), -1, -1, titreElement.getTextContent(), couleurNomElement.getTextContent());
                    objets.add(elementChargable);
                }
            }

            // Pour chaque animal, récupérer le nom et les coordonnées
            NodeList animalList = root.getElementsByTagName("animal");
            for (int i = 0; i < animalList.getLength(); i++) {
                Element animal = (Element) animalList.item(i);

                // Récupérer le nom de l'animal
                String animalName = animal.getTextContent().substring(0, 7);
                System.out.println("Animal Name: " + animalName);

                // Récupérer les coordonnées de l'animal
                Element coordXElement = (Element) animal.getElementsByTagName("coordX").item(0);
                Element coordYElement = (Element) animal.getElementsByTagName("coordY").item(0);

                double coordX = Double.parseDouble(coordXElement.getTextContent());
                double coordY = Double.parseDouble(coordYElement.getTextContent());

                System.out.println("coordX: " + coordX);
                System.out.println("coordY: " + coordY);

                ElementChargable elementChargable = new ElementChargable(animalName, coordX, coordY);
                objets.add(elementChargable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objets;
    }
}
