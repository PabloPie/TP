import "Elemento.java";

public class Archivo extends Elemento{

  private int tamano;

  public Archivo(String nombre){
    super.setNombre(nombre);
    tamano=0;
  }

  public int getTamano(){
    return tamano;
  }

  public void setTamano(int size){
    tamano=size;
  }

  public void borrar(){
    nombre=null;
    tamano=null;
  }
}
