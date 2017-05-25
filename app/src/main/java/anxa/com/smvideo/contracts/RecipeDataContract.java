package anxa.com.smvideo.contracts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by angelaanxa on 5/25/2017.
 */

public class RecipeDataContract {
    @SerializedName("recipes")
    public List<RecipeContract> Recipes;
}
