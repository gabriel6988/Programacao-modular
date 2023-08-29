import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class CalculatorTest{
    @Test
    public void testSum(){
        Calculator calculator = new Calculator();
        int result = calculator.sum(2, 3);
        assertEquals(5, result);
    }
}
