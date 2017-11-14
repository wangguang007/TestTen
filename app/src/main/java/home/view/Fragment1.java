package home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.List;

import bean.ShouYe_Bean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import home.presenter.Presenter;
import myadapter.Myadapter;
import testten.bawei.com.testten.R;

/**
 * Created by ASUS on 2017/11/9.
 */

public class Fragment1 extends Fragment {
    @BindView(R.id.zxing)
    ImageView zxing;
    @BindView(R.id.edittext)
    EditText edittext;
    @BindView(R.id.duanxin)
    ImageView duanxin;
    @BindView(R.id.recycyler)
    XRecyclerView recycyler;
    Unbinder unbinder;
    private Presenter p;
    private int REQUEST_CODE = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment, null);
        unbinder = ButterKnife.bind(this, v);
        init();
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recycyler.setLayoutManager(staggeredGridLayoutManager);
        p.shezhi();

        return v;
    }

    private void init() {
        p = new Presenter(new Iview() {
            @Override
            public void suss(List<ShouYe_Bean.DataBean.Ad5Bean> list, ShouYe_Bean.DataBean data) {
                Myadapter m = new Myadapter(getContext(),list,data);
                recycyler.setAdapter(m);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.zxing, R.id.recycyler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zxing:
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
