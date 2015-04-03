
import java.util.HashMap;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class TabIdent {
    private HashMap<String, Ident> globaux;
    private HashMap<String, Ident> locaux;
    public int iterateurVariable = -2;
    public int iterateurParametre = 4;

    public Yaka yaka;

    public TabIdent() {
    	this.globaux = new HashMap<String, Ident>(); //ne contient que les fonctions
    	this.locaux = new HashMap<String, Ident>();
    }

    public Ident chercheIdent(String clef){
    	if(this.existeIdentGlobaux(clef)){
    		return this.globaux.get(clef);}
    	else if(this.existeIdentLocaux(clef)){
    		return this.locaux.get(clef);}
    	else{System.out.println("ERREUR: Ident doesn't exist ( all )"); return new IdConst(Constante.type.ERREUR,42);}
    }
    
    public Ident chercheIdentGlobaux(String clef) /*throws ParseException */{
    	if(this.existeIdentGlobaux(clef)){
    		return this.globaux.get(clef);}
    	System.out.println("ERREUR: Ident doesn't exist ( globaux )"+clef);
    	return new IdConst(Constante.type.ERREUR,42);
    }
    
    public Ident chercheIdentLocaux(String clef) /*throws ParseException */{
    	if(this.existeIdentLocaux(clef)){
    		return this.locaux.get(clef);}
    	System.out.println("ERREUR: Ident doesn't exist ( locaux )"+clef);
    	return new IdConst(Constante.type.ERREUR,42);
    }

    public boolean existeIdentGlobaux(String clef) {
    	return this.globaux.containsKey(clef);
    }
    
    public boolean existeIdentLocaux(String clef) {
    	return this.locaux.containsKey(clef);
    }

    public void rangeIdentGlobaux(String clef, Ident id) {
    	System.out.println(this);
    	this.globaux.put(clef, id);
    }
    
    public void rangeIdentLocaux(String clef, Ident id) {
    	System.out.println(this);
    	System.out.println(clef);
    	this.locaux.put(clef, id);
    	if(id.estVariable()){
    		this.iterateurVariable -= 2;
    	}
    	else if (id.estParametre())
    		this.iterateurParametre += 2;
    }
    
    public int getIterateurVariable(){
    	return this.iterateurVariable;
    }
    
    public int getIterateurParametre(){
    	return this.iterateurParametre;
    }
    
    public void viderLocaux(){
    	System.out.println(this);
    	this.locaux.clear();
    	this.iterateurVariable = -2;
    	this.iterateurParametre = 4;
    }
    
    public String toString(){
    	return (this.globaux.toString() + "\n" + this.locaux.toString());
    }

}
