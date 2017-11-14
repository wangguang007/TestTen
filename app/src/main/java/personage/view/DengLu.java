package personage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import bean.Bean_Dneg;
import bean.Bean_bus;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import personage.presenter.Presenter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import testten.bawei.com.testten.MainActivity;
import testten.bawei.com.testten.R;
import utils.RetroFactory;
import utils.Sp;
import utils.Toasts;

/**
 * Created by ASUS on 2017/11/10.
 */

public class DengLu extends AppCompatActivity implements Iview{
    @BindView(R.id.img_deng)
    ImageView imgDeng;
    @BindView(R.id.img_deng1)
    ImageView imgDeng1;
    @BindView(R.id.et_deng)
    EditText etDeng;
    @BindView(R.id.et_deng1)
    EditText etDeng1;
    @BindView(R.id.denglu_san)
    ImageView dengluSan;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.denglu)
    Button denglu;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);
        ButterKnife.bind(this);
        presenter = new Presenter(this);

    }

    @OnClick(R.id.denglu)
    public void onViewClicked() {
        String s = etDeng.getText().toString();
        String s1 = etDeng1.getText().toString();
        Map<String,String> m = new HashMap<>();
        m.put("mobile",s);
        m.put("password",s1);
        presenter.getshuju(m,this);


    }

    @Override
    public void shipei(Bean_Dneg bean_dneg) {
        if (bean_dneg.getCode().equals("0")){
            EventBus.getDefault().post(new Bean_bus(bean_dneg.getData().getUsername()));
            finish();
            Sp sp = new Sp(DengLu.this);
            sp.getshuju("dl",true);
            sp.getshuju1("mobile",bean_dneg.getData().getUsername());

        }else {
            Toast.makeText(DengLu.this,"账户或者密码错误",Toast.LENGTH_SHORT).show();
        }
    }
}
