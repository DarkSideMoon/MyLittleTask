import com.greenowl.model.SimpleHashPass;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by acube on 20.04.2016.
 */
public class TestHashUserPassword {

    @Test
    public void TestHashPassword() {
        String password = "Shark005";
        String hexPassword = "20451aa379769606adcd998aab152b56";
        SimpleHashPass hashPass = new SimpleHashPass(password);

        Assert.assertEquals(hexPassword, hashPass.HashPass());
    }
}
