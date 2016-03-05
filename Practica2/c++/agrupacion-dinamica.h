#ifndef AGRUPACIONDINAMICA_H
#define AGRUPACIONDINcd 	
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

	friend class const_iterator;
	
	//Clase iterador.
	class const_iterator : const_iterator {

	private:
		nodo *patata;
		const agrupacion_dinamica<T>& c;

	public:
		const_iterator(const agrupacion_dinamica& c_) : patata(c_.ultimo), c(c_) {  }

		const_iterator& operator++()   
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

		bool operator!=(const const_iterator& that) const 
		{ 
			bool diff=true;
			if(patata==that.patata)
			{
				diff=false;
			}
			return diff;
		}
	};

	const_iterator begin() const { return const_iterator(*this,this->ultimo); }
	const_iterator end()   const { return const_iterator(*this,NULL); }
};

#endif //fin de agrupacion.h
