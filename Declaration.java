//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class Declaration implements Constante {
    public String identLu;
    public String typeLu;
    public YVM yvm;
    public YVMasm asm;
    //tasoeur
    public Declaration (YVM yvm, YVMasm asm){
    	this.yvm = yvm;
    	this.asm = asm;
    }

    public void placerVariable(String nom, int val, type type, TabIdent tab) {
    	if (tab.existeIdent(nom)){
    		System.out.println("ERROR : IDENT ALREADY EXISTS");
    	} else {
    		tab.rangeIdent(nom, new IdVar(type, val));
    		yvm.istore(val);
    	}
    }

    public void placerConst(String nom, int val, type type, TabIdent tab) {
    	if (tab.existeIdent(nom)){
    		System.out.println("ERROR : IDENT ALREADY EXISTS");
    	} else {
    		tab.rangeIdent(nom, new IdConst(type, val));
    		yvm.iconst(val);
    		
    	}
    }

}
