package classify.presenter;


import bean.Bean_fenlei;
import bean.Bean_right;
import classify.model.Model;
import classify.view.Iview;

/**
 * Created by ASUS on 2017/11/14.
 */

public class Presenter {
    private Model model;
    private Iview iview;

    public Presenter( Iview iview) {
        this.model = new Model();
        this.iview = iview;
    }
    public void get(){
        model.getdata(new Ipresenter() {
            @Override
            public void data(Bean_fenlei bean) {
                iview.suss(bean);
            }

            @Override
            public void data1(Bean_right bean_right) {

            }
        });
    }
    public void fen(int s){
        model.getdata1(new Ipresenter() {
            @Override
            public void data(Bean_fenlei bean) {

            }

            @Override
            public void data1(Bean_right bean_right) {
                iview.suss1(bean_right);
            }
        },s);
    }
}
