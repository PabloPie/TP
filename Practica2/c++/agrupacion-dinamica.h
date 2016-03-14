#ifndef AGRUPACIONDINAMICA_H
#define AGRUPACIONDINAMICA_H
// Interfaz del TAD agrupación genérico. Pre-declaraciones:
#include <iostream>

template<typename T>
class agrupacion_dinamica{

private:
	//Clase nodo que contiene el dato y un puntero al siguiente nodo.
	class nodo {
	public:
		nodo *sig;
		T dato;

		nodo(T d){
			sig=NULL;
			dato=d;
		}
	};
	//Primer nodo apuntado.
	nodo *ultimo;
	//Número total de nodo.
	int total;

public:

	//Constructor de la clase agrupacion_dinamica.
	agrupacion_dinamica()
  {
   	ultimo=NULL;
 		total=0;
	}

	//Añade un el objeto 't' a la agrupación. Devuelvue siempre true.
	bool anyadir(const T& p)
	{

		nodo *n=new nodo(p);
		n->sig=ultimo;
		ultimo=n;
		total++;
		return true;
	}

	//Borra el nodo apuntado por 'ultimo'. Resta 1 al total de datos.
	bool borrarUltimo()
	{
		bool sePuede = total > 0;
		if (sePuede){
			nodo *aux=ultimo;
			ultimo=ultimo->sig;
			total--;
			delete aux;
		}
		return sePuede;
	}

	/* Destructor de la clae agrupacion_dinamica, recorre la lista invocando
	 	borrarUltimo() para borrar los nodos. */
	~agrupacion_dinamica()
	{
		while(borrarUltimo());
	}

	friend class iterator_din;

	/* Clase IteradorDin que hereda la interfaz IteradorAgrupacion. Es el iterador
		de la agrupación dinámica. */
	class iterator_din{

	private:
		//Puntero al nodo actual.
		nodo *patata;
		//Referencia a la agrupación que recorre el iterador.
		const agrupacion_dinamica<T>& c;

	public:
		//Constructor de la clase iterator_din.
		iterator_din(const agrupacion_dinamica& c_, nodo* npatata) : patata(npatata), c(c_) {  }

		iterator_din& operator++()
	    {
	       	if(patata!=NULL){
	       		patata=patata->sig;
	       	}
	       	return (*this);
	    }

		const T& operator*() const
		{
			return(patata->dato);
		}

		bool operator!=(const iterator_din& that) const
		{
			bool diff=true;
			if(patata==that.patata)
			{
				diff=false;
			}
			return diff;
		}
	};

	iterator_din begin() const {return iterator_din(*this,this->ultimo);}
	iterator_din end()   const {return iterator_din(*this,NULL);}
};

#endif //fin de agrupacion.h
