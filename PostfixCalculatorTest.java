import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PostfixCalculatorTest {
    private PostfixCalculator calculator;

    @Before
    public void setUp() {
        IStack<Integer> stack = new VectorStack<>();
        calculator = new PostfixCalculatorImpl(stack);
    }

    @Test
    public void testSimpleExpression() throws Exception {
        assertEquals(15, calculator.evaluate("1 2 + 4 * 3 +"));
    }

    @Test
    public void testAnotherExpression() throws Exception {
        assertEquals(30, calculator.evaluate("6 2 3 + *"));
    }

    @Test(expected = Exception.class)
    public void testDivisionByZero() throws Exception {
        calculator.evaluate("4 0 /");
    }

    @Test(expected = Exception.class)
    public void testInvalidToken() throws Exception {
        calculator.evaluate("2 a +");
    }

    @Test(expected = Exception.class)
    public void testInsufficientOperands() throws Exception {
        calculator.evaluate("2 +");
    }
}
