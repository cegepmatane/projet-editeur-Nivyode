package architecture;

import java.lang.reflect.Method;

public class Controleur {

    protected static Class<?> vuePrincipale = null;

    public static void choisirVuePrincipale(Class<?> vue) {
        vuePrincipale = vue;
    }

    public static Vue selectionnerVuePrincipale() {
        try {
            Method fonction = vuePrincipale.getMethod("getInstance", (Class<?>[]) null);
            return (Vue) fonction.invoke(null, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public void initialiser() {
        selectionnerVuePrincipale().getControleur().initialiser();
    }
}
