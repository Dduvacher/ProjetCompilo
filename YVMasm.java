import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Stack;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class YVMasm extends YVM {
	
	private PrintWriter p; // objet pour écrire dans un fichier
	public Yaka yaka;
	private TabIdent tab;
	
	private int nbMess; //compte le nombre de chaine écrite, soit l'indice du mess suivant
	
	//stocke la numérotation des "faire"
    private Stack<Integer> etiquetteFaire;
    private int nbEtiquette;
    private Stack<Integer> etiquetteSi;
    private int nbEtiqSi;
	
	//contructeur qui prend en param le nom du fichier dans lequel écrire les instrucions YVM
	public YVMasm(String fileName, TabIdent tab){
		super(fileName,tab);
		try {
			this.p = new PrintWriter(new FileOutputStream(fileName));
		}catch (FileNotFoundException e) {
			System.out.println("erreur: ouverture du fichier " + fileName);
		}
		this.tab = tab;
		
		this.nbMess = 0;
		
		this.etiquetteFaire = new Stack<Integer>();
    	this.nbEtiquette = 0;
    	this.etiquetteSi = new Stack<Integer>();
    	this.nbEtiqSi = 0;
	}
	
    //entete et queue
    public void entete(){
    	p.println("; entete");
    	
    	p.println("extrn lirent:proc, ecrent:proc");
    	p.println("extrn ecrbool:proc");
    	p.println("extrn ecrch:proc, ligsuiv:proc");
    	
    	p.println(".model SMALL");
    	p.println(".586");
    	
    	p.println(".CODE");
    	p.println("debut :");
    	p.println("STARTUPCODE");
    }
    
    public void ouvrePrinc(){
    	p.println();
    	p.println("; ouvrePrinc " + (this.tab.getIterateur()+2)*-1);
    	p.println("mov bp,sp");
    	p.println("sub sp," + (this.tab.getIterateur()+2)*-1);
    }
    
    public void queue(){
    	p.println();
    	p.println("; queue");
    	p.println("nop");
    	p.println("EXITCODE");
    	p.println("end debut");
    	p.close();
    }
	
	//instructions arithmétiques
    public void iadd() {
    	p.println();
    	p.println("; iadd");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("add ax,bx");
    	p.println("push ax");
    }
    
    public void isub() {
    	p.println();
    	p.println("; isub");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("sub ax,bx");
    	p.println("push ax");
    }
    
    public void imul() {
    	p.println();
    	p.println("; imul");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("imul bx");
    	p.println("push ax");
    }
    
    public void idiv() {
    	p.println();
    	p.println("; idiv");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("mov dx,0");
    	p.println("idiv bx");
    	p.println("push ax");
    }
    
    public void inot() {
    	p.println();
    	p.println("; inot");
    	p.println("pop ax");
    	p.println("not ax");
    	p.println("push ax");
    }

    public void ineg() {
    	p.println();
    	p.println("; ineg");
    	p.println("pop ax");
    	p.println("mov bx,0");
    	p.println("sub bx,ax");
    	p.println("push bx");
    }
    
    public void ior() {
    	p.println();
    	p.println("; ior");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("or ax,bx");
    	p.println("push ax");
    }
    
    public void iand() {
    	p.println();
    	p.println("; iand");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("and ax,bx");
    	p.println("push ax");
    }
    
    //instructions de comparaisons
    public void iinf() {
    	p.println();
    	p.println("; iinf");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jge $+6");
    	p.println("push -1");
    	p.println("jmp $+4");
    	p.println("push 0");
    }
    
    public void isup() {
    	p.println();
    	p.println("; isup");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jle $+6");
    	p.println("push -1");
    	p.println("jmp $+4");
    	p.println("push 0");
    }
    
    public void iinfegal() {
    	p.println();
    	p.println("; iinfegal");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jg $+6");
    	p.println("push -1");
    	p.println("jmp $+4");
    	p.println("push 0");
    }
    
    public void isupegal() {
    	p.println();
    	p.println("; isupegal");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jl $+6");
    	p.println("push -1");
    	p.println("jmp $+4");
    	p.println("push 0");
    }
    
    public void iegal() {
    	p.println();
    	p.println("; iegal");
    	p.println("pop ax");
    	p.println("pop bx");
    	p.println("cmp ax,bx");
    	p.println("jne $+6");
    	p.println("push -1");
    	p.println("jmp $+4");
    	p.println("push 0");
    }
    
    public void idiff() {
    	p.println();
    	p.println("; idiff");
    	p.println("pop ax");
    	p.println("pop bx");
    	p.println("cmp ax,bx");
    	p.println("je $+6");
    	p.println("push -1");
    	p.println("jmp $+4");
    	p.println("push 0");
    }
    
    //instructions de stockage et de chargement
    public void iload(int i) {
    	p.println();
    	p.println("; iload" + i);
    	p.println("push word ptr[bp" + i +"]");
    }
    
    public void istore(int i) {
    	p.println();
    	p.println("; istore " + i);
    	p.println("pop ax");
    	p.println("mov word ptr[bp" + i + "],ax");
    }

    public void iconst(int i) {
    	p.println();
    	p.println("; iconst " + i);
    	p.println("push word ptr " + i);
    }
    
    //instructions de contrôle de flot
    public void ifeq(String eti) {
    	p.println();
    	p.println("; ifeq " + eti);
    	p.println("pop ax");
    	p.println("cmp ax,0");
    	p.println("je " + eti);
    }

    public void goTo(String eti) {
    	p.println();
    	p.println("; goto " + eti);
    	p.println("jmp " + eti);
    }
    
    //instructions de pile
    public void ouvrePrinc(int i) {
    	p.println();
    	p.println("; ouvrePrinc" + i);
    	p.println("mov bp,sp");
    	p.println("sub sp," + i);
    }
    
    //entrées sorties
    public void ecrireEnt(){
    	p.println();
    	p.println("; ecrireEnt");
    	p.println("call ecrent");
    }
    
    public void ecrireChaine(String s){
    	p.println();
    	p.println("; ecrireChaine " + s);
    	
    	p.println(".DATA");
    	p.println("mess" + this.nbMess + " DB " + s.substring(0, s.length()-1) + "$\"");
    	p.println(".CODE");
    	p.println("lea dx,mess" + this.nbMess);
    	p.println("push dx");
    	p.println("call ecrch");
    	
    	this.nbMess++;
    }

    public void ecrireBool(){
    	p.println();
    	p.println("; ecrireBool");
    	p.println("call ecrbool");
    }
    
	public void lireEnt(int offset){
		p.println();
		p.println("; lireEnt " + offset);
		p.println("lea dx,[bp" + offset + "]");
		p.println("push dx");
		p.println("call lirent");
	}
	
	public void aLaLigne(){
		p.println();
		p.println("; aLaLigne");
		p.println("call ligsuiv");
	}
	
	//itération
	public void tantQue(){
		this.nbEtiquette++;
		this.etiquetteFaire.push(this.nbEtiquette);
		p.println("FAIRE" + this.etiquetteFaire.peek() + ":");
	}
	
	public void faire(){
		p.println("; iffaux FAIT" + this.etiquetteFaire.peek());
		p.println("pop ax");
		p.println("cmp ax,0");
		p.println("je FAIT" + this.etiquetteFaire.peek());
	}
	
	public void fait(){
		p.println("; goto FAIRE" + this.etiquetteFaire.peek());
		p.println("jmp FAIRE" + this.etiquetteFaire.peek());
		p.println("FAIT" + this.etiquetteFaire.pop() + ":");
	}
	
	public void si(){
		this.nbEtiqSi++;
		this.etiquetteSi.push(this.nbEtiqSi);
	}
	
	public void alors(){
		p.println("; iffaux SINON" + this.etiquetteSi.peek());
		p.println("pop ax");
		p.println("cmp ax,0");
		p.println("je SINON" + this.etiquetteSi.peek());
	}
	
	public void sinon(){
		p.println(";goto FSI" + this.etiquetteSi.peek());
		p.println("jmp FSI" + this.etiquetteSi.peek());
		p.println("SINON" + this.etiquetteSi.peek() + ":");
	}
	
	public void fsi(){
		p.println("FSI" + this.etiquetteSi.pop() + ":");
	}
	
	public void ouvreBloc(int i){
		p.println("; ouvbloc " + i);
		p.println("enter " + i + ",0");
	}
	
	public void fermeBloc(int i){
		p.println("; fermebloc " + i);
		p.println("leave");
		p.println("ret " + i);
	}
	
	public void ireturn(int i){
		p.println("; ireturn " + i);
		p.println("pop ax");
		p.println("mov [bp+" + i + "],ax");
	}
	
	public void reserveRetour(){
		p.println("; reserveRetour");
		p.println("sub sp,2");
	}
	
	public void call(String n){
		p.println("; call " + n);
		p.println("call " + n);
	}
    
}
