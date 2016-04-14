import java.util.ArrayList;

public abstract class Chargeable{
  double capacidad;
  private ArrayList<Charge> carga = new ArrayList<Charge>();

  public boolean guardar(Charge elemento){
    boolean guardado=false;
    if (this.capacidad >= elemento.getVolumen()){
      carga.add(elemento);
      capacidad-=elemento.getVolumen();
      guardado=true;
    }
    return guardado;
  }
}
