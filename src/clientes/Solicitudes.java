/*
 * Clase donde solicitaremos por teclado todo lo necesario
 */
package clientes;

import java.util.Scanner;

/**
 *
 * @author theasker
 */
public class Solicitudes {
  Scanner leer = new Scanner(System.in);
  public String menu(){
    System.out.println("Operaciones con clientes");
    System.out.println("========================");
    System.out.println("1 - Añadir clientes");
    System.out.println("2 - Listar clientes");
    System.out.println("3 - Buscar clientes");
    System.out.println("4 - Borrar clientes");
    System.out.println("5 - Borrar fichero de clientes completamente");
    System.out.println("0 - Salir de la aplicación");
    System.out.println("--------------------");
    System.out.println("  Introduce una opción:");
    String opcion = leer.next();
    return opcion;
  }
  
  public String pedirTexto(){
    try{
      
    }catch 
    
    return texto;
  }
  
  public String alta(){
    String cliente = null;
    System.out.println("Introduce nombre o razón social del cliente:");
    
    
    return cliente;
  }
  
}
