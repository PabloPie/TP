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
      p+=d.getNombre()+"/";
    }
    return p;
  }

  public void ls(){
    path.getLast().mostrar();
    }

  public void cd(String ruta) throws noDirException, noExisteException{
    if(ruta.startsWith("/")){
      while(path.size()!=1)path.removeLast();
      ruta=ruta.substring(1);
    }
    Scanner s=new Scanner(ruta);
    s.useDelimiter("/");
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

  private void cdDir(String dir) throws noDirException, noExisteException{
    Directorio d=path.getLast();
    if(d.existeEle(dir) && d.getEle(dir).tipo().equals("Directorio"))
      path.add((Directorio)(d.getEle(dir)));
    else
      throw new noDirException();
  }

  public void stat(String element) throws noDirException, noExisteException{
    Elemento e;
    if (element.startsWith("/")){
        e = path.getFirst();
        element = element.substring(1);
    }
    else
      e = path.getLast();

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
      int tamano=0;
      try{
          tamano=e.getTamano();
        }catch(StackOverflowError ex){
          System.out.println("Error, recursión infinita.");
          System.exit(1);
        }
      System.out.println("\u001B[36m"+e.tipo()+"\u001B[31m  "+
      tamano+"\u001B[0m  "+e.getNombre());
  }

  public void vim(String file, int size)
  throws ExcepcionExisteDir, noExisteException, ExcepcionExiste, ExcepcionNombre{
    Directorio d=path.getLast();
    if(d.existeEle(file)){
      Elemento e=d.getEle(file);
      if(e.tipo().equals("Archivo") || e.tipo().equals("Enlace"))
        e.setTamano(size);
      else throw new ExcepcionExisteDir();
    }else{
      Archivo a= new Archivo(file);
      a.setTamano(size);
      d.anadirEle(a);
    }
  }

  public void mkdir(String dir) throws ExcepcionExiste, ExcepcionNombre{
    Directorio d=path.getLast();
    if(d.existeEle(dir)) throw new ExcepcionExiste();
    Directorio n=new Directorio(dir);
    d.anadirEle(n);
  }

  public void ln(String orig, String dest)
  throws ExcepcionExiste, noExisteException, noDirException, ExcepcionNombre{
    Directorio des = path.getLast();
		if(des.existeEle(dest))
      throw new ExcepcionExiste();

    Elemento e;
    if (orig.startsWith("/")){
        e = path.getFirst();
        orig = orig.substring(1);
    }
    else
      e = path.getLast();

    Scanner S = new Scanner(orig);
    S.useDelimiter("/");
    while(S.hasNext()){
      String aux = S.next();
      if(e.tipo().equals("Directorio")){
    		if(((Directorio)e).existeEle(aux)){
    				e = ((Directorio)e).getEle(aux);
    		}else throw new noExisteException();
    	}else throw new noDirException();
    }

		Enlace ori = new Enlace(e,dest);
		des.anadirEle(ori);
	}


  public void rm(String ruta)
  throws noExisteException, noDirException{
    Elemento e;
    if (ruta.startsWith("/")){
        e = path.getFirst();
        ruta = ruta.substring(1);
    }
    else
      e = path.getLast();
    Directorio d=(Directorio)e;
    Scanner S = new Scanner(ruta);
    S.useDelimiter("/");
    while(S.hasNext()){
      String aux = S.next();
      if(e.tipo().equals("Directorio")){
        d=(Directorio)e;
    		if(((Directorio)e).existeEle(aux)){
    				e = ((Directorio)e).getEle(aux);
    		}else throw new noExisteException();
    	}else throw new noDirException();
    }
    d.borrarEle(e.getNombre());
  }
}
