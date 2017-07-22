package cn.com.proto.business.protocol;

import java.util.List;

import cn.com.proto.business.bean.Contributor;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ServerApi {

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

}
