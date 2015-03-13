import java.util.Stack;

//import com.modeliosoft.modelio.javadesigner.annotations.objid;


public class Expression implements Constante{
    public Stack<Character> pileOp ;

    public Stack<type> pileType;

    public void OppAdd() {
    	type y = this.pileType.pop();
    	type x = this.pileType.pop(); 
    	switch(this.pileOp.pop()){
    		case '+':
    			//on ne peut faire des additions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '-':
    			//on ne peut faire des soustractions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'o':
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
    			//on ne peut faire des multiplications qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '/':
    			//on ne peut faire des divisions qu'entre deux entiers
    			if(x == y && x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'a':
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
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '<':
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 's': //>=
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'i': //<=
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case '=':
    			//on ne peut faire des comparaisons qu'entre deux bool
    			if(x == y && x == type.BOOL)
    				this.pileType.push(type.BOOL);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'd': //<>
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
    			//on ne peut faire des moins que sur un entier
    			if(x == type.ENTIER)
    				this.pileType.push(type.ENTIER);
    			else
    				this.pileType.push(type.ERREUR);
    			break;
    			
    		case 'n':
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

    public void empileType(type type) {
    	this.pileType.push(type);
    }

}
