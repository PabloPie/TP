public abstract class Elemento{

    private String nombre;

    public String getNombre(){
      return nombre;
    }

    public void setNombre(String name){
      nombre=name;
    }

    public abstract int getTamano();

    public abstract void setTamano(int size);

    public abstract void borrar();
}
