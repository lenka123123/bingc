package bcms.monite.cn.bingchen.me.activity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.TreeMap;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.common.BaseNetListener;
import bcms.monite.cn.bingchen.common.NetUtils;
import bcms.monite.cn.bingchen.common.ToastUtils;
import bcms.monite.cn.bingchen.me.model.LoginBean;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements BaseNetListener {

    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.phone)
    EditText phone;


    @Override
    public int initLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {


    }


    @Override
    protected void initView() {

    }


    private void getCode() {
        if (phone.getText().toString().trim().length() != 11) {
            ToastUtils.getInstance().showShortToast("请输入正确的手机号码");
            return;
        }

        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();
        paramsSingle.put("mobilePhone", phone.getText().toString().trim());
        NetUtils.getInstance().post("/my/login/getLoginVerifyCode.action",
                paramsSingle, this, "001");

    }


    @Override
    @OnClick({R.id.get_code, R.id.go_login})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_code:
                getCode();
                break;
            case R.id.go_login:  //验证码登录
                login(false, phone.getText().toString().trim(),
                        "", "", code.getText().toString().trim());
                break;
            default:
                break;
        }

    }

    private void login(boolean isThirdPlatform, String mobilePhone, String thirdPlatformId,
                       String thirdPlatformType, String verifyCode) {
        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();

        if (!checkParams()) {
            return;
        }
        paramsSingle.put("isThirdPlatform", isThirdPlatform);
        if (!mobilePhone.equals("")) {
            paramsSingle.put("mobilePhone", mobilePhone);
        }
        if (!thirdPlatformId.equals("")) {
            paramsSingle.put("thirdPlatformId", thirdPlatformId);
        }
        if (!thirdPlatformType.equals("")) {
            paramsSingle.put("thirdPlatformType", thirdPlatformType);//第三方平台类型-1.微信 2.QQ 3微博
        }
        if (!verifyCode.equals("")) {
            paramsSingle.put("verifyCode", verifyCode);
        }

        NetUtils.getInstance().postObj("/my/login/verifyCodeLogin.action",
                paramsSingle, this, "002", LoginBean.class);
    }

    private boolean checkParams() {
        if (phone.getText().toString().trim().length() != 11) {
            ToastUtils.getInstance().showShortToast("请输入正确的手机号码");
            return false;
        }
        if (code.getText().toString().trim().length() < 2) {
            ToastUtils.getInstance().showShortToast("请输入短信验证码");
            return false;
        }

        return true;
    }


    @Override
    public void success(String flag, Object data) {
        if (flag.equals("001")) {
            ToastUtils.getInstance().showShortToast("获取验证码成功");
        }
        if (flag.equals("002")) {
            LoginBean bean = (LoginBean) data;
            Log.i("getMessage", "success: " + bean.getMessage());
        }

    }

    @Override
    public void fail(String flag, String meg) {
        ToastUtils.getInstance().showShortToast(meg);
    }

}
