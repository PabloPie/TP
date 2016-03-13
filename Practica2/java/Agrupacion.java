import java.lang.Iterable;
import java.util.Iterator;

public interface Agrupacion<T> extends Iterable<T>
{
  public boolean anyadir(T t);
  public boolean borrarUltimo();
  public Iterator<T> iterator();
  public interface IteradorAgrupacion<T>{
    public boolean hasNext();
  	public T next();
    public void remove();
  }

}
