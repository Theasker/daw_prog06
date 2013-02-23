package clientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AplicacionClientes {
  public static void main(String[] args){
    // creamos una lista para añadir clientes
    ArrayList listaDeObjetosCliente = new ArrayList();
    /* instancio la serializadora para leer y escribir 
         la lista de objetos Cliente */
    Serializadora serializar = new Serializadora();
    // instanciamos la clase de solicitudes por teclado
    Solicitudes pide = new Solicitudes();
    // comprobamos que existe el fichero para cargar los datos si es que existe
    try {
      File fich = new File("clientes.dat");
      if (fich.exists()){
        listaDeObjetosCliente = (ArrayList) serializar.leerObjeto("Clientes.dat");    
      }
    } catch (FileNotFoundException ex) {
      System.err.println("No existe el fichero");
    } catch (IOException ex) {
      System.err.println("Error en sistema de entrada/salida: "+ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.err.println("Error de clase");
    }
    
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
          Cliente cliente = new Cliente();
          try {
            // creamos un nuevo objeto cliente
            //cliente.setNif(pide.pedirNIF());
            cliente.setNombre(pide.pedirNombre());
            //cliente.setDireccion(pide.pedirDireccion());
            //cliente.setTelefono(pide.pedirTelefono());
            //cliente.setDeuda(pide.pedirDeuda());
            listaDeObjetosCliente.add(cliente);
            serializar.escribirObjeto(listaDeObjetosCliente);
          } catch (FileNotFoundException ex) {
            Logger.getLogger(AplicacionClientes.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
            Logger.getLogger(AplicacionClientes.class.getName()).log(Level.SEVERE, null, ex);
          }
          break;
        case 2:
          pide.verLista(listaDeObjetosCliente);
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
