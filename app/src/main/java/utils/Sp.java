package utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ASUS on 2017/11/13.
 */

public class Sp {
    private Context context;
    private SharedPreferences zhuangtai;
    private SharedPreferences.Editor edit;

    public Sp(Context context) {
        this.context = context;
        zhuangtai = context.getSharedPreferences("zhuangtai", Context.MODE_PRIVATE);
        edit = zhuangtai.edit();
    }



    public void getshuju(String key,boolean zhi){
        edit.putBoolean(key,zhi);
        edit.commit();
    }
    public void getshuju1(String key,String zhi){
        edit.putString(key,zhi);
        edit.commit();
    }
}
