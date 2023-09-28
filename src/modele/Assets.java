package modele;

import javafx.geometry.Point2D;

public class Assets {
    public enum ASSETS {ANIMAL, ARMURE, BOTTES, CAPE, CASQUE, BACKGROUND, TEXT}

    public static Point2D getAssetPosition(ASSETS asset) {
        return switch (asset) {
            case CASQUE -> new Point2D(-1, 5);
            case ARMURE -> new Point2D(-1, 75);
            case CAPE -> new Point2D(-1, 75);
            case BOTTES -> new Point2D(-1, 250);
            case ANIMAL -> new Point2D(50, 270);
            case TEXT -> new Point2D(-1, 270);
            case BACKGROUND -> new Point2D(0, 0);
        };
    }

    public static double getAssetSize(ASSETS asset) {
        return switch (asset) {
            case CASQUE -> 80;
            case ARMURE -> 100;
            case CAPE -> 100;
            case BOTTES -> 80;
            case ANIMAL -> 50;
            case BACKGROUND -> 312;
            default -> 0;
        };
    }
}
