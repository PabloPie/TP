import java.lang.Iterable;
import java.util.Iterator;
/* Interfaces para las clases AgrupacionDInamica y AgrupacionEstatica que
  incluyen los métodos básicos de inserción y borrado además de un iterador. */
public interface Agrupacion<T> extends Iterable<T>
{
  public boolean anyadir(T t);
  public boolean borrarUltimo();
  public interface IteradorAgrupacion<T>{
    public boolean hasNext();
  	public T next();
    public void remove();
  }
  public Iterator<T> iterator();
}
