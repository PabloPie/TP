#pragma once

template<typename T> class agrupacion
{
public:
	virtual bool anyadir(const T& p)=0;
	virtual bool borrarUltimo()=0;
	class const_iterator{
	public:
		virtual const_iterator& operator++();
		virtual const T& operator*();
		virtual bool operator!=(const const_iterator& that);

	};
	virtual const_iterator& begin() const=0;
	virtual const_iterator& end() const=0;
};