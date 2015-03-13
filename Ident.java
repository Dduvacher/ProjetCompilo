//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public abstract class Ident implements Constante{
    private type type;

    //public TabIdent tabIdent; ???
    
    public Ident(type type){
    	this.type = type;
    }

    public abstract boolean equals(Ident id);

    public abstract boolean estVariable();
    
    public abstract int getValeur();
    
    public char getType(){
    	switch(this.type){
    	case BOOL: return 'b';
    	case ENTIER: return 'e';
    	case ERREUR: return 'r';
    	default: return 'r';
    	}
    }

}
