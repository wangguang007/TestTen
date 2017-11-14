package classify.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import bean.Bean_fenlei;
import bean.Bean_right;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import classify.presenter.Presenter;
import myadapter.MyAdapter_left;
import myadapter.MyAdapter_right;
import testten.bawei.com.testten.R;

/**
 * Created by ASUS on 2017/11/9.
 */

public class Fragment2 extends Fragment implements Iview {
    @BindView(R.id.type_rvleft)
    RecyclerView typeRvleft;
    @BindView(R.id.type_rvright)
    RecyclerView typeRvright;
    Unbinder unbinder;
    private Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment1, null);

        unbinder = ButterKnife.bind(this, v);
        typeRvleft.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter = new Presenter(this);
        presenter.get();
        return v;
    }

    @Override
    public void suss(Bean_fenlei bean) {
        MyAdapter_left m = new MyAdapter_left(getContext(),bean.getDatas().getClass_list());
        m.setOnItemClickListener(new MyAdapter_left.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
                presenter.fen(position+1);
            }
        });
        typeRvleft.setAdapter(m);
    }

    @Override
    public void suss1(Bean_right bean_right) {
        MyAdapter_right myAdapter_right = new MyAdapter_right(getActivity(),bean_right.getDatas().getClass_list());
        StaggeredGridLayoutManager s=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        typeRvright.setLayoutManager(s);
        typeRvright.setAdapter(myAdapter_right);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
