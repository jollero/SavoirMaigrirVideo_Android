package anxa.com.smvideo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import anxa.com.smvideo.ApplicationData;
import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.http.AsyncResponse;
import anxa.com.smvideo.contracts.VideoContract;
import anxa.com.smvideo.contracts.VideoResponseContract;
import anxa.com.smvideo.ui.CustomListView;
import anxa.com.smvideo.ui.VideoListAdapter;
import anxa.com.smvideo.util.VideoHelper;

/**
 * Created by angelaanxa on 5/24/2017.
 */

public class TemoignagesActivity extends BaseVideoActivity implements View.OnClickListener {
    private CustomListView customListView;
    private VideoListAdapter adapter;
    private List<VideoContract> videosList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temoignages);

        //header change
        ((TextView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_title_tv)).setText(getString(R.string.menu_temoignages));

        //ui
        customListView = (CustomListView) findViewById(R.id.testimonialListView);
        videosList = new ArrayList<VideoContract>();

        if (adapter == null) {
            adapter = new VideoListAdapter(this, videosList, this);
        }
        customListView.setAdapter(adapter);
        caller.GetFreeTestimonials(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                //INITIALIZE ALL ONCLICK AND API RELATED PROCESS HERE TO AVOID CRASHES
                if(output != null) {

                    VideoResponseContract c = (VideoResponseContract)output;


                    if (c != null && c.Data != null && c.Data.Videos != null) {
                        videosList = (List<VideoContract>) c.Data.Videos;
                        ApplicationData.getInstance().testimonialVideoList = videosList;
                        VideoHelper.sort("index", videosList);
                        adapter.updateItems(videosList);

                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
