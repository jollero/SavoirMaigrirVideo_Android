package anxa.com.smvideo.util;

import android.graphics.Bitmap;

import anxa.com.smvideo.ApplicationData;

/**
 * Created by angelaanxa on 5/30/2017.
 */

public  class RecipeHelper {
    public static Bitmap GetRecipeImage(int recipeId) {
        Bitmap avatarBMP = null;
        if (recipeId > 0) {
            avatarBMP = ApplicationData.getInstance().recipePhotoList.get(String.valueOf(recipeId));

            return avatarBMP;

        }

        return avatarBMP;

    }
}
