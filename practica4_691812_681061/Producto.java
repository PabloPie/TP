public class Producto implements Generico{
    private double volumen;
    private String nombre;

    public Producto(double volumen, String nombre){
      this.volumen=volumen;
      this.nombre=nombre;
    }

    public double getVolumen(){
      return volumen;
    }

}
