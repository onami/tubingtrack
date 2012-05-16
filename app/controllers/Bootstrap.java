package controllers;

import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 16.05.12
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
@OnApplicationStart
public class Bootstrap extends Job {
    public void doJob() {
        // Check if the database is empty
        if (User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
}
