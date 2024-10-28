package bingeboxdb;

/**
 *
 * @author Armando
 */
public class BingeBoxDB {

    
    public static void main(String[] args) {
        InterfazPrincipal ventana = new InterfazPrincipal(); 
        ventana.setVisible(true); // Hacer visible la ventana
        ventana.setDefaultCloseOperation(InterfazPrincipal.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
    }
    
}
