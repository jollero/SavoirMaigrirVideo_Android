package anxa.com.smvideo.contracts;

import anxa.com.smvideo.activities.BaseVideoActivity;
import com.google.gson.annotations.SerializedName;
/**
 * Created by angelaanxa on 5/23/2017.
 */

public class VideoResponseContract extends BaseContract {
    @SerializedName("data")
    public VideoDataContract Data;
}
