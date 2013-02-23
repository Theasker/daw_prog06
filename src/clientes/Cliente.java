package clientes;

import java.io.Serializable;

public class Cliente implements Serializable {
  private String nif;
  private String nombre;
  private String telefono;
  private String direccion;
  private double deuda;

  public String getNif() {
    return nif;
  }
  public void setNif(String nif) {
    this.nif = nif;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  public double getDeuda() {
    return deuda;
  }
  public void setDeuda(double deuda) {
    this.deuda = deuda;
  }
}
