package anxa.com.smvideo.activities;

import android.os.Bundle;

import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.http.AsyncResponse;
import anxa.com.smvideo.contracts.VideoDataContract;
import anxa.com.smvideo.contracts.VideoResponseContract;


/**
 * Created by angelaanxa on 5/23/2017.
 */

public class DiscoverActivity extends BaseVideoActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover);

        caller.GetFreeDiscover(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                VideoResponseContract c = (VideoResponseContract)output;
            }
        });
    }
}
