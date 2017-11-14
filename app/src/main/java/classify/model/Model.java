package classify.model;

import android.util.Log;

import bean.Bean_fenlei;

import bean.Bean_right;
import classify.presenter.Ipresenter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory;


/**
 * Created by ASUS on 2017/11/14.
 */

public class Model implements Imodel{

    @Override
    public void getdata(final Ipresenter ipresenter) {
        Observable<Bean_fenlei> home = RetroFactory.getInstance_classify().getclassify();
        home.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bean_fenlei>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean_fenlei bean) {

                        Log.d("san",bean.toString()+"--->"+bean.getDatas().getClass_list().size()+bean.getDatas().getClass_list().get(0).getGc_name());
                        ipresenter.data(bean);


                    }
                });
    }

    @Override
    public void getdata1(final Ipresenter ipresenter, int s) {
        Observable<Bean_right> bean_fenleiObservable = RetroFactory.getInstance_classify().getclassify1(s);
   bean_fenleiObservable.subscribeOn(Schedulers.io())
           .subscribeOn(AndroidSchedulers.mainThread())
           .subscribe(new Subscriber<Bean_right>() {
               @Override
               public void onCompleted() {

               }

               @Override
               public void onError(Throwable e) {

               }

               @Override
               public void onNext(Bean_right bean_right) {
                   ipresenter.data1(bean_right);
               }
           });
    }
}
