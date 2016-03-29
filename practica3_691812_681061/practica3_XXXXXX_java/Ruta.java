import java.util.LinkedList;
import java.util.Scanner;

public class Ruta{
  LinkedList<Directorio> path = new LinkedList<Directorio>();

  public Ruta(Directorio raiz) throws noDirException{
    if(raiz==null) throw new noDirException();
    path.add(raiz);
  }

  public String pwd(){
    String p="";
    for(Directorio d: path){
      p+="/"+d.getNombre();
    }
    return p;
  }

  public void ls(){
    path.getLast().mostrar();
    }

  public void cd(String ruta) throws noDirException{
    if(ruta.startsWith("/")){
      while(path.size()!=1)path.removeLast();
      ruta=ruta.substring(1);
    }
    Scanner s=new Scanner(ruta);
    while(s.hasNext()){
			String dir = s.next();
			if(dir.equals("..")) cdB();
			else if(dir.equals("."));
			else cdDir(dir);
		}
  }

  private void cdB() throws noDirException{
    if(path.size()>1) path.removeLast();
    else throw new noDirException();
  }

  private void cdDir(String dir) throws noDirException{
    if(path.getLast().existeEle(dir) && path.getLast().tipo().equals("Directorio"))
      path.add((Directorio)(path.getLast().getEle(dir)));
    else
      throw new noDirException();
  }

  public void stat(String element) throws noDirException{
    Elemento e;
    if (element.startsWith("/")){
        e = path.get(0);
        element = element.substring(1);
    }
    else
      e = path.get(path.size()-1);

    Scanner S = new Scanner(element);
    S.useDelimiter("/");
    while(S.hasNext()){
      String aux = S.next();
      if(e.tipo().equals("Directorio")){
  			  if(((Directorio)e).existeEle(aux)){
  						e = ((Directorio)e).getEle(aux);
  					}else throw new noExisteException();
  				}else throw new noDirException();
  		}
      System.out.println(e.getTamano());
  }

  public void vim(String file, int size){
  }

  public void mkdir(String dir){
  }

  public void ln(String orig, String dest){
  }

  public void rm(String e){
  }


}
