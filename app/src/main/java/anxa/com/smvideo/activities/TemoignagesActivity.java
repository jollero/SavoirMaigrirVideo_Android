package anxa.com.smvideo.activities;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.http.AsyncResponse;
import anxa.com.smvideo.contracts.VideoResponseContract;

/**
 * Created by angelaanxa on 5/24/2017.
 */

public class TemoignagesActivity extends BaseVideoActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temoignages);

        //header change
        ((TextView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_title_tv)).setText(getString(R.string.menu_temoignages));

        caller.GetFreeTestimonials(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                VideoResponseContract c = (VideoResponseContract)output;
                //INITIALIZE ALL ONCLICK AND API RELATED PROCESS HERE TO AVOID CRASHES
            }
        });
    }
}
