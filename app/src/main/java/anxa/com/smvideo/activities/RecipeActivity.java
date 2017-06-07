package anxa.com.smvideo.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import anxa.com.smvideo.ApplicationData;
import anxa.com.smvideo.R;
import anxa.com.smvideo.connection.http.RecipeDownloadImageAsync;
import anxa.com.smvideo.contracts.RecipeContract;
import anxa.com.smvideo.util.RecipeHelper;
import anxa.com.smvideo.util.UITagHandler;

/**
 * Created by angelaanxa on 5/29/2017.
 */

public class RecipeActivity extends BaseVideoActivity {
    private List<RecipeContract> recipesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);
        ((TextView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_title_tv)).setText(getString(R.string.menu_recette));
        ((ImageView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_menu_back)).setVisibility(View.VISIBLE);
        ((ImageView)((RelativeLayout)findViewById(R.id.headermenu)).findViewById(R.id.header_menu_iv)).setVisibility(View.GONE);

        Bundle extra = getIntent().getExtras();
        int recipeId = extra.getInt("RECIPE_ID",0);
        recipesList = ApplicationData.getInstance().recipeList;
        if(recipeId > 0){
            for(RecipeContract r : recipesList)
            {
               if(r.Id == recipeId)
               {
                   ((TextView)findViewById(R.id.recipeTitle)).setText(r.Title);
                   Bitmap avatar = null;
                   avatar = RecipeHelper.GetRecipeImage(r.Id);
                   ImageView img = (ImageView)findViewById(R.id.recipeImage);
                   img.setTag(r.Id);
                   if (avatar == null) {
                       new RecipeDownloadImageAsync( img,(ProgressBar) findViewById(R.id.recipeImageProgress), r.Id).execute(r.ImageUrl);
                   } else {
                       ((ImageView)findViewById(R.id.recipeImage)).setImageBitmap(avatar);
                       ((ProgressBar) findViewById(R.id.recipeImageProgress)).setVisibility(View.GONE);
                   }
                   ((TextView)findViewById(R.id.recipeIngredientsTitle)).setText((r.IngredientsTitle));
                   ((TextView)findViewById(R.id.recipeIngredients)).setText(Html.fromHtml(r.IngredientsHtml, null, new UITagHandler()));
                   ((TextView)findViewById(R.id.recipePreparation)).setText(Html.fromHtml(r.PreparationHtml, null, new UITagHandler()));
               }
            }
        }
    }

    public void onBackPressed(View view) {
        super.onBackPressed();
    }
    private Bitmap getAvatar(int recipeId) {
        Bitmap avatarBMP = null;
        if (recipeId > 0) {
            avatarBMP = ApplicationData.getInstance().recipePhotoList.get(String.valueOf(recipeId));

            return avatarBMP;

        }

        return avatarBMP;

    }

}