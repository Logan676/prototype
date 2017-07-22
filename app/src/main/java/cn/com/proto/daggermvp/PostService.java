package cn.com.proto.daggermvp;

import java.util.List;

import cn.com.proto.daggermvp.data.Post;
import retrofit2.http.GET;
import rx.Observable;

public interface PostService {

    @GET("/posts")
    Observable<List<Post>> getPostList();
}
