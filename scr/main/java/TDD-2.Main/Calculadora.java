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
}
