import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
     @Test
    public void testEqualChars(){
         assertTrue(new OffByOne().equalChars('a','b'));
         assertFalse(new OffByOne().equalChars('a','a'));
         assertTrue(new OffByOne().equalChars('b','a'));
     }
}
