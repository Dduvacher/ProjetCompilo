
public class IdParam extends Ident implements Constante{
    
	private int offset;
	
    public IdParam(type type, int offset){
    	super(type);
    	this.offset = offset;
    }

    public boolean equals(Ident id){
    	return (id.estParametre() && this.offset == id.getValeur());
    }

    public boolean estVariable(){
    	return false;
    }
    
    public boolean estFonction() {
		return true;
	}
    
    public boolean estParametre() {
		return true;
	}
    
    public int getValeur(){
    	return this.offset;
    }
}
