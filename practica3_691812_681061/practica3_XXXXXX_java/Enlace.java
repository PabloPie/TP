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
      apuntado.setTamano(i);
  }

  public Elemento getApuntado(){
      if(apuntado.tipo().equals("Enlace")){
        return ((Enlace)apuntado).getApuntado();
      }else return apuntado;
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
