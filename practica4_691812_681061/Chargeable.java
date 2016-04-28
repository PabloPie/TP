import java.util.ArrayList;

public abstract class Chargeable<T extends Charge>{
  private double capacidad;
  private ArrayList<Charge> carga;

  public Chargeable(double capacidad){
		this.capacidad=capacidad;
	}

  public boolean guardar(T elemento){
    boolean guardado=false;
    if (this.capacidad >= elemento.getVolumen()){
      carga.add(elemento);
      capacidad-=elemento.getVolumen();
      guardado=true;
    }
    return guardado;
  }
}
