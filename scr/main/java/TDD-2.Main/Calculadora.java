public class Calculadora{
    public int soma(int a, int b){
        return a + b;
    }
    public int multi(int a, int b){
        return a * b;
    }
    public int divi(int a, int b){
        return a / b; 
    }
    public int sub(int a, int b){
        return a - b;
    }
    public int exponenciacao(int a, int b){
        double resultDouble = Math.pow(a, b);
        int resultInt = (int) resultDouble;
        return resultInt;
    }
    public int raizQuadrada(int x){
        if(x < 0) {
            return -1;
        }
        else {
            double resultDouble = Math.sqrt(x);
            int resultInt = (int) resultDouble;
            return resultInt;
        }
    }
    
    public double logaritmo(double base, double valor) {
	return Math.log(valor) / Math.log(base); 
    }
    
}
