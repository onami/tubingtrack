package controllers;

import com.google.gson.Gson;
import models.Bundle;
import models.BundleState;
import models.Location;
import models.Tag;
import play.mvc.Controller;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: d_shalkhakov
 * Date: 30.05.12
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public class Services extends Controller {
    public static class JSONBundle {
        public Long     districtId;
        public Integer  length;
        public JSONBundle(Long districtId, Integer length) {
            this.districtId = districtId;
            this.length = length;
        }
    }

    public static class JSONBundleCreationRequest {
        public String     tag;
        public Date       time;
        public Integer    sessionMode;
        public JSONBundle bundle;
        public JSONBundleCreationRequest(String tag, Date time, Integer sessionMode, JSONBundle bundle) {
            this.tag = tag;
            this.time = time;
            this.sessionMode = sessionMode;
            this.bundle = bundle;
        }
    }

    public static class JSONResponse {
        public Object   result;
        public String   error;
        public JSONResponse(Object result, String error) {
            this.result = result;
            this.error = error;
        }
    }

    public static void createBundle(Long deviceId) {
        Gson gson = new Gson();
        JSONBundleCreationRequest msg = gson.fromJson(params.get("body"), JSONBundleCreationRequest.class);

        Location dest = Location.findById(msg.bundle.districtId);
        Bundle b = new Bundle(dest, msg.bundle.length);
        b.tag = Tag.find("byEpc", msg.tag).first();
        b.mode = msg.sessionMode;
        b.save();

        renderJSON(new JSONResponse(null, null));
    }


}
