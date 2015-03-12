
import java.util.HashMap;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class TabIdent {
    private HashMap<String, Ident> table;

    public Yaka yaka;

    public TabIdent(int taille) {
    	this.table = new HashMap<String, Ident>(taille);
    }

    public Ident chercheIdent(String clef) {
    	return this.table.get(clef);
    }

    public boolean existeIdent(String clef) {
    	return this.table.containsKey(clef);
    }

    public void rangeIdent(String clef, Ident id) {
    	this.table.put(clef, id);
    }
    
    public String toString(){
    	return this.table.toString();
    }

}
