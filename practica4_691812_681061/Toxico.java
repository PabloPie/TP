public class Toxico implements Charge{
  private double volumen;
  private String nombre;

  public Toxico(double volumen, String nombre){
    this.volumen=volumen;
    this.nombre=nombre;
  }

  public double getVolumen(){
    return volumen;
  }

}
