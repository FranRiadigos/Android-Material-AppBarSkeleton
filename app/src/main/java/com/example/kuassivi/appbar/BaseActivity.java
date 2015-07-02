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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

public class BaseActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener {
    private boolean displayHomeAsUp = true;

    protected void navigateTo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    protected void toggleMenu() {
        getSupportActionBar().setDisplayHomeAsUpEnabled((displayHomeAsUp = !displayHomeAsUp));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if ((int) parent.getTag() != position)
            switch (position) {
                case Constants.AppBarStyles.DEFAULT:
                    navigateTo(AppBarDefaultActivity.class);
                    break;
                case Constants.AppBarStyles.EXTENDED:
                    navigateTo(AppBarExtendedActivity.class);
                    break;
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
