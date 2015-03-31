
import java.util.HashMap;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class TabIdent {
    private HashMap<String, Ident> globaux;
    private HashMap<String, Ident> locaux;
    public int iterateur=-2;
    public int pointeurLocaux = 0;

    public Yaka yaka;

    public TabIdent() {
    	this.globaux = new HashMap<String, Ident>();
    	this.locaux = new HashMap<String, Ident>();
    }

    public Ident chercheIdentGlobaux(String clef) /*throws ParseException */{
    	if(this.existeIdentGlobaux(clef)){
    		return this.globaux.get(clef);}
    	System.out.println("ERREUR: Ident doesn't exist");
    	return new IdConst(Constante.type.ERREUR,42);
    }
    
    public Ident chercheIdentLocaux(String clef) /*throws ParseException */{
    	if(this.existeIdentLocaux(clef)){
    		return this.locaux.get(clef);}
    	System.out.println("ERREUR: Ident doesn't exist");
    	return new IdConst(Constante.type.ERREUR,42);
    }

    public boolean existeIdentGlobaux(String clef) {
    	return this.globaux.containsKey(clef);
    }
    
    public boolean existeIdentLocaux(String clef) {
    	return this.locaux.containsKey(clef);
    }

    public void rangeIdentGlobaux(String clef, Ident id) {
    	this.globaux.put(clef, id);
    	if(id.estVariable()){
    		iterateur-=2;
    	}
    }
    
    public void rangeIdentLocaux(String clef, Ident id) {
    	this.locaux.put(clef, id);
    	if(id.estVariable()){
    		iterateur-=2;
    	}
    }
    
    public int getIterateur(){
    	return this.iterateur;
    }
    
    public void viderLocaux(){
    	this.locaux.clear();
    }
    
    public String toString(){
    	return (this.globaux.toString() + "\n" + this.locaux.toString());
    }

}
