package anxa.com.smvideo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import anxa.com.smvideo.R;


public class MainActivity extends BaseVideoActivity implements View.OnClickListener {

    private Button LandingDiscoverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LandingDiscoverButton = (Button)findViewById(R.id.LandingDiscoverButton);
        LandingDiscoverButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

            if (v.getId() == R.id.LandingDiscoverButton) {
               GoToDiscoverPage();
            }
    }
    private void GoToDiscoverPage()
    {
        Intent mainIntent;
        mainIntent = new Intent(this, DiscoverActivity.class);
        startActivity(mainIntent);

    }

}
