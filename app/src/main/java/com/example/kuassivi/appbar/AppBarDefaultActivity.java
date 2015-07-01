/*
 * Copyright (C) 2015 Kiko Gonzalez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.kuassivi.appbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * The purpose of this Demo App is to have different skeletons reusable of AppBar styles.
 * So you can access to many features of an AppBar style on each Activity class.
 */
public class AppBarDefaultActivity extends BaseActivity {
    private View mContent;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_default);
        initToolbar();
        setupMainContent();
        initDropDownAdapter();
    }

    /**
     * We don't want to refactor this method because of general purpose
     */
    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setDisplayHomeAsUpEnabled();
    }

    /**
     * We need the R.id.content View to apply Snackbar on it
     */
    private void setupMainContent() {
        mContent = findViewById(R.id.content);
    }

    /**
     * Now we can select different AppBar Styles to show
     */
    private void initDropDownAdapter() {
        //Appbar page filter
        Spinner appbarFilter = (Spinner) findViewById(R.id.appbar_filter);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            getSupportActionBar().getThemedContext(),
            R.layout.appbar_filter_title,
            getResources().getStringArray(R.array.filter_appbar_styles));
        adapter.setDropDownViewResource(R.layout.appbar_filter_list);
        appbarFilter.setAdapter(adapter);
        appbarFilter.setSelection(Constants.AppBarStyles.DEFAULT);
        appbarFilter.setTag(appbarFilter.getSelectedItemPosition());
        appbarFilter.setOnItemSelectedListener((BaseActivity) this);
    }

    /**
     * This just show the left icon menu on toolbar.
     * It will be handled by onOptionsItemSelected method.
     */
    private void setDisplayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar_default, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        switch (item.getItemId()) {
            case android.R.id.home:
                Snackbar.make(mContent, R.string.snackbar_sample, Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.action_toggle_icon_menu:
                toggleMenu();
                return true;
            case R.id.action_toolbar_none:
                params.setScrollFlags(0);
                mToolbar.setLayoutParams(params);
                return true;
            case R.id.action_toolbar_scroll:
                params.setScrollFlags(
                    AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                mToolbar.setLayoutParams(params);
                return true;
            case R.id.action_toolbar_scroll_enter_always:
                params.setScrollFlags(
                    AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
                mToolbar.setLayoutParams(params);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
