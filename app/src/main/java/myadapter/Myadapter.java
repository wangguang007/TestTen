package myadapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


import bean.ShouYe_Bean;
import testten.bawei.com.testten.R;
import utils.ImageUtils;


/**
 * Created by ASUS on 2017/10/17.
 */

public class Myadapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    private Context context;
    private List<ShouYe_Bean.DataBean.Ad5Bean> list = new ArrayList<>();
    ShouYe_Bean.DataBean data;
    String[] url_bunner=new String[4];
    List<ShouYe_Bean.DataBean.Ad1Bean> ad1 = new ArrayList<>();
    public static final int SHOU = 0;
    public static final int SHOU1 = 1;
    public static final int SHOU2 = 2;
    public static final int SHOU3 = 3;
    public static final int SHOU4 = 4;
    public static final int SHOU5 = 5;
    public static final int SHOU6 = 6;
    public static final int SHOU7 = 7;
    public static final int SHOU8 = 8;
    public Myadapter(Context context, List<ShouYe_Bean.DataBean.Ad5Bean> list, ShouYe_Bean.DataBean data){
        this.context=context;
        this.list=list;
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==SHOU){
            MyViewHolderbanner holder = new MyViewHolderbanner(LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false));
            return holder;
        }else if (viewType==SHOU1){
            MyViewHolder1 holder1 = new MyViewHolder1(LayoutInflater.from(context).inflate(R.layout.item1, parent, false));
            return holder1;
        }else if (viewType==SHOU2){
            MyViewHolderitem holder2 = new MyViewHolderitem(LayoutInflater.from(context).inflate(R.layout.item_1, parent, false));
            return holder2;
        }else if (viewType==SHOU3){
            MyViewHolder1 holder1 = new MyViewHolder1(LayoutInflater.from(context).inflate(R.layout.item1, parent, false));
            return holder1;
        }else if (viewType==SHOU4){
            MyViewHolderitem holder2 = new MyViewHolderitem(LayoutInflater.from(context).inflate(R.layout.item_1, parent, false));
            return holder2;
        }else if (viewType==SHOU5){
            MyViewHolder1 holder1 = new MyViewHolder1(LayoutInflater.from(context).inflate(R.layout.item1, parent, false));
            return holder1;
        }else if (viewType==SHOU6){
            MyViewHolderitem holder2 = new MyViewHolderitem(LayoutInflater.from(context).inflate(R.layout.item_1, parent, false));
            return holder2;
        }else if (viewType==SHOU7){
            MyViewHolder1 holder1 = new MyViewHolder1(LayoutInflater.from(context).inflate(R.layout.item1, parent, false));
            return holder1;
        }

//        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==SHOU){

             ad1= data.getAd1();
            for (int i = 0;i<data.getAd1().size();i++){
                url_bunner[i]=ad1.get(i).getImage();
            }
            ((MyViewHolderbanner)holder).banner.setImages(url_bunner);
            ((MyViewHolderbanner)holder).banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
            ((MyViewHolderbanner)holder).banner.setDelayTime(3000);


//            Myadapter1 myadapter1 = new Myadapter1(context,data.getDefaultGoodsList(),data,position);
//            StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
//            ((MyViewHolder)holder).recyclerView.setLayoutManager(staggeredGridLayoutManager);
//            ((MyViewHolder)holder).recyclerView.setItemAnimator(new DefaultItemAnimator());
//            ((MyViewHolder)holder).recyclerView.setAdapter(myadapter1);
        }else if(getItemViewType(position)==SHOU1){
            Myadapter1 myadapter1 = new Myadapter1(context,data,position);
            StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
            ((MyViewHolder1)holder).recyclerView.setLayoutManager(staggeredGridLayoutManager);
            ((MyViewHolder1)holder).recyclerView.setItemAnimator(new DefaultItemAnimator());
            ((MyViewHolder1)holder).recyclerView.setAdapter(myadapter1);
        }else if (getItemViewType(position)==SHOU2){
            ((MyViewHolderitem)holder).tv.setText(data.getSubjects().get(0).getTitle());
            ImageUtils.setImageView(data.getSubjects().get(0).getImage(),context,((MyViewHolderitem)holder).img);
        }else if(getItemViewType(position)==SHOU3){
            Myadapter1 myadapter1 = new Myadapter1(context,data,position);
            StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            ((MyViewHolder1)holder).recyclerView.setLayoutManager(staggeredGridLayoutManager);
            ((MyViewHolder1)holder).recyclerView.setItemAnimator(new DefaultItemAnimator());
            ((MyViewHolder1)holder).recyclerView.setAdapter(myadapter1);
        }else if (getItemViewType(position)==SHOU4){
            ((MyViewHolderitem)holder).tv.setText(data.getSubjects().get(1).getTitle());
            ImageUtils.setImageView(data.getSubjects().get(1).getImage(),context,((MyViewHolderitem)holder).img);
        }else if(getItemViewType(position)==SHOU5){
            Myadapter1 myadapter1 = new Myadapter1(context,data,position);
            StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            ((MyViewHolder1)holder).recyclerView.setLayoutManager(staggeredGridLayoutManager);
            ((MyViewHolder1)holder).recyclerView.setItemAnimator(new DefaultItemAnimator());
            ((MyViewHolder1)holder).recyclerView.setAdapter(myadapter1);
        }else if (getItemViewType(position)==SHOU6){
            ((MyViewHolderitem)holder).tv.setText(data.getSubjects().get(2).getTitle());
            ImageUtils.setImageView(data.getSubjects().get(3).getImage(),context,((MyViewHolderitem)holder).img);
        }else if(getItemViewType(position)==SHOU7){
            Myadapter1 myadapter1 = new Myadapter1(context,data,position);
            StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
            ((MyViewHolder1)holder).recyclerView.setLayoutManager(staggeredGridLayoutManager);
            ((MyViewHolder1)holder).recyclerView.setItemAnimator(new DefaultItemAnimator());
            ((MyViewHolder1)holder).recyclerView.setAdapter(myadapter1);
        }

    }


    @Override
    public int getItemViewType(int position) {
        if (position==SHOU){
            return SHOU;
        }else if (position==SHOU1){
            return SHOU1;
        }
        else if (position==SHOU2){
            return SHOU2;
        }
        else if (position==SHOU3){
            return SHOU3;
        }
        else if (position==SHOU4){
            return SHOU4;
        }
        else if (position==SHOU5){
            return SHOU5;
        }else if (position==SHOU5){
            return SHOU5;
        }
        else if (position==SHOU6){
            return SHOU6;
        }
        else if (position==SHOU7){
            return SHOU7;
        }else {

            return -1;
        }
    }





    @Override
    public int getItemCount() {
        return 6;
    }
    class MyViewHolderbanner extends XRecyclerView.ViewHolder{
        Banner banner;
        public MyViewHolderbanner(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    class MyViewHolder extends XRecyclerView.ViewHolder {

//        TextView tv1;
//        ImageView img;
        RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

//                tv1 = (TextView) itemView.findViewById(R.id.tv_sou1);
//                img = (ImageView) itemView.findViewById(R.id.img_sou);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycyler_item1);
        }

    }
    class MyViewHolder1 extends XRecyclerView.ViewHolder {


        RecyclerView recyclerView;
        public MyViewHolder1(View itemView) {
            super(itemView);
                recyclerView = (RecyclerView) itemView.findViewById(R.id.recycyler1);
        }
    }
    class MyViewHolderitem extends XRecyclerView.ViewHolder{
        TextView tv;
        ImageView img;
        public MyViewHolderitem(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv_sou);
            img= (ImageView) itemView.findViewById(R.id.img_sou);
        }
    }
}
