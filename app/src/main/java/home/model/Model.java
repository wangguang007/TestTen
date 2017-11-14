package home.model;

import bean.ShouYe_Bean;
import home.presenter.Ipresenter;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import utils.RetroFactory;

/**
 * Created by ASUS on 2017/11/9.
 */

public class Model implements Imodel {
    @Override
    public void huoqu(final Ipresenter ipresenter) {
        Observable<ShouYe_Bean> home = RetroFactory.getInstance().getHome();
        home.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ShouYe_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShouYe_Bean shouYe_bean) {
                        ipresenter.ShuJus(shouYe_bean.getData().getAd5(),shouYe_bean.getData());
                    }
                });
    }
}
