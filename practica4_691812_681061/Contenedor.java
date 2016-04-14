public class Contenedor extends Chargeable implements Charge{
    private double volumen;

    public Contenedor(double size){
      volumen=size;
      capacidad=size;
    }

  public double getVolumen(){
    return volumen;
  }
}
