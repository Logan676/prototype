package cn.com.proto.databinding;

public interface DataBindingContract {
    public interface Presenter {
        void onShowData(TemperatureData temperatureData);
        void showList();
    }

    public interface View {
        void showData(TemperatureData temperatureData);
        void startSecondActivity();
    }
}
