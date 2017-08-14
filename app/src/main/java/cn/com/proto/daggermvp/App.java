package cn.com.proto.daggermvp;

import android.app.Application;

import cn.com.proto.daggermvp.data.component.NetComponent;
import cn.com.proto.daggermvp.data.module.AppModule;
import cn.com.proto.daggermvp.data.module.NetModule;

public class App extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        /*mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();*/

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
