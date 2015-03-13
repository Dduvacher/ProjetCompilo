import java.io.PrintWriter;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class YVMasm extends YVM {
	
	private PrintWriter p; // objet pour écrire dans un fichier
	public Yaka yaka;
	
	//contructeur qui prend en param le nom du fichier dans lequel écrire les instrucions YVM
	public YVMasm(String fileName){
		super(fileName);
	}
	
    //entete et queue
    public void entete(){
    	p.println("; entete");
    	p.println(".model SMALL");
    	p.println(".586");
    	
    	p.println(".CODE");
    	p.println("debut :");
    	p.println("STARTUPCODE");
    }
    
    public void queue(){
    	p.println("; queue");
    	p.println("nop");
    	p.println("exitcode");
    	p.println("end debut");
    }
	
	//instructions arithmétiques
    public void iadd() {
    	p.println("; iadd");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("add ax,bx");
    	p.println("push ax");
    }
    
    public void isub() {
    	p.println("; isub");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("sub ax,bx");
    	p.println("push ax");
    }
    
    public void imul() {
    	p.println("; imul");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("imul bx");
    	p.println("push ax");
    }
    
    public void idiv() {
    	p.println("; idiv");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("mov dx,0");
    	p.println("idiv bx");
    	p.println("push ax");
    }
    
    public void inot() {
    	p.println("; inot");
    	p.println("pop ax");
    	p.println("not ax");
    	p.println("push ax");
    }

    public void ineg() {
    	p.println("; ineg");
    	p.println("pop ax");
    	p.println("lea ax, [ax * -1]");
    	p.println("push ax");
    }
    
    public void ior() {
    	p.println("; ior");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("or ax,bx");
    	p.println("push ax");
    }
    
    public void iand() {
    	p.println("; iand");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("and ax,bx");
    	p.println("push ax");
    }
    
    //instructions de comparaisons
    public void iinf() {
    	p.println("; iinf");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jge $+3");
    	p.println("push -1");
    	p.println("jmp $+2");
    	p.println("push 0");
    }
    
    public void isup() {
    	p.println("; isup");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jle $+3");
    	p.println("push -1");
    	p.println("jmp $+2");
    	p.println("push 0");
    }
    
    public void iinfegal() {
    	p.println("; iinfegal");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jg $+3");
    	p.println("push -1");
    	p.println("jmp $+2");
    	p.println("push 0");
    }
    
    public void isupegal() {
    	p.println("; isupegal");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jl $+3");
    	p.println("push -1");
    	p.println("jmp $+2");
    	p.println("push 0");
    }
    
    public void iegal() {
    	p.println("; iegal");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("jne $+3");
    	p.println("push -1");
    	p.println("jmp $+2");
    	p.println("push 0");
    }
    
    public void idiff() {
    	p.println("; idiff");
    	p.println("pop bx");
    	p.println("pop ax");
    	p.println("cmp ax,bx");
    	p.println("je $+3");
    	p.println("push -1");
    	p.println("jmp $+2");
    	p.println("push 0");
    }
    
    //instructions de stockage et de chargement
    public void iload(int i) {
    	p.println("; iload" + i);
    	p.println("push word ptr[bp-" + i +"]");
    }
    
    public void istore(int i) {
    	p.println("; istore " + i);
    	p.println("pop ax");
    	p.println("mov word ptr[bp+" + i + "],ax");
    }

    public void iconst(int i) {
    	p.println("; iconst " + i);
    	p.println("push " + i);
    }
    
    //instructions de contrôle de flot
    public void ifeq(String eti) {
    	p.println("; ifeq " + eti);
    	p.println("pop ax");
    	p.println("cmp ax,0");
    	p.println("je " + eti);
    }

    public void goTo(String eti) {
    	p.println("; goto " + eti);
    	p.println("jmp " + eti);
    }
    
    //instructions de pile
    public void ouvrePrinc(int i) {
    	p.println("; ouvrePrinc" + i);
    	p.println("mov bp,sp");
    	p.println("sub sp," + i);
    }
    
}
