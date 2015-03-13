//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class Declaration implements Constante {
    public String identLu;

    public String typeLu;

    public void placerVariable(String nom, int val, type type, TabIdent tab) {
    	if (tab.existeIdent(nom)){
    	
    	} else {
    		tab.rangeIdent(nom, new IdVar(type, val));
    	}
    }

    public void placerConst(String nom, String val) {
    }

}
