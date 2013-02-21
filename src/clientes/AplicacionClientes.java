/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

/**
 *
 * @author theasker
 */
public class AplicacionClientes {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Solicitudes pide = new Solicitudes();
    int opcion = 0;
    do{ // Se ejecuta hasa que introducimos un 0
      try{
        opcion = Integer.parseInt(pide.menu()); // Mostramos el menu
      }catch (NumberFormatException nfe){ 
        System.err.println("Sólo valores entre 0 y 9 carácteres no");
        opcion = 10;
      }
      switch (opcion){
        case 0:
          break;
        case 1:
          
          break;
        case 2:
          
          break;
        case 3:
          
          break;
        case 4:
          
          break;
        case 5:
          
          break;
        default:
          System.out.println("Introduzca un valor entre 0 y 10");
      }
    }while(opcion != 0);
  }
}
