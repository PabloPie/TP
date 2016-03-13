
import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class AgrupacionDinamica<T> implements Iterable<T>, Agrupacion<T>
{
	private class nodo{
        public nodo sig;
        public T dato;
        public nodo(T d){
        	sig=null;
        	dato=d;
        }
	}
	nodo ultimo;
	int total;


	@SuppressWarnings("unchecked")
	public AgrupacionDinamica()
	{
		ultimo=null;
		total=0;
	}

	public boolean anyadir(T t)
	{
		nodo n=new nodo(t);
		n.sig=ultimo;
		ultimo=n;
		total++;
		return true;
	}

	public boolean borrarUltimo()
	{
		boolean sePuede = total > 0;
		if (sePuede){
			ultimo=ultimo.sig;
			total--;
		}
		return sePuede;
	}

	//Esta clase representa a un iterador sobre la agrupación. De nuevo, por el comportamiento estándar de los
	//iteradores en Java, deberemos utilizar la herencia.
	private class IteradorAgrupacion implements Iterator<T>
	{
		//Aquí declaramos los atributos
		AgrupacionDinamica<T> ag;
		nodo n;

		//Este es el constructor del iterador.
		private IteradorAgrupacion(AgrupacionDinamica<T> ag)
		{
			this.ag = ag;
			n       = ultimo;
		}

		//Todos los iteradores deben de implementar un método que devuelva
		//si hay siguiente elemento (o no).
		public boolean hasNext()
		{
			//TODO: Devuelve si hay siguiente elemento o no.
			boolean has=true;
			if(n==null){
				has=false;
			}
			return has;
		}

		//Todos los iteradores deben de implementar un método que devuelva el elemento
		//en la posción actual y avance el iterador. Por construcción, este método debe
		//lanzar una excepción si no existe el siguiente elemento.
		//Recuerda que se recorren desde el último al primero.
		public T next() throws NoSuchElementException
		{
			T dato;
			//Aquí lanzamos la excepción
			if (!hasNext()) throw new NoSuchElementException();
			else {
				dato=n.dato;
				n=n.sig;
			}
			return dato;
		}

		//Los iteradores en Java tienen que tener este método, también. Para no implementarlo (no lo vamos
		//a usar y nuestra definición de agrupación no lo incluye) simplemente lanzamos una excepción.
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}

	//Este método de la estructura de datos simplemente devuelve un nuevo iterador con el que recorrerse la estructura de datos.
	public Iterator<T> iterator()
	{
		return new IteradorAgrupacion(this);
	}
}
