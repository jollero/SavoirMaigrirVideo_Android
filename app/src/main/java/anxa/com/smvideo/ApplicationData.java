package anxa.com.smvideo;

import android.app.Application;

/**
 * Created by aprilanxa on 19/05/2017.
 */

public class ApplicationData extends Application {

    private static ApplicationData instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public ApplicationData() {
        super();
    }


    public static ApplicationData getInstance() {
        return instance;
    }

}
