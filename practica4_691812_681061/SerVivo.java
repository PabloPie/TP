public class SerVivo implements Charge{
  private double volumen;
  private String nombre;

  public SerVivo(double volumen, String nombre){
    this.volumen=volumen;
    this.nombre=nombre;
  }

  public double getVolumen(){
    return volumen;
  }
}
