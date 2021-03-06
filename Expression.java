import java.util.ArrayList;
import java.util.Stack;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Expression implements Constante{
    public Stack<Character> pileOp ;
    public Stack<type> pileType;
    private YVM yvm;
    private YVMasm yvmAsm;
    public String idLu;
    public Stack<String> nomFonctions;
    
    public Expression(YVM yvm, YVMasm yvmAsm){
    	this.yvm = yvm;
    	this.yvmAsm = yvmAsm;
    	this.pileOp = new Stack<Character>();
    	this.pileType = new Stack<type>();
    	this.nomFonctions= new Stack<String>();
    }
    
    public void entete(){
    	this.yvm.entete();
    	this.yvmAsm.entete();
    }
    
    public void queue(){
    	this.yvm.queue();
    	this.yvmAsm.queue();
    }
    
    public void OppAdd() {
    	type y = this.pileType.pop();
    	type x = this.pileType.pop(); 
    	switch(this.pileOp.pop()){
    		case '+':
    			this.yvm.iadd();
    			this.yvmAsm.iadd();
    			
    			//on ne peut faire des additions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case '-':
    			this.yvm.isub();
    			this.yvmAsm.isub();
    			
    			//on ne peut faire des soustractions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case 'o':
    			this.yvm.ior();
    			this.yvmAsm.ior();
    			
    			//on ne peut faire des 'OU' qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    	}
    }

    public void OppMul() {
    	type y = this.pileType.pop();
    	type x = this.pileType.pop(); 
    	switch(this.pileOp.pop()){
    		case '*':
    			this.yvm.imul();
    			this.yvmAsm.imul();
    			
    			//on ne peut faire des multiplications qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case '/':
    			this.yvm.idiv();
    			this.yvmAsm.idiv();
    			
    			//on ne peut faire des divisions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case 'a':
    			this.yvm.iand();
    			this.yvmAsm.iand();
    			
    			//on ne peut faire des 'ET' qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    	}
    }

    public void OppRel() {
    	type y = this.pileType.pop();
    	type x = this.pileType.pop(); 
    	switch(this.pileOp.pop()){
    		case '>':
    			this.yvm.isup();
    			this.yvmAsm.isup();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case '<':
    			this.yvm.iinf();
    			this.yvmAsm.iinf();    			
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case 's': //>=
    			this.yvm.isupegal();
    			this.yvmAsm.isupegal();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case 'i': //<=
    			this.yvm.iinfegal();
    			this.yvmAsm.iinfegal();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case '=':
    			this.yvm.iegal();
    			this.yvmAsm.iegal();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.BOOL);
    			else if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case 'd': //<>
    			this.yvm.idiff();
    			this.yvmAsm.idiff();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else if(x == y && x == type.ENTIER)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    	}
    }

    public void OppNeg() {
    	type x = this.pileType.pop(); 
    	switch(this.pileOp.pop()){
    		case '-':
    			this.yvm.ineg();
    			this.yvmAsm.ineg();
    			
    			//on ne peut faire des moins que sur un entier
    			if(x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    			
    		case 'n':
    			this.yvm.inot();
    			this.yvmAsm.inot();
    			
    			//on ne peut faire des 'NON' que sur un bool
    			if(x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else{
    				this.pileType.push(type.ERREUR);
    				System.out.println("ERREUR : TYPES INCOMPATIBLES");
    				}
    			break;
    	}
    }

    public void empileOp(char op) {
    	this.pileOp.push(op);
    }

    public void empileType(char t) {
    	switch(t){
    		case 'b':
    			this.pileType.push(type.BOOL);
    			break;
    		case 'e':
    			this.pileType.push(type.ENTIER);
    			break;
    		case 'r':
    			this.pileType.push(type.ERREUR);
    			break;
    		case 'f':
    			this.pileType.push(type.FONCTION);
    			break;
    		case 'p':
    			this.pileType.push(type.PARAMETRE);
    			break;
    	}
    }
    	
    public void ecrireIdent(Ident t){
    	// si l'ident n'est pas dans la table
    	if(t == null)
    		System.out.println("ERREUR : utilisation d'un ident non déclaré");
    	else{
    		if(t.estVariable() || t.estParametre()){
    			this.yvm.iload(t.getValeur());
    			this.yvmAsm.iload(t.getValeur());
    		}
    		else if(!t.estFonction()){
    			this.yvm.iconst(t.getValeur());
    			this.yvmAsm.iconst(t.getValeur());
    		}
    	}
    }
    
    public void ecrireEntier(int t){
    	this.yvm.iconst(t);
    	this.yvmAsm.iconst(t);
    }

    public void ecrireBool(bool t){
    	if(t == bool.VRAI){
    		this.yvm.iconst(-1);
    	    this.yvmAsm.iconst(-1);
    	}
    	else {
    		this.yvm.iconst(0);
    	    this.yvmAsm.iconst(0);
    	}
    }
    
    public void ecrire(){
    	if(pileType.size()==0){
    		System.out.println("ERREUR : Pile vide");
    		this.pileType.push(type.ERREUR);
    	}
    	else if (pileType.peek() == type.ENTIER){
    		pileType.pop();
    		this.yvm.ecrireEnt();
    		this.yvmAsm.ecrireEnt();
    	}
    	else if (pileType.peek() == type.BOOL){
    		pileType.pop();
    		this.yvm.ecrireBool();
    		this.yvmAsm.ecrireBool();
    	}
    	else if (pileType.peek() == type.ERREUR){
    		pileType.pop();
    		System.out.println("ERREUR ! ERREUR ! ERREUR !");
    		this.pileType.push(type.ERREUR);
    	}
    	else {
    		System.out.println("Valeur en sommet de pile: "+pileType.pop());
    		System.out.println("ERREUR : La valeur en sommet de pile n'est pas d'un type reconnu.");
    		this.pileType.push(type.ERREUR);
    	}
    }
    
    public void ecrire(String s){
    	this.yvm.ecrireChaine(s);
    	this.yvmAsm.ecrireChaine(s);
    }
    
    public void lire(Ident id){
    	this.yvm.lireEnt(id.getValeur());
    	this.yvmAsm.lireEnt(id.getValeur());
    }
    
    public void aLaLigne(){
    	this.yvm.aLaLigne();
    	this.yvmAsm.aLaLigne();
    }
    
    
    public void ouvreBloc(){
		yvm.ouvreBloc();
		yvmAsm.ouvreBloc();
    }
    
    public void ecrireMain(){
    	yvm.ecrireMain();
    	yvmAsm.ecrireMain();
    }
    
    public void affecter(Ident id){
    	if (id.estConstante()){
    		System.out.println("ERREUR : On ne peut pas modifier une constante.");
    	}
    	else if (pileType.peek() == id.getType()){
    		System.out.println(id.getType());
    		yvm.istore(id.getValeur());
    		yvmAsm.istore(id.getValeur());
    	}
    	else {
    		System.out.println("ERREUR : La valeur en sommet de pile n'est pas d'un type compatible avec le type de l'IDENT donn�.");
    	}
    }
    
    //itération
    
    public void tantQue(){
    	this.yvm.tantQue();
    	this.yvmAsm.tantQue();
    }
    
    public void faire(){
    	if(this.pileType.peek() == type.BOOL){
    		this.yvm.faire();
    		this.yvmAsm.faire();
    	}
    	else
    		System.out.println("ERREUR : L'expression suivant un \"tant que\" doit être une expression booléenne");
    }
    
    public void fait(){
    	this.yvm.fait();
    	this.yvmAsm.fait();
    }
    
    //conditionnelle
    
    public void si(){
    	this.yvm.si();
    	this.yvmAsm.si();
    }
    
    public void alors(){
    	if(this.pileType.peek() == type.BOOL){
    		this.yvm.alors();
    		this.yvmAsm.alors();
    	}
    	else
    		System.out.println("ERREUR : L'expression suivant un \"si\" doit être une expression booléenne");
    }
    
    public void sinon(){
    	this.yvm.sinon();
    	this.yvmAsm.sinon();
    }
    
    public void fsi(){
    	this.yvm.fsi();
    	this.yvmAsm.fsi();
    }
    
    public void fermeBloc(TabIdent t){
    	yvm.fermeBloc();
    	yvmAsm.fermeBloc();
    	t.viderLocaux();
    }
    
    public void call(TabIdent tab, String n){
    	System.out.println(pileType);
    	if (!tab.existeIdentGlobaux(n)){
    		System.out.println("ERREUR: La fonction n'existe pas."+n);
    	}
    	else {
    		ArrayList<type> parametres = tab.chercheIdentGlobaux(n).getParametres();
    		int nbParam = parametres.size(); /*changement ici voir si c bon*/
    		boolean erreur = false;
    		for (int i = nbParam-1; i >= 0; i--){
    			System.out.println(pileType.peek());
    			if (pileType.peek() != parametres.get(i)){
    				pileType.pop();
    				System.out.println("ERREUR: Le param�tre n�" + i + " donn� n'a pas le bon type.");
    				erreur = true;
    			}
    		}
    		if (erreur){
    			pileType.push(type.ERREUR);
    		}
    		else {
        		pileType.push(tab.chercheIdentGlobaux(n).getResultat());
        		System.out.println(tab.chercheIdentGlobaux(n).getResultat()+n);
        		yvm.call(n);
            	yvmAsm.call(n);
    		}
    	}
    }
    
    public void reserveRetour(){
    	yvm.reserveRetour();
    	yvmAsm.reserveRetour();
    }
    
    public void ireturn (TabIdent tab){
    	yvm.ireturn(tab.getIterateurParametre());
    	yvmAsm.ireturn(tab.getIterateurParametre());
    }
    
}
