package bcms.monite.cn.bingchen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;
import com.yanzhenjie.sofia.Sofia;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sofia.with(this).statusBarBackground(R.color.colorAccent);
        Logger.i("信息","hehehe");
    }
}
