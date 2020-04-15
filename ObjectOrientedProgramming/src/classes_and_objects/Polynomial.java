package classes_and_objects;

public class Polynomial {

	
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
    private int coef[];
    public Polynomial(){
        coef = new int[5];
        
    }
    public void addElement(int place, int element){
        if(place >= coef.length){
            restructure(place);
        }
        coef[place] = element;
    }
    private void restructure(int n){
        int temp[]= coef;
        coef = new int[n+1];
        for(int i=0; i<temp.length; i++){
            coef[i]=temp[i];
    }
    }
	public void setCoefficient(int degree, int coeff){
        if(degree>=coef.length){
            addElement(degree,coeff);
        }
        else{
            coef[degree] = coeff;
        }
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i=0;i<coef.length;i++){
            if(coef[i]!=0){
                System.out.println(coef[i]+"x^"+i+"+");
            }
        }
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
        Polynomial result = new Polynomial();
        int max;
        if(this.coef.length > p.coef.length){
            max=this.coef.length;
            p.restructure(this.coef.length);
        }else{
            max=p.coef.length;
            this.restructure(p.coef.length);
        }
        if(max>5){
            result.restructure(max);
        }
        for(int i=0;i<max;i++){
            result.coef[i] = this.coef[i] + p.coef[i];
        }
		return result;
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
			Polynomial result = new Polynomial();
        int max;
        if(this.coef.length > p.coef.length){
            max=this.coef.length;
            p.restructure(this.coef.length);
        }else{
            max=p.coef.length;
            this.restructure(p.coef.length);
        }
        // result.restructure(max);
        if(max>5){
            result.restructure(max);
        }
        for(int i=0;i<max;i++){
            result.coef[i] = this.coef[i] - p.coef[i];
        }
		return result;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
        Polynomial result = new Polynomial();
        int a=1;
        result.restructure(this.coef.length+p.coef.length);
        for(int i=0;i<this.coef.length;i++){
            for(int j=0;j<p.coef.length;j++){
                if(this.coef[i]!=0 && p.coef[j]!=0){
                    a=this.coef[i] * p.coef[j];
                    result.coef[i+j]=a;
                }
            }
        }
		return result;
	}

}
