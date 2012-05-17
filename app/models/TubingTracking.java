package models;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 17.05.12
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class TubingTracking {
    public static void track(User user, Location location, Reader reader, Date date, Tag[] tubing, Session.Status status) {
        Session s = new Session(user, reader, location, date, status).save();
        for (Tag t : tubing) {
            TubeState st = new TubeState(t, s);
            st.save();
        }
    }
}
