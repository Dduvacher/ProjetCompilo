
import java.util.HashMap;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class TabIdent {
    private HashMap<String, Ident> table;
    public int iterateur=-2;

    public Yaka yaka;

    public TabIdent() {
    	this.table = new HashMap<String, Ident>();
    }

    public Ident chercheIdent(String clef) /*throws ParseException */{
    	if(this.existeIdent(clef)){
    	return this.table.get(clef);}
    	System.out.println("ERREUR: Ident doesn't exist");
    	return new IdConst(Constante.type.ERREUR,42);
    }

    public boolean existeIdent(String clef) {
    	return this.table.containsKey(clef);
    }

    public void rangeIdent(String clef, Ident id) {
    	this.table.put(clef, id);
    	if(id.estVariable()){
    		iterateur-=2;
    	}
    }
    
    public int getIterateur(){
    	return this.iterateur;
    }
    
    public String toString(){
    	return this.table.toString();
    }

}
