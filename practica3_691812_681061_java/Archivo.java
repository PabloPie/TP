public class Archivo extends Elemento{

  private int tamano;

  public Archivo(String nombre) throws ExcepcionNombre{
    if(nombre.contains("/")) throw new ExcepcionNombre();
    this.nombre=nombre;
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
    tamano=0;
  }

  public String tipo(){
    return "Archivo";
  }
}
