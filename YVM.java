import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Stack;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class YVM {
    private PrintWriter p; // objet pour écrire dans un fichier
    public Yaka yaka;
    private TabIdent tab;
    //stocke la numérotation des "faire"
    private Stack<Integer> etiquetteFaire;
    private int nbEtiquette;
    private Stack<Integer> etiquetteSi;
    private int nbEtiqSi;
    
    //contructeur qui prend en param le nom du fichier dans lequel écrire les instrucions YVM
    public YVM(String fileName, TabIdent tab){
    	try {
			this.p = new PrintWriter(new FileOutputStream(fileName));
		}catch (FileNotFoundException e) {
			System.out.println("erreur: ouverture du fichier " + fileName);
		}
    	this.tab = tab;
    	
    	this.etiquetteFaire = new Stack<Integer>();
    	this.nbEtiquette = 0;
    }
    
    //entete et queue
    public void entete(){
    	p.println("entete");
    }
    
    public void ouvrePrinc(){
    	p.println("ouvrePrinc " + (this.tab.getIterateur()+2)*-1);
    }
    
    public void queue(){
    	p.println("queue");
    	p.close();
    }
    
    //instructions arithmétiques
    public void iadd() {
    	p.println("iadd");
    }
    
    public void isub() {
    	p.println("isub");
    }
    
    public void imul() {
    	p.println("imul");
    }
    
    public void idiv() {
    	p.println("idiv");
    }
    
    public void inot() {
    	p.println("inot");
    }

    public void ineg() {
    	p.println("ineg");
    }
    
    public void ior() {
    	p.println("ior");
    }
    
    public void iand() {
    	p.println("iand");
    }
    
    //instructions de comparaisons
    public void iinf() {
    	p.println("iinf");
    }
    
    public void isup() {
    	p.println("isup");
    }
    
    public void iinfegal() {
    	p.println("iinfegal");
    }
    
    public void isupegal() {
    	p.println("isupegal");
    }
    
    public void iegal() {
    	p.println("iegal");
    }
    
    public void idiff() {
    	p.println("idiff");
    }
    
    //instructions de stockage et de chargement
    public void iload(int i) {
    	p.println("iload" + i);
    }
    public void istore(int i) {
    	p.println("istore " + i);
    }

    public void iconst(int i) {
    	p.println("iconst " + i);
    }
    
    //instructions de contrôle de flot
    public void ifeq(String eti) {
    	p.println("ifeq " + eti);
    }

    public void goTo(String eti) {
    	p.println("goto " + eti);
    }
    
    //instructions de pile
    public void ouvrePrinc(int i) {
    	p.println("ouvrePrinc" + i);
    }
    
    //entrées sorties
    public void ecrireEnt(){
    	p.println("ecrireEnt");
    }
    
    public void ecrireChaine(String s){
    	p.println("ecrireChaine " + s);
    }

    public void ecrireBool(){
    	p.println("ecrireBool");
    }
    
	public void lireEnt(int offset){
		p.println("lireEnt " + offset);
	}
	
	public void aLaLigne(){
		p.println("aLaLigne");
	}
	
	//itération
	public void tantQue(){
		this.nbEtiquette++;
		this.etiquetteFaire.push(this.nbEtiquette);
		p.println("FAIRE" + this.etiquetteFaire.peek() + ":");
	}
	
	public void faire(){
		p.println("iffaux FAIT" + this.etiquetteFaire.peek());
	}
	
	public void fait(){
		p.println("goto FAIRE" + this.etiquetteFaire.peek());
		p.println("FAIT" + this.etiquetteFaire.pop() + ":");
	}
	
	public void si(){
		this.nbEtiqSi++;
		this.etiquetteSi.push(this.nbEtiqSi);
		p.println("iffaux SINON" + this.etiquetteSi.peek());
	}
	
	public void sinon(){
		p.println("SINON" + this.etiquetteSi.peek() + ":");
	}
	
	public void fsi(){
		p.println("FSI" + this.etiquetteSi.pop() + ":");
	}
	
	public void alors(){
		
	}

}
