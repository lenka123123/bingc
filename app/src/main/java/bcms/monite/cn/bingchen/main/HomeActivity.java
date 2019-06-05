package bcms.monite.cn.bingchen.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.config.Constants;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class HomeActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {


    private String TAG = HomeActivity.class.getSimpleName();

    @BindColor(R.color.color77)
    int colorUnSelect;
    @BindColor(R.color.black)
    int colorSelect;

    @BindViews({R.id.tab_img_home, R.id.tab_img_zb, R.id.tab_img_shop_cart, R.id.tab_img_ucenter, R.id.tab_img_me})
    ImageView[] mImageViews;

    @BindViews({R.id.tab_text_home, R.id.tab_text_zb, R.id.tab_text_shop_cart, R.id.tab_text_ucenter, R.id.tab_text_me, R.id.tv_shop_cart_point})//购物车小红点
            TextView[] mTextViews;

    @BindViews({R.id.main_home, R.id.main_zb, R.id.main_shop_cart, R.id.main_ucenter, R.id.main_me})
    RelativeLayout mRelativeLayout[];

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @BindView(R.id.main_tab)
    LinearLayout mainTab;
    private List<Fragment> mFragment = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = LayoutInflater.from(this).inflate(R.layout.home_activity, null);
        setContentView(root);
        ButterKnife.bind(this);
        //StatusBarUtil.setColor(this, colorSelect);


        root.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (bottom - oldBottom < -1) {
                    //软键盘弹上去了,动态设置高度为0
                    mainTab.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0));
                } else if (bottom - oldBottom > 1) {
                    mainTab.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                }
            }
        });
        initMainViewPager();

        initDialogData();

    }

    private void initDialogData() {

    }

    @Override
    public void onClick(View v) {
        if (R.id.main_home == v.getId()) {
            mViewPager.setCurrentItem(Constants.TAB_POSITION_HOME, false);
        } else if (R.id.main_zb == v.getId()) {
            mViewPager.setCurrentItem(Constants.TAB_POSITION_ZJ, false);
        } else if (R.id.main_shop_cart == v.getId()) {
            mViewPager.setCurrentItem(Constants.TAB_POSITION_PZ, false);
        } else if (R.id.main_ucenter == v.getId()) {
            mViewPager.setCurrentItem(Constants.TAB_POSITION_XX, false);
        } else if (R.id.main_me == v.getId()) {
            mViewPager.setCurrentItem(Constants.TAB_POSITION_ME, false);
        }
    }


    private void initMainViewPager() {
        mRelativeLayout[Constants.TAB_POSITION_HOME].setOnClickListener(this);
        mRelativeLayout[Constants.TAB_POSITION_ZJ].setOnClickListener(this);
        mRelativeLayout[Constants.TAB_POSITION_PZ].setOnClickListener(this);
        mRelativeLayout[Constants.TAB_POSITION_XX].setOnClickListener(this);
        mRelativeLayout[Constants.TAB_POSITION_ME].setOnClickListener(this);

        mFragment.add(new FirstFragment());
        mFragment.add(new SecondFragment());
        mFragment.add(new ThirdFragment());
        mFragment.add(new FourthFragment());
        mFragment.add(new FifthFragment());

        mViewPager.setAdapter(fragmentPagerAdapter);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.addOnPageChangeListener(this);
        changeTextViewColor();
        changeSelectedTabState(getIntent().getIntExtra(Constants.TAB_POSITION, 0));
        mViewPager.setCurrentItem(getIntent().getIntExtra(Constants.TAB_POSITION, 0), false);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //  dialog.dismiss();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Constants.LOGIN_RESULT_CODE) {

        }

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageSelected(int position) {

        // Logger.e(TAG,Constants.TAB_POSITION + AppCache.getTabPosition());
        changeTextViewColor();
        changeSelectedTabState(position);
    }

    private void changeTextViewColor() {
//        mImageViews[0].setBackgroundResource(R.drawable.tab_button_center);
        mTextViews[0].setTextColor(colorUnSelect);

//        mImageViews[1].setBackgroundResource(R.drawable.tab_button_center);
        mTextViews[1].setTextColor(colorUnSelect);

        mImageViews[2].setBackgroundResource(R.drawable.tab_button_center);
        mTextViews[2].setVisibility(View.GONE);

//        mImageViews[3].setBackgroundResource(R.drawable.tab_button_center);
        mTextViews[3].setTextColor(colorUnSelect);

        mTextViews[4].setTextColor(colorUnSelect);
    }

    private void changeSelectedTabState(int position) {
        Log.i(TAG, "changeSelectedTabState: " + position);
        if (position == 0) {
            mTextViews[0].setTextColor(colorSelect);
//             mImageViews[0].setBackgroundResource(R.drawable.tab_button_center);
        } else if (position == 1) {
            mTextViews[1].setTextColor(colorSelect);
//            mImageViews[1].setBackgroundResource(R.drawable.tab_button_center);
        } else if (position == 2) {
            mTextViews[2].setVisibility(View.GONE);
            mImageViews[2].setBackgroundResource(R.drawable.tab_button_center);
        } else if (position == 3) {
            mTextViews[3].setTextColor(colorSelect);
//            mImageViews[3].setBackgroundResource(R.drawable.tab_button_center);
        } else if (position == 4) {
            mTextViews[4].setTextColor(colorSelect);
//            mImageViews[3].setBackgroundResource(R.drawable.tab_button_center);
        }
    }

    private FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }
    };

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}