import java.lang.*;
import "Elemento.java";

public class Directorio extends Elemento{
  LinkedList<Elemento> contenido = new LinkedList<Elemento>();

  public Directorio(String nombre){
    super.setNombre(nombre);
  }

  public void anadirEle(Elemento e){
    contenido.add(e);
  }

  public void borrarEle(Elemento e){
    e.borrar();
    contenido.remove(e);
  }

  public int getTamano(){
    int t=0;
    for(Elemento e: contenido){
      t+=e.getTamano();
    }
    return t;
  }

  public void setTamano(){
    System.out.println("No puedes modificar el tamaño de un directorio.");
  }

  public void mostrar(){
    for(Elemento e: contenido){
      System.out.println(e.getNombre());
    }
  }

  public void borrar(){
    for(Elemento e: contenido){
      e.borrar();
    }
  }
}
