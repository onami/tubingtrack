package controllers;

import models.TubingState;
import play.mvc.Controller;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class Reports extends Controller {
    public static void index() {
        List<TubingState> tubing = TubingState.findAll();
        render(tubing);
    }
}