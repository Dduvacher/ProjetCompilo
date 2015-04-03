import java.util.ArrayList;
import java.util.Stack;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class Declaration implements Constante {
    public String identLu;
    public type typeLu;
    public YVM yvm;
    public YVMasm asm;
    public ArrayList<type> paramType;
    public Stack<type> typeStack;
    public Stack<String> nomStack;
    
    public Declaration (YVM yvm, YVMasm asm){
    	this.yvm = yvm;
    	this.asm = asm;
    	paramType = new ArrayList<type>();
    	typeStack = new Stack<type>();
    	nomStack = new Stack<String>();
    }

    public void placerVariable(String nom, int val, type type, TabIdent tab) {
    	if (tab.existeIdentLocaux(nom)){
    		if(tab.chercheIdentLocaux(nom).estVariable()){
    		System.out.println("ERROR : IDENT ALREADY EXISTS");
    		}
    		else{System.out.println("ERROR : Attention vous affectez une constante.");}
    	} 
    	else {
    		tab.rangeIdentLocaux(nom, new IdVar(type, val));
    		//yvm.istore(val); asm.istore(val);
    	}
    }

    public void placerConst(String nom, int val, type type, TabIdent tab) {
    	if (tab.existeIdentLocaux(nom)){
    		System.out.println("ERROR : IDENT ALREADY EXISTS");
    	} else {
    		tab.rangeIdentLocaux(nom, new IdConst(type, val));
    		//yvm.iconst(val); asm.iconst(val);
    		
    	}
    }
    
    public void placerFonct(TabIdent tab){
    	if (tab.existeIdentGlobaux(identLu)){
    		System.out.println("ERREUR: Nom fonction déjà utilisé.");
    	}
    	else {
    		tab.rangeIdentGlobaux(identLu, new IdFonct(type.FONCTION, typeLu, paramType));
    		yvm.ouvreBloc(identLu);
    		asm.ouvreBloc(identLu);
    	}
    	
    }
    
    public void placerParam(TabIdent tab){
    	while (!typeStack.isEmpty()){
    		if(tab.existeIdentLocaux(nomStack.peek())){
    			nomStack.pop();
    			typeStack.pop();
    			System.out.println("ERREUR: Les paramètres doivent avoir des noms différents.");
    		}
    		else {
    			tab.rangeIdentLocaux(nomStack.pop(), new IdParam(typeStack.pop(), tab.getIterateurParametre()));
    		}
    	}
    }
    
    public void empileType(String s) {
    	switch(s){
    		case "BOOLEEN":
    			this.typeStack.push(type.BOOL);
    			break;
    		case "ENTIER":
    			this.typeStack.push(type.ENTIER);
    			break;
    	}
    }

}
