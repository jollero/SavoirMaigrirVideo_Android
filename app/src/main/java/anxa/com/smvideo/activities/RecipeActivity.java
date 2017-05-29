package anxa.com.smvideo.activities;

import android.content.Intent;
import android.os.Bundle;

import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.http.AsyncResponse;
import anxa.com.smvideo.contracts.VideoResponseContract;

/**
 * Created by angelaanxa on 5/29/2017.
 */

public class RecipeActivity extends BaseVideoActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);


    }
}