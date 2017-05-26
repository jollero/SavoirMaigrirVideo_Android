package anxa.com.smvideo.contracts;

import com.google.gson.annotations.SerializedName;

/**
 * Created by angelaanxa on 5/25/2017.
 */

public class RecipeContract {
    @SerializedName("id")
    public int Id;
    @SerializedName("type")
    public RecipeType RecipeType;
    @SerializedName("title")
    public String Title;
    @SerializedName("ingredientsTitle")
    public String IngredientsTitle;
    @SerializedName("ingredientsHtml")
    public  String IngredientsHtml;
    @SerializedName("ingredientsText")
    public String IngredientsText;
    @SerializedName("preparationHtml")
    public String PreparationHtml;
    @SerializedName("preparationText")
    public String PreparationText;
    @SerializedName("imageUrl")
    public String ImageUrl;

    public static enum RecipeType
    {
        Appetizer,
        Drink,
        Dessert,
        Entree,
        Plat,
        Salad,
        Sauce,
        Snack,
        Soup,
        Other
    }

}
