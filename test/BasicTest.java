import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void addUsers() {
        new User("dmitry@abitech.kz", "Dmitry", "mypassword").save();

        User u = User.find("byFullname", "Dmitry").first();
        assertNotNull(u);
    }

    @Test
    public void retrieveUsers() {
        User drillMaster = User.find("byEmail", "drillmaster@localhost").first();
        User admin = User.find("byEmail", "admin@localhost").first();

        assertNotNull(admin);
        assertNotNull(drillMaster);
    }

    @Test
    public void moveTubing() {
        Tag tag = Tag.find("byEpc", "abcdef").first();
        assertNotNull(tag);
        TubingState t1 = TubingState.find("byTag", tag).first();
        assertNotNull(t1);

        assertNotNull(t1.session);

    }

}
