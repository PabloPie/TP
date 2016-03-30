@SuppressWarnings("serial")
public class ExcepcionExisteDir extends ExcepcionArbolFicheros{
	public String toString(){
		return "Ya existe un directorio con ese nombre. No se puede crear el archivo.";
	}
}
