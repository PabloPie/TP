import java.util.LinkedList;

public class Directorio extends Elemento{
  LinkedList<Elemento> contenido = new LinkedList<Elemento>();

  public Directorio(String nombre){
    this.nombre=nombre;
  }

  public void anadirEle(Elemento e){
    contenido.add(e);
  }

  public void borrarEle(String nombre) throws noExisteException{
    for(Elemento e: contenido){
      if (e.getNombre().equals(nombre)){
        e.borrar();
        contenido.remove(e);
        return;
      }
    }
      throw new noExisteException();
  }

  public Elemento getEle(String nombre) throws noExisteException{
    for(Elemento e: contenido){
      if(e.getNombre().equals(nombre)){
        return e;
      }
    }
    throw new noExisteException();
  }

  public boolean existeEle(String nombre){

    for(Elemento e: contenido){
      if(e.getNombre().equals(nombre)) return true;
    }
    throw new noExisteException();
  }

  public int getTamano(){
    int t=0;
    for(Elemento e: contenido){
      t+=e.getTamano();
    }
    return t;
  }

  public void setTamano(int i){
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
    contenido.clear();
  }

  public String tipo(){
    return "Directorio";
  }
}
