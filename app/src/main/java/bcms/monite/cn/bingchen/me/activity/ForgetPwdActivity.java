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

public class ForgetPwdActivity extends BaseActivity implements BaseNetListener {

    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.new_pwd)
    EditText new_pwd;
    @BindView(R.id.new_pwd_again)
    EditText new_pwd_again;


    @Override
    public int initLayoutResID() {
        return R.layout.activity_forget_pwd;
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
        NetUtils.getInstance().post("/my/login/getForgetPasswordVerifyCode.action",
                paramsSingle, this, "001");

    }


    @Override
    @OnClick({R.id.get_code, R.id.commit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_code:
                getCode();
                break;
            case R.id.commit:


                commit();


                break;
            default:
                break;
        }

    }

    private void commit() {
        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();

        if (!checkParams()) {
            return;
        }
        paramsSingle.put("mobilePhone", phone.getText().toString().trim());
        paramsSingle.put("verifyCode", code.getText().toString().trim());
        paramsSingle.put("passowrd", new_pwd_again.getText().toString().trim());


        NetUtils.getInstance().postObj("/my/login/forgetPasswordLogin.action",
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
        if (!new_pwd.getText().toString().trim().equals(new_pwd_again.getText().toString().trim())) {
            ToastUtils.getInstance().showShortToast("两次密码不一致");
            return false;
        }
        if (new_pwd_again.getText().toString().trim().length() < 6) {
            ToastUtils.getInstance().showShortToast("密码必须大于6位");
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
