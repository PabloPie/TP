import "Elemento.java";

public class Enlace extends Elemento{
  private Elemento apuntado;

  public Enlace(Elemento orig, String nombre){
    apuntado=orig;
    super.setNombre(nombre);
  }
  public int getTamano(){
  return apuntado.getTamano;
  }

  public void setTamano(){
    System.out.println("No puedes modificar el tamaño de un enlace.");
  }

  public void borrar(){
    apuntado=null;
  }
}
