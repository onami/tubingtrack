package controllers;

import play.*;
import play.mvc.*;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
@Check("admin")
@With(Secure.class)
public class Users extends CRUD {
}
