package anxa.com.smvideo.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import anxa.com.smvideo.ApplicationData;
import anxa.com.smvideo.R;
import anxa.com.smvideo.contracts.RecipeContract;

/**
 * Created by angelaanxa on 5/25/2017.
 */

public class RecipesListAdapter extends ArrayAdapter<RecipeContract> implements View.OnClickListener {

    private final Context context;
    private List<RecipeContract> items = new ArrayList<RecipeContract>();

    LayoutInflater layoutInflater;
    String inflater = Context.LAYOUT_INFLATER_SERVICE;
    View.OnClickListener listener;

    public RecipesListAdapter(Context context, List<RecipeContract> items, View.OnClickListener listener) {
        super(context, R.layout.listitem_recipe, items);

        layoutInflater = (LayoutInflater) context.getSystemService(inflater);
        this.context = context;
        this.items = items;
        this.listener = listener;

    }
    public void updateItems(List<RecipeContract> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        View row = convertView;
        if (row == null) {
            LayoutInflater layoutInflator = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = layoutInflator.inflate(R.layout.listitem_recipe, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.recipeImage = (ImageView) row.findViewById(R.id.recipeImage);
            viewHolder.recipeTitle = ((TextView) row.findViewById(R.id.recipeTitle));
            row.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) row.getTag();
        }

        int itemCount = items.size() - position;

        if (getCount() > position && itemCount == 5) {
            System.out.println("getPosition");
        }

        RecipeContract recipe = (RecipeContract) items.get(position);
        row.setTag(R.id.recipe_id, recipe.Id);
        row.setOnClickListener(this);
        Bitmap avatar = null;
        avatar = getAvatar(recipe.Id);
        viewHolder.recipeImage.setTag(recipe.Id);
        //display message
        viewHolder.recipeTitle.setText(recipe.Title);
        if (avatar == null) {
            new AdapterDownloadImageTask(viewHolder.recipeImage).execute(recipe.ImageUrl);
        } else {

            viewHolder.recipeImage.setImageBitmap(avatar);
        }

        return row;
    }


    private void refreshUI() {
        notifyDataSetChanged();
    }
    @Override
    public void onClick(View v) {

    }
    private class AdapterDownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private ImageView bmImage;
        private String path;

        public AdapterDownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
            this.path = bmImage.getTag().toString();
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            String coachIdToSave = urldisplay.substring(urldisplay.indexOf("users/") + 6, urldisplay.lastIndexOf("/"));

            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);

                if (!ApplicationData.getInstance().recipePhotoList.containsKey(coachIdToSave) && mIcon11 != null) {
                    ApplicationData.getInstance().recipePhotoList.put(coachIdToSave, mIcon11);
                }

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            if (!bmImage.getTag().toString().equals(path)) {
                return;
            }

            if (result != null && bmImage != null) {
                bmImage.setVisibility(View.VISIBLE);
                bmImage.setImageBitmap(result);

            } else {
                bmImage.setVisibility(View.GONE);
            }
        }
    }
    private Bitmap getAvatar(int recipeId) {
        Bitmap avatarBMP = null;
        if (recipeId > 0) {
            avatarBMP = ApplicationData.getInstance().recipePhotoList.get(String.valueOf(recipeId));

            return avatarBMP;

        }

        return avatarBMP;

    }
    private static class ViewHolder {
        ImageView recipeImage;
        TextView recipeTitle;
    }
}
