package cn.com.proto.daggermvp.mainscreen;

import java.util.List;

import cn.com.proto.daggermvp.data.Post;

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
