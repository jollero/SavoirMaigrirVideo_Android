package anxa.com.smvideo.contracts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by angelaanxa on 5/23/2017.
 */

public class VideoDataContract extends BaseContract{
    @SerializedName("videos")
    public List<VideoContract> Videos;
}
