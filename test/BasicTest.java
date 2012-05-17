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
    public void moveTubingToDrillingArea() {
        Tag tag = Tag.find("byEpc", "abcdef").first();
        assertNotNull(tag);

        User drillMaster = User.find("byEmail", "drillmaster@localhost").first();
        assertNotNull(drillMaster);

        Location drillingRoom = Location.find("byDescription", "Drilling Room").first();
        assertNotNull(drillingRoom);

        Reader reader = Reader.find("byDescription", "Drilling Master's reader").first();
        assertNotNull(reader);

        Date today = Calendar.getInstance().getTime();
        Tag[] tubing = new Tag[] { tag };

        TubingTracking.track(drillMaster, drillingRoom, reader, today, tubing, Session.Status.IN_USE);

        Session session = Session.find("byUser", drillMaster).first();
        assertNotNull(session);
    }

}
