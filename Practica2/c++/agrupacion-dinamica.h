#ifndef AGRUPACIONDINAMICA_H
#define AGRUPACIONDINAMICA_H	
// Interfaz del TAD agrupación genérico. Pre-declaraciones:
#include <iostream>
#include "agrupacion.h"

template<typename T>
class agrupacion_dinamica : public agrupacion<T>{
	
private: 
	//Clase nodo
	class nodo {
	public:
		nodo *sig;
		T dato;

		nodo(T d){
			sig=NULL;
			dato=d;
		}
	};
	nodo *ultimo;
	int total;

public:
	agrupacion_dinamica() 
   	{  
   		ultimo=NULL;
 		total=0;
	}

	bool anyadir(const T& p)
	{

		nodo n=nodo(p);
		n.sig=ultimo;
		ultimo=&n;
		total++;
		return true;
	}

	bool borrarUltimo()
	{
		bool sePuede = total > 0;
		if (sePuede){
			nodo *aux=ultimo;
			ultimo=ultimo->sig;
			delete(aux);
		}
		return sePuede;
	}

	~agrupacion_dinamica()
	{
		while(borrarUltimo()){}
	}

	friend class iterator_din;
	
	//Clase iterador.
	class iterator_din : public agrupacion<T>::const_iterator {

	private:
		nodo *patata;
		const agrupacion_dinamica<T>& c;

	public:
		iterator_din(const agrupacion_dinamica& c_, nodo* npatata) : patata(npatata), c(c_) {  }

		iterator_din& operator++()   
	    { 			
	       	if(patata->sig!=NULL){
	       		patata=patata->sig;
	       	}
	       	else{
	       		std::cout<<"Ultimo dato."<<std::endl;
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

	typename agrupacion<T>::const_iterator begin() const { return iterator_din(*this,this->ultimo); }
	typename agrupacion<T>::const_iterator end()   const { return iterator_din(*this,NULL); }
};

#endif //fin de agrupacion.h
