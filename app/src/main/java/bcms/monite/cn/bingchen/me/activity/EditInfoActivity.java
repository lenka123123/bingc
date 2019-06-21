package bcms.monite.cn.bingchen.me.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.common.BaseNetListener;
import bcms.monite.cn.bingchen.common.NetUtils;
import bcms.monite.cn.bingchen.common.ToastUtils;
import bcms.monite.cn.bingchen.common.customview.alertview.AlertViewContorller;
import bcms.monite.cn.bingchen.common.customview.alertview.OnItemClickListener;
import bcms.monite.cn.bingchen.me.model.LoginBean;
import butterknife.BindView;
import butterknife.OnClick;

public class EditInfoActivity extends BaseActivity implements BaseNetListener, OnItemClickListener {

    @BindView(R.id.nick_name)
    EditText nick_name;
    @BindView(R.id.bc_num)
    EditText bc_num;
    @BindView(R.id.sign)
    EditText sign;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.birthday)
    EditText birthday;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.flag)
    EditText flag;

    private String[] genderes = {"男", "女", "保密"};
    private AlertViewContorller mAlertViewContorller;

    @Override
    public int initLayoutResID() {
        return R.layout.activity_edit_info;
    }

    @Override
    protected void initData() {


    }


    @Override
    protected void initView() {

    }


    private void getCode() {
//        if (phone.getText().toString().trim().length() != 11) {
//            ToastUtils.getInstance().showShortToast("请输入正确的手机号码");
//            return;
//        }
//
//        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();
//        paramsSingle.put("mobilePhone", phone.getText().toString().trim());
//        NetUtils.getInstance().post("/my/login/getLoginVerifyCode.action",
//                paramsSingle, this, "001");

    }


    @Override
    @OnClick({R.id.close_img, R.id.sex})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_code:
                finish();
                break;
            case R.id.sex:
                mAlertViewContorller = new AlertViewContorller(sex, "选择类型", null, "取消", null, genderes,
                        context, AlertViewContorller.Style.ActionSheet, this);
                mAlertViewContorller.setCancelable(true).show();
                break;
            case R.id.birthday:
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                String format1 = format.format(date);
//                TimeSelector timeSelector = new TimeSelector(EditInfoActivity.this, new TimeSelector.ResultHandler() {
//                    @Override
//                    public void handle(String time) {
//                        t_time.setText(time);
//                    }
//                }, format1, "2050-1-1 24:00");
//                timeSelector.show();

                break;


//            case R.id.go_login:  //验证码登录
//                login(false, phone.getText().toString().trim(),
//                        "", "", code.getText().toString().trim());
//                break;
//            case R.id.pwd_login:
//                startActivity(new Intent(EditInfoActivity.this, LoginForPwdActivity.class));
//                break;
            default:
                break;
        }

    }

    private void login(boolean isThirdPlatform, String mobilePhone, String thirdPlatformId,
                       String thirdPlatformType, String verifyCode) {
//        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();
//        if (!checkParams()) {
//            return;
//        }
//        paramsSingle.put("isThirdPlatform", isThirdPlatform);
//        if (!mobilePhone.equals("")) {
//            paramsSingle.put("mobilePhone", mobilePhone);
//        }
//        if (!thirdPlatformId.equals("")) {
//            paramsSingle.put("thirdPlatformId", thirdPlatformId);
//        }
//        if (!thirdPlatformType.equals("")) {
//            paramsSingle.put("thirdPlatformType", thirdPlatformType);//第三方平台类型-1.微信 2.QQ 3微博
//        }
//        if (!verifyCode.equals("")) {
//            paramsSingle.put("verifyCode", verifyCode);
//        }
//
//        NetUtils.getInstance().postObj("/my/login/verifyCodeLogin.action",
//                paramsSingle, this, "002", LoginBean.class);
    }

    private boolean checkParams() {
//        if (phone.getText().toString().trim().length() != 11) {
//            ToastUtils.getInstance().showShortToast("请输入正确的手机号码");
//            return false;
//        }
//        if (code.getText().toString().trim().length() < 2) {
//            ToastUtils.getInstance().showShortToast("请输入短信验证码");
//            return false;
//        }

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
            startActivity(new Intent(EditInfoActivity.this, LoginForPwdActivity.class));


        }

    }

    @Override
    public void fail(String flag, String meg) {
        ToastUtils.getInstance().showShortToast(meg);
    }

    @Override
    public void onItemClick(View view, List<String> mOthers, Object o, int position) {
        if (position == -1) {
            mAlertViewContorller.dismiss();
        } else {
            if (view instanceof TextView) {
                TextView view1 = (TextView) view;
                view1.setText(mOthers.get(position));
            }

        }
    }
}
