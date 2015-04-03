import java.util.ArrayList;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public abstract class Ident implements Constante{
    private type type;

    //public TabIdent tabIdent; ???
    
    public Ident(type type){
    	this.type = type;
    }

    public abstract boolean equals(Ident id);

    public abstract boolean estVariable();
    
    public abstract boolean estFonction();
    
    public abstract boolean estParametre();
    
    public abstract int getValeur();
    
    public ArrayList<type> getParametres(){
    	return new ArrayList<type>();
    }
    
    public type getResultat(){
    	return type.ERREUR;
    }
    
    public type getType(){
    	return this.type;
    }
    
    public char getTypeToChar(){
    	switch(this.type){
    	case BOOL: return 'b';
    	case ENTIER: return 'e';
    	case ERREUR: return 'r';
    	default: return 'r';
    	}
    }

}
