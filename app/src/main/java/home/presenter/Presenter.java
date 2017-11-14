package home.presenter;

import java.util.List;

import bean.ShouYe_Bean;
import home.model.Model;
import home.view.Iview;

/**
 * Created by ASUS on 2017/11/9.
 */

public class Presenter {
    private Model model;
    private Iview iview;

    public Presenter(Iview iview) {
        this.model = new Model();
        this.iview = iview;
    }
    public void shezhi(){
        model.huoqu(new Ipresenter() {
            @Override
            public void ShuJus(List<ShouYe_Bean.DataBean.Ad5Bean> list, ShouYe_Bean.DataBean data) {
                iview.suss(list,data);
            }
        });
    }
}
