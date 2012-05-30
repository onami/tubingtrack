package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 29.05.12
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)
public class Manage extends Controller {
    @Before
    static void setConnectedUser() {
        if (Security.isConnected()) {
            User user = User.find("byName", Security.connected()).first();
            renderArgs.put("user", user.name);
        }
    }

    public static void index() {
        render();
    }
}
