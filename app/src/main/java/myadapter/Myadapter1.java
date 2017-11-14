package myadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;




import bean.ShouYe_Bean;
import testten.bawei.com.testten.R;
import utils.ImageUtils;


/**
 * Created by ASUS on 2017/10/17.
 */

public class Myadapter1 extends RecyclerView.Adapter<Myadapter1.MyViewHolder> {
    private Context context;
    private int tagpost=0;
    private ShouYe_Bean.DataBean data;

    public Myadapter1(Context context, ShouYe_Bean.DataBean data, int tagpost){
        this.context=context;

        this.data=data;
        this.tagpost=tagpost;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item1_1, parent, false));
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (tagpost){
            case 0:

                holder.tv1.setText(data.getAd5().get(position).getTitle());
                ImageUtils.setImageView(data.getAd5().get(position).getImage(),context,holder.img);
                break;
            case 1:
                holder.tv1.setText(data.getAd5().get(position).getTitle());
                ImageUtils.setImageView(data.getAd5().get(position).getImage(),context,holder.img);
                break;
            case 7:
                holder.tv1.setText(data.getAd8().get(position).getTitle());
                ImageUtils.setImageView(data.getAd8().get(position).getImage(),context,holder.img);
                break;
            case 3:
                holder.tv1.setText(data.getSubjects().get(position).getTitle());
                ImageUtils.setImageView(data.getSubjects().get(position).getImage(),context,holder.img);
                break;
            case 4:
                holder.tv1.setText(data.getDefaultGoodsList().get(position).getGoods_name());
                ImageUtils.setImageView(data.getDefaultGoodsList().get(position).getGoods_img(),context,holder.img);
                break;
            case 5:
                holder.tv1.setText(data.getDefaultGoodsList().get(position).getGoods_name());
                ImageUtils.setImageView(data.getGoodsSpreeActivity().getGoodsList().get(position).getGoodsImg(),context,holder.img);
                break;
        }

    }



    @Override
    public int getItemCount() {
//        if (tagpost==0){
//
//        }
        switch (tagpost){
            case 0:
                return data.getAd5().size();
            case 1:
                return data.getAd1().size();
            case 2:
                return data.getAd8().size();
            case 3:
                return data.getSubjects().size();
            case 4:
                return data.getDefaultGoodsList().size();
            case 5:
                return data.getGoodsSpreeActivity().getGoodsList().size();

        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.tv_sou1);
            img = (ImageView) itemView.findViewById(R.id.img_sou);
        }
    }
}
