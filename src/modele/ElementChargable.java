package modele;

import javafx.scene.paint.Color;

public class ElementChargable {
    protected String type;
    protected double x;
    protected double y;
    protected String texte;
    protected String couleur;

    public ElementChargable(String type) {
        this.type = type;
        this.x = -1;
        this.y = -1;
    }
    public ElementChargable(String type, double x, double y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public ElementChargable(String type, double x, double y, String texte, String couleur) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.texte = texte;
        this.couleur = couleur;
    }

    public String getType() {
    	return this.type;
    }

    public double getX() {
    	return this.x;
    }

    public double getY() {
    	return this.y;
    }

    public String getTexte() {
        return this.texte;
    }

    public Color getCouleur() {
        return Color.valueOf(this.couleur);
    }
}
