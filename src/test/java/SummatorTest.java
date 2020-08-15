import org.testng.Assert;
import org.testng.annotations.Test;

public class SummatorTest {

    @Test
    public void SumIntTest(){
        Assert.assertEquals(new Summator().Sum(1,3),4);
    }

    @Test
    public void SumStrTest(){
        Assert.assertNotEquals(new Summator().Sum("str1", "str2"), "srt1 str2");
    }

    @Test
    public void SumDoubleTest(){
        Assert.assertEquals(new Summator().Sum(0.1, 0.2), 0.3);
    }

}
