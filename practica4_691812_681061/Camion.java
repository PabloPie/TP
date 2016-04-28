public class Camion extends Chargeable<T extends Generico>{

  public Camion(double cap){
    super(cap);
    super.carga = new ArrayList<T>();
  }
}
