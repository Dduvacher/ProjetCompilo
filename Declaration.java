//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class Declaration implements Constante {
    public String identLu;
    public type typeLu;
    public YVM yvm;
    public YVMasm asm;
    public Declaration (YVM yvm, YVMasm asm){
    	this.yvm = yvm;
    	this.asm = asm;
    }

    public void placerVariable(String nom, int val, type type, TabIdent tab) {
    	if (tab.existeIdent(nom)){
    		if(tab.chercheIdent(nom).estVariable()){
    		System.out.println("ERROR : IDENT ALREADY EXISTS");
    		}
    		else{System.out.println("ERROR : Attention vous affectez une constante.");}
    	} 
    	else {
    		tab.rangeIdent(nom, new IdVar(type, val));
    		//yvm.istore(val); asm.istore(val);
    	}
    }

    public void placerConst(String nom, int val, type type, TabIdent tab) {
    	if (tab.existeIdent(nom)){
    		System.out.println("ERROR : IDENT ALREADY EXISTS");
    	} else {
    		tab.rangeIdent(nom, new IdConst(type, val));
    		//yvm.iconst(val); asm.iconst(val);
    		
    	}
    }

}
