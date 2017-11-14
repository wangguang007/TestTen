package personage.model;

import android.content.Context;

import java.util.Map;

import personage.presenter.Idatainfo;

/**
 * Created by ASUS on 2017/11/13.
 */

public interface Imodel {
    void getData(Map<String,String> map, Idatainfo idatainfo, Context context);
}
