package personage.model;

import android.content.Context;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import bean.Bean_Dneg;
import bean.Bean_bus;
import personage.presenter.Idatainfo;
import personage.view.DengLu;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetroFactory;

/**
 * Created by ASUS on 2017/11/13.
 */

public class Model implements Imodel {
    @Override
    public void getData(Map<String, String> map, final Idatainfo idatainfo, final Context context) {
        Observable<Bean_Dneg> dengLus = RetroFactory.getInstancepost().getDengLu("/user/login",map );
        dengLus.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bean_Dneg>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean_Dneg bean_dneg) {

                        if (bean_dneg.getCode().equals("0")){
                            EventBus.getDefault().post(new Bean_bus(bean_dneg.getData().getUsername()));
                            idatainfo.data(bean_dneg);

                        }else {
                            Toast.makeText(context,"账户或者密码错误",Toast.LENGTH_SHORT).show();
                        }

                    }

                });
    }
}
