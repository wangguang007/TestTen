package testten.bawei.com.testten;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import classify.view.Fragment2;
import home.view.Fragment1;
import personage.view.Fragment4;
import shopping_cart.view.Fragment3;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomtabbar)
    BottomTabBar bottomtabbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//代码中  隐藏掉标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();


    }
    private void init(){

        //底部导航栏
        bottomtabbar.init(getSupportFragmentManager())
//                .setImgSize(80, 80)
//                .setFontSize(24)
                .setChangeColor(Color.RED, Color.GRAY)
                .addTabItem("首页", R.mipmap.ic_nav_home_press, R.mipmap.ic_nav_home, Fragment1.class)
                .addTabItem("分类", R.mipmap.ic_nav_class_press, R.mipmap.ic_nav_class, Fragment2.class)
                .addTabItem("购物车", R.mipmap.ic_nav_cart_press, R.mipmap.ic_nav_cart, Fragment3.class)
                .addTabItem("个人", R.mipmap.ic_nav_user_press , R.mipmap.ic_nav_user, Fragment4.class)
                .isShowDivider(false);
    }
}
