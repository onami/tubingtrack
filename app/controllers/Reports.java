package controllers;

import models.Bundle;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)
public class Reports extends Controller {
    @play.db.jpa.Transactional(readOnly=true)
    public static void index() {
        List<Bundle> bundles = Bundle.findAll();
        render(bundles);
    }
}
