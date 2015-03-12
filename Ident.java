//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public abstract class Ident {
    private String type;

    //public TabIdent tabIdent; ???
    
    public Ident(String type){
    	this.type = type;
    }

    public abstract boolean equals(Ident id);

    public abstract boolean estVariable();
    
    public abstract int getValeur();
    
    public String getType(){
    	return this.type;
    }

}
