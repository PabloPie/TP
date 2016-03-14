import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class AgrupacionDinamica<T> implements Iterable<T>, Agrupacion<T>
{
	//Clase nodo que contiene el dato y una referencia al siguiente nodo.
	private class nodo{
        public nodo sig;
        public T dato;
        public nodo(T d){
        	sig=null;
        	dato=d;
        }
	}
	//Primer nodo apuntado.
	nodo ultimo;
	//Número total de nodos
	int total;

	//Constructor de la clase
	@SuppressWarnings("unchecked")
	public AgrupacionDinamica()
	{
		ultimo=null;
		total=0;
	}
	//Añade un el objeto 't' a la agrupación. Devuelvue siempre true.
	public boolean anyadir(T t)
	{
		nodo n=new nodo(t);
		n.sig=ultimo;
		ultimo=n;
		total++;
		return true;
	}

	//Borra el nodo apuntado por 'ultimo'. Resta 1 al total de datos.
	public boolean borrarUltimo()
	{
		boolean sePuede = total > 0;
		if (sePuede){
			ultimo=ultimo.sig;
			total--;
		}
		return sePuede;
	}
	/* Clase IteradorDin que hereda la interfaz IteradorAgrupacion. Es el iterador
		de la agrupación dinámica. */
	private class IteradorDin implements Iterator<T>, IteradorAgrupacion<T>
	{
		//Referencia a la agrupación que recorre el iterador.
		AgrupacionDinamica<T> ag;
		//Referencia al nodo actual.
		nodo n;

		//Constructor de la clase IteradorDin.
		private IteradorDin(AgrupacionDinamica<T> ag)
		{
			this.ag = ag;
			n       = ultimo;
		}

		//Devuelve false si no quedan nodos que recorrer.
		public boolean hasNext()
		{
			boolean has=true;
			if(n==null){
				has=false;
			}
			return has;
		}

		//Devuelve el dato y avanza el iterador.
		public T next() throws NoSuchElementException
		{
			T dato;
			if (!hasNext()) throw new NoSuchElementException();
			else {
				dato=n.dato;
				n=n.sig;
			}
			return dato;
		}

		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}

	//Devuelve un iterador para la agrupación dinámica
	public IteradorDin iterator()
	{
		return new IteradorDin(this);
	}
}
