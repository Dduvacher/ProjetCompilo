//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class IdConst extends Ident {
    private int valeur;

    public boolean estVariable() {
    	return false;
    }
    
    public boolean equals(Ident id){
    	return (!id.estVariable() && this.valeur == id.getValeur());
    }
    
    public int getValeur(){
    	return this.valeur;
    }

}
