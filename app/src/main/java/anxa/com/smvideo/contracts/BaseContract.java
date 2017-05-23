package anxa.com.smvideo.contracts;

import com.google.gson.annotations.SerializedName;

/**
 * Created by angelaanxa on 5/23/2017.
 */

public class BaseContract {
    @SerializedName("error_count")
    public int ErrorCount;
    @SerializedName("message")
    public String Message;
    @SerializedName("message_detail")
    public String MessageDetails;
}
