package cn.com.proto.dagger;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {DaggerModule.class, AndroidInjectionModule.class})
public interface IApplicationComponent {
    void inject(MyApplication application);
}
