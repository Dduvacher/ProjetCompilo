//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class IdVar extends Ident {
    private int offset;


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
