import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VectorStackTest {
    private IStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new VectorStack<>();
    }

    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, (int) stack.pop());
        assertEquals(10, (int) stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(5);
        assertEquals(5, (int) stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testCreal() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }
}