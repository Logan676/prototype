package cn.com.proto.retrofit;


import java.util.List;

import cn.com.proto.core.BaseView;
import cn.com.proto.business.bean.Contributor;
import cn.com.proto.core.BasePresenter;

public interface RetrofitDemoContract {

    interface View extends BaseView<Presenter> {
        void showContributors(List<Contributor> contributors);

        void showContributorsError(String message);

        void showContributorsEmpty();

        void showDownloadProgress(String progress);
    }

    interface Presenter extends BasePresenter {
        void contributors(String owner, String repo);

        void downloadFile(String url);
    }
}
