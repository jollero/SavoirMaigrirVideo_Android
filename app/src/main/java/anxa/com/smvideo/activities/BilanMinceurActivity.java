package anxa.com.smvideo.activities;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Arrays;

import anxa.com.smvideo.R;
import anxa.com.smvideo.util.BilanMinceurUtil;

/**
 * Created by angelaanxa on 5/24/2017.
 */

public class BilanMinceurActivity extends BaseVideoActivity implements View.OnClickListener {

    private BilanMinceurUtil mDietProfileUtil = new BilanMinceurUtil();
    private int questionIndex;
    private boolean gender;
    private int[] answers = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bilan);

        //header change
        ((TextView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_title_tv)).setText(getString(R.string.menu_bilan));

        String path1="http://ovh.belletoday.com/orange/Free/SM_Marketing/SM_Marketing04.mp4";
        Uri uri=Uri.parse(path1);
        VideoView videoDietprofile  = (VideoView) findViewById(R.id.videoViewDietProfile);
        videoDietprofile.setVideoURI(uri);
        videoDietprofile.start();

        questionIndex = 1;
        configureGenderButton();
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() instanceof Integer)
        {
            int answerTag = (int)v.getTag();
            if (answerTag >= 1 && answerTag <= 10 && questionIndex <= 10)
            {
                answers[questionIndex] = answerTag;

                Log.d("qIndex", Integer.toString(questionIndex));
                Log.d("Answers", Arrays.toString(answers));

                questionIndex += 1;
                if (questionIndex < 10)
                {
                    createButtonOptions();
                }
                else
                {
                    final ScrollView questionsScroll = (ScrollView) findViewById(R.id.sQuestionsList);
                    final LinearLayout qLayout = (LinearLayout) findViewById(R.id.lQuestionsList);
                    final RelativeLayout rPersoLayout = (RelativeLayout) findViewById(R.id.rlPersonalInfo);
                    qLayout.setVisibility(View.GONE);
                    questionsScroll.setVisibility(View.GONE);
                    rPersoLayout.setVisibility(View.VISIBLE);
                    Button btnProcess =  (Button) findViewById(R.id.btnProcess);
                    btnProcess.setOnClickListener(this);
                    //showpersonalinfo layout
                }
            }
        }
        else
        {
            String buttonTag = (String)v.getTag();
            switch (buttonTag)
            {
                case "btnProcess":
                    setContentView(R.layout.bilan_results);
                    TextView resultsText = (TextView) findViewById(R.id.resultsText);
                    resultsText.setText("Test update");
                    break;
                case "imgBtnFem":
                case "imgBtnMale":
                    if (buttonTag == "imgBtnFem") {
                        gender = false;
                    }
                    else{
                        gender = true;
                    }

                    final RelativeLayout genderLayout = (RelativeLayout) findViewById(R.id.rlGenderQuestion);
                    final LinearLayout qLayout = (LinearLayout) findViewById(R.id.lQuestionsList);
                    final ScrollView questionsScroll = (ScrollView) findViewById(R.id.sQuestionsList);
                    genderLayout.setVisibility(View.GONE);
                    questionsScroll.setVisibility(View.VISIBLE);
                    qLayout.setVisibility(View.VISIBLE);
                    createButtonOptions();
                    break;
                default:
                    break;
            }
        }
        // default method for handling onClick Events..
    }

    private void configureGenderButton() {
        ImageButton imgBtnFem =  (ImageButton) findViewById(R.id.imgBtnFem);
        ImageButton imgBtnMale =  (ImageButton) findViewById(R.id.imgBtnMale);
        imgBtnFem.setOnClickListener(this);
        imgBtnMale.setOnClickListener(this);
    }


    private void createButtonOptions() {
        final LinearLayout qLayout = (LinearLayout) findViewById(R.id.lQuestionsList);
        String question = mDietProfileUtil.getQuestion(questionIndex);
        String[] options = mDietProfileUtil.getOptions(questionIndex);

        qLayout.removeAllViews();

        TextView textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        textViewQuestion.setText(question);

        for (int i = 0; i < options.length; i++) {
            Button btn1 = new Button(this);
            btn1.setTag(Integer.valueOf(i+1));
            btn1.setText(options[i]);
            btn1.setOnClickListener(this);
            qLayout.addView(btn1);
        }
    }
}
