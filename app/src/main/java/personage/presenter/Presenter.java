package personage.presenter;

import android.content.Context;

import java.util.Map;

import bean.Bean_Dneg;
import personage.model.Model;
import personage.view.Iview;


/**
 * Created by ASUS on 2017/11/13.
 */

public class Presenter {
    private Model model;
    private Iview iview;

    public Presenter(Iview iview) {
        this.model = new Model();
        this.iview = iview;
    }
    public void getshuju(Map<String,String> map, Context context){
        model.getData(map, new Idatainfo() {
            @Override
            public void data(Bean_Dneg bean_dneg) {
                iview.shipei(bean_dneg);
            }
        },context);
    }
}
