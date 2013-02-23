package clientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

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
    String opcion = leer.nextLine();
    return opcion;
  }
  public void addCliente() throws FileNotFoundException, IOException{    
    
    
    
  }  
  public String pedirNIF(){
    String nif;
    do{
      System.out.println("Introduce el NIF/DNI (9 caracteres):");
      nif = leer.nextLine();
      if (nif.length() < 8 || nif.length() > 9){
        System.out.println("NIF/DNI no tiene la longitud necesaria (9 caracteres)");
        nif = null;
      }
    }while(nif == null);
    return nif;
  }
  public String pedirNombre(){
    String nombre;
    do{
      System.out.println("Introduce el nombre del cliente (5-50):");
      nombre = leer.nextLine();
      if (nombre.length() < 5 || nombre.length() > 50){
        System.out.println("La longitud del nombre no es correcta (5-50)");
        nombre = null;
      }
    }while (nombre == null);
    return nombre;
  }
  public String pedirDireccion(){
    String direccion = null;
    do{
      System.out.println("Introduce la dirección (10-100):");
      direccion = leer.nextLine();
      if (direccion.length() < 10 || direccion.length() > 100){
        System.out.println("La longitud de la dirección no es correcta (10-100)");
        direccion = null;
      }
    }while (direccion == null);
    return direccion;
  }
  public String pedirTelefono(){
    String numero = null;
    do{
      System.out.println("Introduce un número de telefono (9 digitos):");
      numero = leer.nextLine();
      try{
        if (numero.length() != 9){
          System.out.println("El número no tiene tamaño 9");
          numero = null;
        }else{ // tiene tamaño 9
          Integer.parseInt(numero);
        }
      }catch (NumberFormatException nfe){
        System.out.println("Lo que has introducido no son dígitos");
        numero = null;
      }
    }while(numero == null);
    return numero;
  }
  public double pedirDeuda(){
    String numero;
    do{
      System.out.println("Introduce una cantidad:");
      numero = leer.nextLine();
      try{
        Double.parseDouble(numero);
      }catch (NumberFormatException nfe){
        System.out.println("No es una cantidad correcta");
        numero = null;
      }
    }while (numero == null);
    
    return Double.parseDouble(numero);
  }
  
  public void verLista(List lista){
    ListIterator iterador;
    iterador = lista.listIterator();
    while(iterador.hasNext()){
      Cliente cliente = (Cliente) iterador.next();
      System.out.println(cliente.getNombre());
    }
  }
}
