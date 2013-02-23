package clientes;

import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

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
      System.out.print("cliente:" + cliente.getNombre());
      System.out.print(", nif:" + cliente.getNif());
      System.out.print(", dirección:" + cliente.getDireccion());
      System.out.print(", tfno.:" + cliente.getTelefono());
      System.out.print(", deuda:" + cliente.getDeuda() + "\n");
    }
  }
  public void buscarNIF(List lista, String nif){
    ListIterator iterador;
    boolean encontrado = false;
    // creamos el iterador para movernos por la lista
    iterador = lista.listIterator();
    while(iterador.hasNext()){
      Cliente cliente = (Cliente) iterador.next();
      if (cliente.getNif().equals(nif)){
        System.out.println("Se han encontrado los datos del nif " + nif);
        System.out.print("cliente:" + cliente.getNombre());
        System.out.print(", dirección:" + cliente.getDireccion());
        System.out.print(", tfno.:" + cliente.getTelefono());
        System.out.print(", deuda:" + cliente.getDeuda() + "\n");
        encontrado = true;
      }      
    }
    if (!encontrado){
      System.out.println("No se ha encontrado el nif " + nif);
    }
  }
  public List borrarNIF(List lista, String nif){
    ListIterator iterador;
    boolean encontrado = false;
    iterador = lista.listIterator();
    while(iterador.hasNext()){
      Cliente cliente = (Cliente) iterador.next();
      if (cliente.getNif().equals(nif)){
        // visualizamos los datos antes de borrarlo
        System.out.println("Se han encontrado los datos del nif " + nif);
        System.out.print("cliente:" + cliente.getNombre());
        System.out.print(", dirección:" + cliente.getDireccion());
        System.out.print(", tfno.:" + cliente.getTelefono());
        System.out.print(", deuda:" + cliente.getDeuda() + "\n");
        //borramos el registro en el que estamos en este momento
        iterador.remove();
        System.out.println("Registro borrado.");
        encontrado = true;
      }
    }
    if (!encontrado){
      System.out.println("No se ha encontrado el nif " + nif);
    }
    // devolvemos la lista con el registro borrado para guardarla en disco
    return lista;
  }
  public boolean borrarFichero(String nombreFichero){
    String opcion = null;
    boolean borrado;
    // creamos el objeto fichero que hemos pasado como parámetro
    File fich = new File(nombreFichero);
    if (!fich.exists()){
      System.out.println("El fichero " + nombreFichero + " no existe.");
      borrado = false;
    }else{
      System.out.println("¿Desea borrar el fichero " + nombreFichero + "?(escribe \"yes\" para borrarlo)");
      opcion = leer.nextLine();
      if (opcion.equals("yes")){
        // borramos el fichero
        fich.delete();
        System.out.println("El fichero " + nombreFichero + " ha sido borrado.");
        borrado = true;
      }else{
        System.out.println("El fichero " + nombreFichero + " NO se ha borrado.");
        borrado = false;
      };
    }
    return borrado;
  }
}
