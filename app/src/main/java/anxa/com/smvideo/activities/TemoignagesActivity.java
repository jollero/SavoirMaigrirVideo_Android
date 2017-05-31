package anxa.com.smvideo.activities;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.ApiCaller;
import anxa.com.smvideo.connection.http.AsyncResponse;
import anxa.com.smvideo.contracts.VideoResponseContract;

/**
 * Created by angelaanxa on 5/24/2017.
 */

public class TemoignagesActivity extends Fragment {

    private Context context;
    protected ApiCaller caller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.context = getActivity();

        View mView = inflater.inflate(R.layout.temoignages, null);
        caller = new ApiCaller();


        //header change
        ((TextView) ((RelativeLayout) mView.findViewById(R.id.headermenu)).findViewById(R.id.header_title_tv)).setText(getString(R.string.menu_temoignages));

        caller.GetFreeTestimonials(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                VideoResponseContract c = (VideoResponseContract) output;
                //INITIALIZE ALL ONCLICK AND API RELATED PROCESS HERE TO AVOID CRASHES
            }
        });

        return mView;
    }
}
