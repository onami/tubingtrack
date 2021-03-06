package controllers;

import models.User;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 29.05.12
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
public class Security extends Secure.Security {
    static boolean authenticate(String username, String password) {
        return User.connect(username, password) != null;
    }

    static boolean check(String profile) {
        return User.find("byName", connected()).<User>first().profile.name().compareTo(profile) == 0;
    }

    static void onDisconnected() {
        Application.index();
    }
}
