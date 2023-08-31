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
}
