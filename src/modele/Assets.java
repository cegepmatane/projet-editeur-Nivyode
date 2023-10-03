package modele;

import javafx.geometry.Point2D;

public class Assets {
    public enum ASSETS {BACKGROUND, CAPE, ARMURE, BOTTES, CASQUE, ANIMAL} // L'ordre determine le layer

    public static Point2D getAssetPosition(ASSETS asset) {
        return switch (asset) {
            case CASQUE -> new Point2D(-1, 300);
            case ARMURE -> new Point2D(-1, 350);
            case CAPE -> new Point2D(380, 350);
            case BOTTES -> new Point2D(-1, 500);
            case ANIMAL -> new Point2D(325, 500);
            case BACKGROUND -> new Point2D(0, 0);
            default -> new Point2D(0, 0);
        };
    }

    public static double getAssetSize(ASSETS asset) {
        return switch (asset) {
            case CASQUE -> 80;
            case ARMURE -> 100;
            case CAPE -> 100;
            case BOTTES -> 70;
            case ANIMAL -> 50;
            default -> 0;
        };
    }
}
