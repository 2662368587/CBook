package com.example.czp.cookbook.base.ui;

import android.widget.Toast;

import com.example.czp.cookbook.mvp.presenter.BasePrenseter;
import com.example.czp.cookbook.mvp.view.BaseView;

/**
 * Created by chenzipeng on 2018/1/17.
 * function:
 */

public abstract class BaseMvpActivity<P extends BasePrenseter> extends
        BaseActivity implements BaseView {
    protected P mPresenter;

    @Override
    protected void initView() {
        mPresenter = injectPrenseter();
        mPresenter.attchView(this);
    }

    protected abstract P injectPrenseter();

    @Override
    public void showToast(String str) {
        Toast.makeText(getApplicationContext(), str+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
