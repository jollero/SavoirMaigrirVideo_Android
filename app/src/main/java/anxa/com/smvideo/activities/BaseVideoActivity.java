package anxa.com.smvideo.activities;

import android.app.Activity;

import com.google.gson.Gson;

import anxa.com.smvideo.connection.ApiCaller;

/**
 * Created by angelaanxa on 5/23/2017.
 */

public class BaseVideoActivity extends Activity{
    protected ApiCaller caller;

    public BaseVideoActivity() {
        caller = new ApiCaller();
    }

    private Gson gson;
    {
        gson = new Gson();
    }
}
