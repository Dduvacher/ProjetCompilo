//import com.modeliosoft.modelio.javadesigner.annotations.objid;

public abstract class Ident {
    private String Type;

    //public TabIdent tabIdent; ???

    public abstract boolean equals(Ident id);

    public abstract boolean estVariable();
    
    public abstract int getValeur();

}
