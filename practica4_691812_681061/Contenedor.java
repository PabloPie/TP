public class Contenedor<T extends Charge> extends Chargeable<T> implements Generico{
    private double volumen;

    public Contenedor(double size){
      super(size);
      volumen=size;
      super.carga = new ArrayList<T>();
    }

  public double getVolumen(){
    return volumen;
  }
}
