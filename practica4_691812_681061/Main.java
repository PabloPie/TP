class Main {

	public static void main(String[] args) {
		Camion camion = new Camion(10);

		Contenedor<Generico> contenedor_generico = new Contenedor<Generico>(4);
		Contenedor<Toxico>   contenedor_toxico   = new Contenedor<Toxico>(3);
		Contenedor<SerVivo>  contenedor_servivo  = new Contenedor<SerVivo>(2);
		Producto             apuntes_tepro       = new Producto(1,"Apuntes de Tecnologia de Programacion");
		if (!camion.guardar(contenedor_generico)) System.out.println("Camion lleno con contenedor generico");
		if (!camion.guardar(contenedor_toxico))   System.out.println("Camion lleno con contenedor toxicos");
		if (!camion.guardar(contenedor_servivo))  System.out.println("Camion lleno con contenedor de seres vivos");
		if (!camion.guardar(apuntes_tepro))   System.out.println("Camion lleno con apuntes de tepro");

		Producto              trenzas_almudevar  = new Producto(0.5, "Trenzas de Almudevar");
		if (!camion.guardar(trenzas_almudevar))   System.out.println("Camion lleno con trenzas de Almudevar");
		contenedor_generico.guardar(trenzas_almudevar);

		Toxico discos_melendi = new Toxico(1,"Discos de Melendi");
		// contenedor_generico.guardar(discos_melendi); //Esto no deberia compilar
		contenedor_toxico.guardar(discos_melendi);

		SerVivo elvis_presley = new SerVivo(0.1,"Elvis Presley");
		//camion.guardar(elvis_presley); //Esto no deberia compilar
		contenedor_servivo.guardar(elvis_presley);

		Contenedor<Generico> otro_contenedor_generico = new Contenedor<Generico>(1);
		Contenedor<Toxico>   otro_contenedor_toxico   = new Contenedor<Toxico>(1);
		Contenedor<SerVivo>  otro_contenedor_servivo  = new Contenedor<SerVivo>(1);
		contenedor_generico.guardar(otro_contenedor_generico);
		contenedor_generico.guardar(otro_contenedor_toxico);
		contenedor_generico.guardar(otro_contenedor_servivo);
		//contenedor_generico.guardar(camion); //Esto no deberia compilar
		//contenedor_toxico.guardar(otro_contenedor_toxico); //Esto no deberia compilar
		//contenedor_servivo.guardar(otro_contenedor_servivo); //Esto no deberia compilar



	}

}
