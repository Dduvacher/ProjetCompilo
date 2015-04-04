import java.util.ArrayList;


public class IdFonct extends Ident implements Constante{
    
	private type resultat;
	private ArrayList<type> parametres;
	
    public IdFonct(type type, type res, ArrayList<type> param){
    	super(type);
    	this.resultat = res;
    	this.parametres = param;
    	System.out.println(res+param.toString());
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
    
    public type getResultat(){
    	return this.resultat;
    }
    
    public ArrayList<type> getParametres(){
    	return this.parametres;
    }
}
