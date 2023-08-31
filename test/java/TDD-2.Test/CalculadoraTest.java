import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class CalculadoraTest{
    @Test
    public void testSoma(){
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.soma(2, 3));
    }
    @Test
    public void testMultiplicacao(){
        Calculadora calc = new Calculadora();
        assertEquals(9, calc.multi(3, 3));
        assertEquals(0, calc.multi(3, 0));
        assertEquals(3, calc.multi(3, 1));
    }
    @Test
    public void testDivisao(){
        Calculadora calc = new Calculadora();
        assertEquals(14, calc.divi(28, 2));
        assertEquals(8, calc.divi(16, 2));
    }
    @Test
    public void testSubtração(){
        Calculadora calc = new Calculadora();
        assertEquals(11, calc.sub(22, 11));
        assertEquals(5, calc.sub(7, 2));
        assertEquals(-2, calc.sub(0, 2));
    } 
    @Test
    public void testexponenciacao(){
        Calculadora calc = new Calculadora();
        assertEquals(27, calc.exponenciacao(3, 3));
        assertEquals(1, calc.exponenciacao(3, 0));
        assertEquals(3, calc.exponenciacao(3, 1));
    }
}
