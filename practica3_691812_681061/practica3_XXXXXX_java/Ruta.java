import "Archivo.java";
import "Enlace.java";
import "Directorio.java";
import java.lang.*;

public class Ruta{
  LinkedList<Directorio> contenido = new LinkedList<Directorio>();

  public Ruta(Directorio raiz){
    contenido.add(raiz);
  }

  public String pwd(){
    String p;
    for(Directorio d: contenido){
      p+="/d.getNombre()";
    }
    return p;
  }

  public void ls(){
    contenido.getLast().mostrar();      
    }
  }

  public void cd(String path){
  }

  public void stat(String element){
  }

  public void vim(String file, int size){
  }

  public void mkdir(String dir){
  }

  public void ln(String orig, String dest){
  }

  public void rm(String e){
  }


}
