package anxa.com.smvideo.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import anxa.com.smvideo.ApplicationData;
import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.http.AsyncResponse;
import anxa.com.smvideo.contracts.RecipeContract;
import anxa.com.smvideo.contracts.RecipeResponseContract;
import anxa.com.smvideo.contracts.VideoResponseContract;
import anxa.com.smvideo.ui.CustomListView;
import anxa.com.smvideo.ui.RecipesListAdapter;

/**
 * Created by angelaanxa on 5/24/2017.
 */

public class RecipesActivity extends BaseVideoActivity implements View.OnClickListener {

    private CustomListView recipesListView;
    private RecipesListAdapter adapter;
    private List<RecipeContract> recipesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes);

        //header change
        ((TextView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_title_tv)).setText(getString(R.string.menu_recettes));

        //ui
        recipesListView = (CustomListView) findViewById(R.id.recipeListView);
        recipesList = new ArrayList<RecipeContract>();

        if (adapter == null) {
            adapter = new RecipesListAdapter(this, recipesList, this);
        }
        recipesListView.setAdapter(adapter);


        //api call
        caller.GetFreeRecipes(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {
                AddOnClickListener();
                if(output != null) {

                    RecipeResponseContract c = (RecipeResponseContract) output;
                    //INITIALIZE ALL ONCLICK AND API RELATED PROCESS HERE TO AVOID CRASHES

                    if (c != null && c.Data != null && c.Data.Recipes != null) {


                        int unreadCount = 0;

                        List<RecipeContract> recipesList = (List<RecipeContract>) c.Data.Recipes;
                        ApplicationData.getInstance().recipeList = recipesList;

                        List<RecipeContract> currentViewRecipeList  = recipesList;
                        for(RecipeContract r : recipesList)
                        {

                        }
                        adapter.updateItems(recipesList);

                    }
                }
            }


        });
    }

    @Override
    public void onClick(View v) {
if(v.getId() == R.id.button_entree){
    if(Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        ((Button)v.findViewById(R.id.button_entree)).setBackgroundDrawable( getResources().getDrawable(R.drawable.button_orange_roundedcorners) );
    } else {
        ((Button)v.findViewById(R.id.button_entree)).setBackground( getResources().getDrawable(R.drawable.button_orange_roundedcorners));
    }
    ((Button)findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
    ((Button)findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
    ((Button)findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
    ((Button)findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
}
        if(v.getId() == R.id.button_salad){
            if(Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ((Button)v.findViewById(R.id.button_salad)).setBackgroundDrawable( getResources().getDrawable(R.drawable.button_orange_roundedcorners) );
            } else {
                ((Button)v.findViewById(R.id.button_salad)).setBackground( getResources().getDrawable(R.drawable.button_orange_roundedcorners));
            }
            ((Button)findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
        }
        if(v.getId() == R.id.button_plat){
            if(Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ((Button)v.findViewById(R.id.button_plat)).setBackgroundDrawable( getResources().getDrawable(R.drawable.button_orange_roundedcorners) );
            } else {
                ((Button)v.findViewById(R.id.button_plat)).setBackground( getResources().getDrawable(R.drawable.button_orange_roundedcorners));
            }
            ((Button)findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
        }
        if(v.getId() == R.id.button_dessert){
            if(Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ((Button)v.findViewById(R.id.button_dessert)).setBackgroundDrawable( getResources().getDrawable(R.drawable.button_orange_roundedcorners) );
            } else {
                ((Button)v.findViewById(R.id.button_dessert)).setBackground( getResources().getDrawable(R.drawable.button_orange_roundedcorners));
            }
            ((Button)findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
        }
        if(v.getId() == R.id.button_soup){
            if(Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ((Button)v.findViewById(R.id.button_soup)).setBackgroundDrawable( getResources().getDrawable(R.drawable.button_orange_roundedcorners) );
            } else {
                ((Button)v.findViewById(R.id.button_soup)).setBackground( getResources().getDrawable(R.drawable.button_orange_roundedcorners));
            }
            ((Button)findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
        }
    }
    private void AddOnClickListener(){
        ((Button)findViewById(R.id.button_entree)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_salad)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_plat)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_dessert)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_soup)).setOnClickListener(this);
    }
}
