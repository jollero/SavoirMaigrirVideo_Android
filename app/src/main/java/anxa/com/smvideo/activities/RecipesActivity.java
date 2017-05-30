package anxa.com.smvideo.activities;

import android.content.Intent;
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

        if( ApplicationData.getInstance().recipeList != null &&  ApplicationData.getInstance().recipeList.size() > 0)
        {
            AddOnClickListener();
            recipesList = ApplicationData.getInstance().recipeList ;
            List<RecipeContract> currentViewRecipeList  = new ArrayList<>();
            for(RecipeContract r : recipesList)
            {
                if(r.RecipeType == RecipeContract.RecipeTypeEnum.Entree.getNumVal())
                {
                    currentViewRecipeList.add(r);
                }
            }
            adapter.updateItems(currentViewRecipeList);
        }
        else
        {
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

                            recipesList = (List<RecipeContract>) c.Data.Recipes;
                            ApplicationData.getInstance().recipeList = recipesList;

                            List<RecipeContract> currentViewRecipeList  = new ArrayList<RecipeContract>();
                            for(RecipeContract r : recipesList)
                            {
                                if(r.RecipeType == RecipeContract.RecipeTypeEnum.Entree.getNumVal())
                                {
                                    currentViewRecipeList.add(r);
                                }
                            }
                            adapter.updateItems(currentViewRecipeList);

                        }
                    }
                }


            });
        }

    }

    @Override
    public void onClick(View v) {
        List<RecipeContract> currentViewRecipeList  = new ArrayList<>();

        RecipeContract.RecipeTypeEnum recipeCategoryToSearch = RecipeContract.RecipeTypeEnum.Entree;

        if(v.getId() == R.id.button_entree || v.getId() == R.id.button_salad  || v.getId() == R.id.button_plat  || v.getId() == R.id.button_dessert  || v.getId() == R.id.button_soup ) {
            recipesListView.setAdapter(null);
            recipesListView.setAdapter(adapter);
            if(Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ((Button)v.findViewById(v.getId())).setBackgroundDrawable( getResources().getDrawable(R.drawable.button_orange_roundedcorners) );
            } else {
                ((Button)v.findViewById(v.getId())).setBackground( getResources().getDrawable(R.drawable.button_orange_roundedcorners));
            }
            if(v.getId() == R.id.button_entree){
              UpdateCategoryButtons(RecipeContract.RecipeTypeEnum.Entree);
                recipeCategoryToSearch = RecipeContract.RecipeTypeEnum.Entree;
            }
            if(v.getId() == R.id.button_salad){
                UpdateCategoryButtons(RecipeContract.RecipeTypeEnum.Salad);
                recipeCategoryToSearch = RecipeContract.RecipeTypeEnum.Salad;
            }
            if(v.getId() == R.id.button_plat){
                UpdateCategoryButtons(RecipeContract.RecipeTypeEnum.Plat);
                recipeCategoryToSearch = RecipeContract.RecipeTypeEnum.Plat;
            }
            if(v.getId() == R.id.button_dessert){
                UpdateCategoryButtons(RecipeContract.RecipeTypeEnum.Dessert);
               recipeCategoryToSearch = RecipeContract.RecipeTypeEnum.Dessert;
            }
            if(v.getId() == R.id.button_soup){

               UpdateCategoryButtons(RecipeContract.RecipeTypeEnum.Soup);
                recipeCategoryToSearch = RecipeContract.RecipeTypeEnum.Soup;
            }
            for(RecipeContract r : recipesList)
            {
                if(r.RecipeType == recipeCategoryToSearch.getNumVal())
                {
                    currentViewRecipeList.add(r);
                }
            }
            adapter.updateItems(currentViewRecipeList);
        }
        else{
            int recipeId  = (Integer) v.getTag(R.id.recipe_id);
            Intent mainIntent;
            mainIntent = new Intent(this, RecipeActivity.class);
            mainIntent.putExtra("RECIPE_ID", recipeId);
            startActivity(mainIntent);
        }

        }


    private void AddOnClickListener(){
        ((Button)findViewById(R.id.button_entree)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_salad)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_plat)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_dessert)).setOnClickListener(this);
        ((Button)findViewById(R.id.button_soup)).setOnClickListener(this);
    }
    private void UpdateCategoryButtons(RecipeContract.RecipeTypeEnum enumVal) {
        if (enumVal == RecipeContract.RecipeTypeEnum.Entree) {

            ((Button) findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
        }
        if (enumVal == RecipeContract.RecipeTypeEnum.Salad) {
            ((Button) findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
        }
        if(enumVal == RecipeContract.RecipeTypeEnum.Soup) {
            ((Button) findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
            ((Button) findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
        }
        if(enumVal == RecipeContract.RecipeTypeEnum.Dessert) {
            ((Button)findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_plat)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
        }
        if(enumVal == RecipeContract.RecipeTypeEnum.Plat) {
            ((Button)findViewById(R.id.button_entree)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_salad)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_dessert)).setBackgroundColor(Color.TRANSPARENT);
            ((Button)findViewById(R.id.button_soup)).setBackgroundColor(Color.TRANSPARENT);
        }
    }
}

