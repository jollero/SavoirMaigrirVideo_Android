package anxa.com.smvideo.activities;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.ApiCaller;
import anxa.com.smvideo.connection.http.AsyncResponse;
import anxa.com.smvideo.contracts.VideoDataContract;
import anxa.com.smvideo.contracts.VideoResponseContract;


/**
 * Created by angelaanxa on 5/23/2017.
 */

public class DiscoverActivity extends Fragment{

    Context context;
    ApiCaller caller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.context = getActivity();
        View mView = inflater.inflate(R.layout.discover, null);
        caller = new ApiCaller();


        caller.GetFreeDiscover(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                VideoResponseContract c = (VideoResponseContract)output;
                System.out.println("VideoResponseContract: " + c.Data.Videos.toString());
                //INITIALIZE ALL ONCLICK AND API RELATED PROCESS HERE TO AVOID CRASHES
            }
        });
        return mView;
    }

}
