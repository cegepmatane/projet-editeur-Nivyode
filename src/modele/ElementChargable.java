package modele;

public class ElementChargable {
    protected String type;
    protected double x;
    protected double y;

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

    public String getType() {
    	return this.type;
    }

    public double getX() {
    	return this.x;
    }

    public double getY() {
    	return this.y;
    }
}
