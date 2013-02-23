package clientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AplicacionClientes {

  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    // instanciamos la clase de solicitudes por teclado
    Solicitudes pide = new Solicitudes();
    // comprobamos que existe el fichero
    pide.existeFile();
    
    // Se ejecuta hasa que introducimos un 0
    int opcion = 0;
    do{ 
      try{
        // Mostramos el menu
        opcion = Integer.parseInt(pide.menu());
      }catch (NumberFormatException nfe){ 
        System.err.println("Sólo valores entre 0 y 5 carácteres no");
        opcion = 10;
      }
      switch (opcion){
        case 0:
          break;
        case 1:
          pide.addCliente();
          break;
        case 2:
          pide.verLista();
          break;
        case 3:
          
          break;
        case 4:
          
          break;
        case 5:
          
          break;
        default:
          System.out.println("Introduzca un valor entre 0 y 5");
      }
    }while(opcion != 0);
  }
}
