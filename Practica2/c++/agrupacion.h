#pragma once

template<typename T> class agrupacion
{
public:
	virtual bool anyadir(const T& p)=0;
	virtual bool borrarUltimo()=0;
	class const_iterator{
	public:
		const_iterator(const agrupacion& c_);
		const_iterator& operator++();
		const T& operator*();
		bool operator!=(const const_iterator& that);

	};
	virtual const_iterator begin() const=0;
	virtual const_iterator end() const=0;
};