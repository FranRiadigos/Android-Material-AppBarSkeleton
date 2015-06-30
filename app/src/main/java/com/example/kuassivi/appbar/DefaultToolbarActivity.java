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
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * The purpose of this Demo App is to have different skeletons for different toolbar styles.
 * So each toolbar style will have its own Activity Class to separate features.
 */
public class DefaultToolbarActivity extends AppCompatActivity {

    private View mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Installed apps use the label of the main activity as the name of the app.
        // So we are ensuring that this activity has its proper Toolbar title.
        setTitle(R.string.activity_app_bar_default);
        setContentView(R.layout.activity_toolbar_default);
        initToolbar();
        setupViews();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled();
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

    /**
     * We need the R.id.content View to apply Snackbar on it
     */
    private void setupViews() {
        mContent = findViewById(R.id.content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar_default, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
            case R.id.action_show_others:
                Snackbar.make(mContent, R.string.coming_soon, Snackbar.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
