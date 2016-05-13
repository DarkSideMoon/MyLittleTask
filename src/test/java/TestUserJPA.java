import com.greenowl.logic.dao.impl.UserDaoImpl;
import com.greenowl.model.GmailUser;
import com.greenowl.model.SimpleHashPass;
import com.greenowl.model.User;
import org.junit.Test;

/**
 * Created by acube on 10.05.2016.
 */
public class TestUserJPA {

    @Test
    public void TestCreateUser() {
        SimpleHashPass hashPass = new SimpleHashPass();
        User user = new User();
        user.name = "PashaTest57";
        user.email = "shark005@i.ua";
        user.gmailUser = null;

        user.password = "12313TEST";
        hashPass.password = user.password;
        user.password = hashPass.HashPass();

        UserDaoImpl userDao = new UserDaoImpl();
        userDao.create(user);
    }
}
