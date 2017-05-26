package anxa.com.smvideo.contracts;

import com.google.gson.annotations.SerializedName;

/**
 * Created by angelaanxa on 5/25/2017.
 */

public class RecipeResponseContract extends BaseContract {
    @SerializedName("data")
    public RecipeDataContract Data;
}
