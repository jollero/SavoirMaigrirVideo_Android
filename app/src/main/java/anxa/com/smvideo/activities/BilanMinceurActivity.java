package anxa.com.smvideo.activities;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import anxa.com.smvideo.R;

/**
 * Created by angelaanxa on 5/24/2017.
 */

public class BilanMinceurActivity extends BaseVideoActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bilan);

        //header change
        ((TextView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_title_tv)).setText(getString(R.string.menu_bilan));
    }
}
