#ifndef AGRUPACIONESTATICA_H
#define AGRUPACIONESTATICA_H

#include "agrupacion.h"
// Interfaz del TAD agrupación genérico. Pre-declaraciones:
const int MAX = 40; //Límite tamaño de la agrupación, en esta implementación.

template<typename T>
class agrupacion_estatica : public agrupacion<T>{
	
private: 
	//Mantenemos aqui los mismos atributos privados, ignorando aquellos que tengan que ver
	//con el iterador
	T datos[MAX];
	int total;

public:
//	Ahora la funcion iniciar de la estructura es el constructor. 
	agrupacion_estatica() 
	        //TODO: Invoca a los constructores de los miembros privados (o deja
		//que se construyan por defecto si lo consideras necesario).
		//Separados por comas (si no sabes cómo hacerlo, mira cómo está hecho
		//en la clase iterator_estat)	
		
       	{  
       		total=0;
		//Si invocas a los constructores de los miembros privados no necesitas rellenar el código del constructor.
	}

//	TODO: La funcion anyadir ahora es el metodo anyadir. Rellénalo. Para acceder a atributos
//	y métodos de la propia clase, deberás hacerlo a través del puntero this->
	bool anyadir(const T& p)
	{
		bool sePuede = total < MAX;
		if (sePuede) {
			datos[total] = p;
			total++;
		}
		return sePuede;
	}

//	TODO: La funcion borrarUltimo se transforma tambien en un metodo. Rellénalo.
	bool borrarUltimo()
	{
		bool sePuede = total > 0;
		if (sePuede) total--;
		return sePuede;
	}

	//Declarando la clase iterator_estat (iterador constante) como friend y como
	//clase local, conseguimos que pueda haber varios iteradores, cada uno de ellos
	//llevando su propio "puntero" a que parte de la estructura estamos
	friend class iterator_estat;
       
	class iterator_estat: public agrupacion<T>::const_iterator	{
	private:
		//Al separar el iterador en una clase aparte, trasladamos los miembros privados que estaban
		//en el struct a esta clase. Además, mantenemos una referencia a la agrupacion.
		int i;
		const agrupacion_estatica<T>& c;
	public:
		//Este constructor sirve como inicializador del iterador, tanto al principio como al final.
		iterator_estat(const agrupacion_estatica& c_, int i_) : i(i_), c(c_) {  }
		
	//	En la definición por defecto de los iteradores, se separa el avance del iterador
	//	a la obtención del elemento apuntado por el iterador (que en la otra implementación ocurren
	//	en la misma función.
	
		//Este método redefine el operador de pre-incremento (++x).
		//Representa el avance del iterador.
		iterator_estat& operator++()   
	       	{ 	
			//TODO: Rellena este hueco para que el iterador sobre la agrupación avance. Recuerda
			//que en nuestra definición de agrupación la estructura se recorre desde el último
			//elemento introducido hasta el primero (como si se tratara de una pila). 
	       	i--;
			return (*this);
	       	}

		//Este método redefine el operador de "apuntado" (*x)
		//Representa la obtención de lo apuntado por el iterador.
		const T& operator*()   const 
		{
			//TODO: Rellena este método para que devuelva el elemento T al que está apuntando el iterador.
			return(c.datos[i]);	
		} 


	//	En la definición por defecto de los iteradores, no existe la comprobación de si existe
	//	siguiente elemento. Por defecto las estructuras de datos devuelven iteradores al principio y al final,
	//	y para recorrer la estructura se compara el iterador que avanza con el iterador que apunta al final
	//	de la estructura.
	//
		bool operator!=(const iterator_estat& that) const 
		{ 
			bool diff=true;
			if(i==that.i)
			{
				diff=false;
			}
			return diff;
			//TODO: Rellenar este método para devuelva true si este iterador y el iterador "that" apuntan
			//a sitios diferentes, y false en caso contrario. 
		}
	};

	//Observa como nuestra agrupacion permite generar dos iteradores: uno al principio y otro al final.
	//El iterador que apunta al final de la agrupación se mantiene en este caso únicamente para hacer
	//la comprobación de que "existe siguiente".
	//Date cuenta que los valores que le pasamos como índice del iterador son para que se recorra la
	//estructura desde el último elemento (this->total - 1) hasta el primero (0).
	iterator_estat begin() const { return iterator_estat(*this,this->total - 1); }
	iterator_estat end()   const { return iterator_estat(*this,-1); }
};

#endif //fin de agrupacion_estatica.h
