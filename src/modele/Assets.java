package modele;

import javafx.geometry.Point2D;

public class Assets {
    public enum ASSETS {BACKGROUND, CAPE, ARMURE, BOTTES, CASQUE, ANIMAL} // L'ordre determine le layer

    public static Point2D getAssetPosition(ASSETS asset) {
        return switch (asset) {
            case CASQUE -> new Point2D(-1, 5);
            case ARMURE -> new Point2D(-1, 75);
            case CAPE -> new Point2D(-1, 75);
            case BOTTES -> new Point2D(-1, 250);
            default -> new Point2D(0, 0);
        };
    }

    public static double getAssetSize(ASSETS asset) {
        return switch (asset) {
            case CASQUE -> 80;
            case ARMURE -> 100;
            case CAPE -> 100;
            case BOTTES -> 80;
            default -> 0;
        };
    }
}
