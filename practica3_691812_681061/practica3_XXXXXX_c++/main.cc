#include <iostream>
#include <string>
#include "ruta.h"
#include "directorio.h"

int main(int argc, char** argv)
	Directorio raiz("");
	Ruta ruta(raiz);

	while (!end)
	{
		std::cout<<ruta.pwd()<<"> "<<std::flush;	
		try {
			std::string command, arg;
			std::cin>>command;
			String[] argv = br.readLine().split(" ");
			if (command == "pwd") {
				std::cout<<ruta.pwd()<<std::endl;
				System.out.println(ruta.pwd());
			} else if (command == "ls") {
				ruta.ls();
			} else if (command == "cd") {
				cin>>arg;
				ruta.cd(arg);
			} else if (command == "stat") {
				cin>>arg;
				ruta.stat(arg);
			} else if (command == "vim") {
				int n;
				cin>>arg>>n;
				ruta.vim(arg, n);
			} else if (command == "mkdir") {
				cin>>arg;
				ruta.mkdir(arg);
			} else if (command == "ln") {
				std::string arg2;
				cin>>arg>>arg2;
				ruta.ln(arg,arg2);
			} else if (command == "rm") {
				cin>>arg;
				ruta.rm(arg);
			} else if (command == "exit") {
				end = true;
			} else {
				System.out.println("Comando desconocido");
			}
		} catch(const ExcepcionArbolFicheros& e) {
			std::cerr<<"Excepción : "<<e<<std::endl;
		} 
	}
   }
};
