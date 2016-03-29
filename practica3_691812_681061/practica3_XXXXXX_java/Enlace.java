public class Enlace extends Elemento{
  private Elemento apuntado;

  public Enlace(Elemento orig, String nombre){
    apuntado=orig;
    this.nombre=nombre;
  }

  public int getTamano(){
  return apuntado.getTamano();
  }

  public void setTamano(int i){
    System.out.println("No puedes modificar el tamaño de un enlace.");
  }

  public Elemento getApuntado(){
    if(this.tipoF().equals("Archivo")){
      if(apuntado.tipo().equals("Archivo")){

      }
      else if(apuntado.tipo().equals("Directorio")){

      }
      else{
        return ((Enlace)apuntado).getApuntado();
      }
    }
  }

  public void borrar(){
    apuntado=null;
  }

  public String tipo(){
    return "Enlace";
  }
  public String tipoF(){
    return apuntado.tipo();
  }
}
