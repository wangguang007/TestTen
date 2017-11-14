package personage.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bean.Bean_bus;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import testten.bawei.com.testten.R;

/**
 * Created by ASUS on 2017/11/9.
 */

public class Fragment4 extends Fragment {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.radio)
    RadioButton radio;
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.radiogeren1)
    RadioButton radiogeren1;
    @BindView(R.id.radiogeren2)
    RadioButton radiogeren2;
    @BindView(R.id.radiogeren3)
    RadioButton radiogeren3;
    @BindView(R.id.radiogeren4)
    RadioButton radiogeren4;
    @BindView(R.id.radiogeren5)
    RadioButton radiogeren5;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.radiogeren6)
    RadioButton radiogeren6;
    @BindView(R.id.radiogeren7)
    RadioButton radiogeren7;
    @BindView(R.id.radiogeren8)
    RadioButton radiogeren8;
    @BindView(R.id.radiogeren9)
    RadioButton radiogeren9;
    @BindView(R.id.radiogeren10)
    RadioButton radiogeren10;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.tv2)
    TextView tv2;
    Unbinder unbinder;
    private boolean dl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment3, null);
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this, v);
        SharedPreferences zhuangtai = getActivity().getSharedPreferences("zhuangtai", Context.MODE_PRIVATE);
        dl = zhuangtai.getBoolean("dl", false);
        if (dl){
            tv.setText(zhuangtai.getString("mobile",""));
        }else {

        }


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.img)
    public void onViewClicked() {
        if (!dl){startActivity(new Intent(getContext(),DengLu.class));}else {}

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(Bean_bus messageEvent){
        tv.setText(messageEvent.getName());
    }
}
