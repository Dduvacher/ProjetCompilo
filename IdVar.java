//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class IdVar extends Ident implements Constante {
    private int offset;
    
    public IdVar(type type, int offset){
    	super(type);
    	this.offset = offset;
    }

    public boolean estVariable() {
    	return true;
    }
    
    public boolean equals(Ident id){
    	return (id.estVariable() && this.offset == id.getValeur());
    }
    
    public int getValeur(){
    	return this.offset;
    }

}
