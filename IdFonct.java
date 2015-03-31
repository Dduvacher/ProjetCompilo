import java.util.ArrayList;


public class IdFonct extends Ident implements Constante{
    
	private IdVar resultat;
	private ArrayList<IdParam> parametres;
	
    public IdFonct(type type, IdVar res, ArrayList<IdParam> param){
    	super(type);
    	this.resultat = res;
    	this.parametres = param;
    }

    public boolean equals(Ident id){
    	return id.estFonction();
    }

    public boolean estVariable(){
    	return false;
    }
    
    public boolean estFonction() {
		return true;
	}
    
    public boolean estParametre() {
		return false;
	}
    
    public int getValeur(){
    	return 0; //valeur bidon
    }
    
    public IdVar getResultat(){
    	return this.resultat;
    }
    
    public ArrayList<IdParam> getParametres(){
    	return this.parametres;
    }
}
