/*
 * Copyright (C) 2016 MrWasdennnoch
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tk.wasdennnoch.progresstoolbar.sample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import tk.wasdennnoch.progresstoolbar.ProgressToolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private ProgressToolbar mProgressToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mProgressToolbar);

        findViewById(R.id.determinate).setOnClickListener(this);
        findViewById(R.id.indeterminate).setOnClickListener(this);
        findViewById(R.id.top).setOnClickListener(this);
        findViewById(R.id.bottom).setOnClickListener(this);
        findViewById(R.id.show).setOnClickListener(this);
        findViewById(R.id.hide).setOnClickListener(this);
        findViewById(R.id.demo).setOnClickListener(this);
        ((SeekBar) findViewById(R.id.progress)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.height)).setOnSeekBarChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Cheap and dirty
        menu.add("Github")
                .setIcon(R.drawable.ic_github)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://github.com/wasdennnoch/ProgressToolbar")));
                        return true;
                    }
                })
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add("Item").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.determinate:
                mProgressToolbar.setIndeterminate(false);
                break;
            case R.id.indeterminate:
                mProgressToolbar.setIndeterminate(true);
                break;
            case R.id.top:
                mProgressToolbar.setProgressAtTop(true);
                break;
            case R.id.bottom:
                mProgressToolbar.setProgressAtTop(false);
                break;
            case R.id.show:
                mProgressToolbar.showProgress(true);
                break;
            case R.id.hide:
                mProgressToolbar.hideProgress(true);
                break;
            case R.id.demo:
                mProgressToolbar.hideProgress();
                mProgressToolbar.setIndeterminate(true);
                mProgressToolbar.showProgress(true);
                mProgressToolbar.postDelayed(mStartDemoRunnable, 2000);
                break;
        }
    }

    private void startDemo() {
        final ValueAnimator anim = ValueAnimator.ofInt(0, 500).setDuration(3000);
        anim.setInterpolator(new FastOutLinearInInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgressToolbar.setProgress((int) animation.getAnimatedValue());
            }
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mProgressToolbar.setIndeterminate(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressToolbar.hideProgress(true);
            }
        });
        anim.start();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.progress:
                mProgressToolbar.setProgress(progress);
                break;
            case R.id.height:
                mProgressToolbar.setProgressHeight((int) (progress * getResources().getDisplayMetrics().density));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    private final Runnable mStartDemoRunnable = new Runnable() {
        @Override
        public void run() {
            startDemo();
        }
    };

}
