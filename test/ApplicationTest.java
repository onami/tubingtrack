import com.google.gson.Gson;
import controllers.Services;
import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

import java.util.Calendar;
import java.util.Date;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assert(response.status == 302);
    }

    @Test
    public void testCreateBundle() {
        Gson gson = new Gson();
        Services.JSONBundle bundle = new Services.JSONBundle(1L, 1000);
        Object reqJSON = new Services.JSONBundleCreationRequest("abcdef", Calendar.getInstance().getTime(), 1, bundle);
        String body = gson.toJson(reqJSON, Services.JSONBundleCreationRequest.class);
        Response response = POST("/services/createBundle?deviceId=1", "application/json", body);
        assertIsOk(response);
        assertContentType("application/json", response);

        Services.JSONResponse respJSON = gson.fromJson(new String(response.out.toByteArray()), Services.JSONResponse.class);
        assertNotNull(respJSON);
        assertNull(respJSON.result);
        assertNull(respJSON.error);
    }
    
}
