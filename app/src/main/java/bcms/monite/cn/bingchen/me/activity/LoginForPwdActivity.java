package bcms.monite.cn.bingchen.me.activity;

import android.content.Intent;
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

public class LoginForPwdActivity extends BaseActivity implements BaseNetListener {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;


    @Override
    public int initLayoutResID() {
        return R.layout.activity_login_for_pwd;
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
    @OnClick({R.id.forget_pwd, R.id.go_login})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget_pwd:
                startActivity(new Intent(LoginForPwdActivity.this, ForgetPwdActivity.class));
                break;
            case R.id.go_login:
                login();
                break;
            default:
                break;
        }
    }

    private void login() {
        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();

        if (!checkParams()) {
            return;
        }


        paramsSingle.put("mobilePhone", phone.getText().toString().trim());
        paramsSingle.put("password", pwd.getText().toString().trim());


        NetUtils.getInstance().postObj("/my/login/passwordLogin.action",
                paramsSingle, this, "002", LoginBean.class);
    }

    private boolean checkParams() {
        if (phone.getText().toString().trim().length() != 11) {
            ToastUtils.getInstance().showShortToast("请输入正确的手机号码");
            return false;
        }
        if (pwd.getText().toString().trim().length() < 6) {
            ToastUtils.getInstance().showShortToast("密码不小于6位");
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
