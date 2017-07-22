package cn.com.proto.daggermvp.mainscreen;

import cn.com.proto.daggermvp.util.CustomScope;
import cn.com.proto.daggermvp.data.component.NetComponent;
import dagger.Component;

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
