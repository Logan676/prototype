package cn.com.proto.launchmode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import cn.com.proto.R;
import cn.com.proto.view.LTabTextView;

public class LaunchModeDefaultA extends AppCompatActivity {

    private boolean isSingleInstance;
    private LTabTextView mLTabTextView;

    public static void start(Context context) {
        context.startActivity(new Intent(context, LaunchModeDefaultA.class));
    }

    public static void start(Context context, boolean isSingleInstance) {
        final Intent intent = new Intent(context, LaunchModeDefaultA.class);
        intent.putExtra("isSingleInstance", isSingleInstance);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_detail);

        mLTabTextView = (LTabTextView) findViewById(R.id.tv_test_bubble);

//        mLTabTextView.setText("测试小红点");
//        mLTabTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
//        mLTabTextView.setGravity(Gravity.CENTER);
        mLTabTextView.setBackgroundColor(Color.WHITE);
        mLTabTextView.setmPointText("26");
        mLTabTextView.setOffsetX(5);
        mLTabTextView.setOffsetY(5);
//        mLTabTextView.setTextSize(16);
        isSingleInstance = getIntent().getBooleanExtra("isSingleInstance", false);
        findViewById(R.id.btn_launch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSingleInstance) {
                    LaunchModeSingleInstanceB.start(LaunchModeDefaultA.this);
                } else
                    LaunchModeSingleTaskB.start(LaunchModeDefaultA.this);
            }
        });
    }

}
