package utils;



import java.util.Map;

import bean.Bean_Dneg;
import bean.Bean_fenlei;
import bean.Bean_right;
import bean.ShouYe_Bean;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {
//
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<ShouYe_Bean> getHome();
    @POST
    Observable<Bean_Dneg> getDengLu(@Url String name, @QueryMap Map<String,String> paw);
    @GET("mobile/index.php?act=goods_class")
    Observable<Bean_fenlei> getclassify();
    @GET("mobile/index.php?act=goods_class&gc_id")
    Observable<Bean_right> getclassify1(@Query("gc_id") int s);
//
//    @GET("v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
//    Observable<HomeBeans> getHomes();




}
