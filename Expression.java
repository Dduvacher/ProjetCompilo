import java.util.Stack;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Expression implements Constante{
    public Stack<Character> pileOp ;
    public Stack<type> pileType;
    private YVM yvm;
    private YVMasm yvmAsm;
    
    public Expression(YVM yvm, YVMasm yvmAsm){
    	this.yvm = yvm;
    	this.yvmAsm = yvmAsm;
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
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '-':
    			this.yvm.isub();
    			this.yvmAsm.isub();
    			
    			//on ne peut faire des soustractions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'o':
    			this.yvm.ior();
    			this.yvmAsm.ior();
    			
    			//on ne peut faire des 'OU' qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
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
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '/':
    			this.yvm.idiv();
    			this.yvmAsm.idiv();
    			
    			//on ne peut faire des divisions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'a':
    			this.yvm.iand();
    			this.yvmAsm.iand();
    			
    			//on ne peut faire des 'ET' qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
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
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '<':
    			this.yvm.iinf();
    			this.yvmAsm.iinf();    			
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 's': //>=
    			this.yvm.isupegal();
    			this.yvmAsm.isupegal();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'i': //<=
    			this.yvm.iinfegal();
    			this.yvmAsm.iinfegal();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '=':
    			this.yvm.iegal();
    			this.yvmAsm.iegal();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'd': //<>
    			this.yvm.idiff();
    			this.yvmAsm.idiff();
    			
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
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
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'n':
    			this.yvm.inot();
    			this.yvmAsm.inot();
    			
    			//on ne peut faire des 'NON' que sur un bool
    			if(x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
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
    	}
    }

}
