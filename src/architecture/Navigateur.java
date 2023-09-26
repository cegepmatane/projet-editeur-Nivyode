package architecture;
import javafx.application.Application;
import com.sun.media.jfxmedia.logging.*;
import javafx.stage.Stage;


public abstract class Navigateur extends Application {

    private static Navigateur instance = null;
    protected Stage stade;

    protected Navigateur() {
        instance = this;
        Logger.setLevel(2);
        Controleur.selectionnerVuePrincipale().activerControles();
    }

    public static Navigateur getInstance() {
        return instance;
    }

    public void afficherVue(Vue vue) {
        this.stade.setScene(vue);
        this.stade.show();
        vue.activerControles();
    }
}

