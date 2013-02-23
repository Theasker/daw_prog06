package clientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/*  Se trata de hacer una aplicación en Java que gestione los clientes de una empresa. Esos datos, se almacenarán en un fichero serializado, denominado clientes.dat.

Los datos que se almacenarán sobre cada cliente son:

    NIF.
    Nombre.
    Teléfono.
    Dirección.
    Deuda.

Mediante un menú se podrán realizar determinadas operaciones:

    Añadir cliente. Esta opción pedirá los datos del cliente y añadirá el registro correspondiente en el fichero.
    Listar clientes. Recorrerá el fichero mostrando los clientes almacenados en el mismo.
    Buscar clientes. Pedirá al usuario el nif del cliente a buscar, y comprobará si existe en el fichero.
    Borrar cliente. Pedirá al usuario el nif del cliente a borrar, y si existe, lo borrará del fichero.
    Borrar fichero de clientes completamente. Elimina del disco el fichero clientes.dat
    Salir de la aplicación.

  */
public class AplicacionClientes {
  public static void main(String[] args){
    final String PATH = "clientes.dat";
    // creamos una lista para añadir clientes
    ArrayList listaDeObjetosCliente = new ArrayList();
    /* instancio la serializadora para leer y escribir 
         la lista de objetos Cliente */
    Serializadora serializar = new Serializadora();
    // instanciamos la clase de solicitudes por teclado
    Solicitudes pide = new Solicitudes();
    // comprobamos que existe el fichero para cargar los datos si es que existe
    try {
      File fich = new File(PATH);
      if (fich.exists()){
        listaDeObjetosCliente = (ArrayList) serializar.leerObjeto(PATH);    
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
          try {
            serializar.escribirObjeto(listaDeObjetosCliente);
          } catch (FileNotFoundException ex) {
            System.err.println("No existe el fichero");
          } catch (IOException ex) {
            System.err.println("Error de clase");
          }
          break;
        case 1:
          Cliente cliente = new Cliente();
          // creamos un nuevo objeto cliente
          cliente.setNif(pide.pedirNIF());
          cliente.setNombre(pide.pedirNombre());
          cliente.setDireccion(pide.pedirDireccion());
          cliente.setTelefono(pide.pedirTelefono());
          cliente.setDeuda(pide.pedirDeuda());
          listaDeObjetosCliente.add(cliente);
          //serializar.escribirObjeto(listaDeObjetosCliente);
          break;
        case 2:
          pide.verLista(listaDeObjetosCliente);
          break;
        case 3:
          pide.buscarNIF(listaDeObjetosCliente, pide.pedirNIF());
          break;
        case 4:
          // borramos el registro y devuelve la lista para poderla guardar
          pide.borrarNIF(listaDeObjetosCliente, pide.pedirNIF());

          //pide.borrarNIF(listaDeObjetosCliente, pide.pedirNIF());
          break;
        case 5:
          if (pide.borrarFichero(PATH)){
            listaDeObjetosCliente.removeAll(listaDeObjetosCliente);
          };
          break;
        default:
          System.out.println("Introduzca un valor entre 0 y 5");
      }
    }while(opcion != 0);
  }
}
