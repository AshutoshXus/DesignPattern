package com.example.ashutosh.dagger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashutosh.EventBus.HelloWorldEvent;
import com.example.ashutosh.MyApplication;
import com.example.ashutosh.designpatterns.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;
import javax.inject.Named;



/**
 * Created by ashutosh on 18/2/16.
 */

/**
 * What object do you want?
 * Where do you want that object?
 * How will you provide or construct that object?
 */

public class DaggerActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject @Named("first")
    SharedPreferences mPreferences;
    @Inject @Named("second")
    SharedPreferences mPreferencesSecond;

    private EditText edInputText;
    private Button mBtnSave,mBtnRefresh;
    private TextView tvRefreshList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ((MyApplication)getApplication()).getComponent().inject(this);
        setContentView(R.layout.activity_dagger);
        edInputText = (EditText)findViewById(R.id.ed_text);
        mBtnSave = (Button)findViewById(R.id.btn_save);
        mBtnRefresh = (Button)findViewById(R.id.btn_refresh);
        tvRefreshList = (TextView)findViewById(R.id.tv_after);

        mBtnSave.setOnClickListener(this);
        mBtnRefresh.setOnClickListener(this);



    }

    @Override
    protected void onPause() {
        super.onPause();

        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void onResume() {
        super.onResume();

        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_save:

                String text = edInputText.getText().toString().trim();
                if (text != null && !text.isEmpty()) {
                    mPreferences.edit().putString(Keys.PREF_INPUT, text).apply();
                }

                break;

            case R.id.btn_refresh:

              /*  String event = "Hello Dagger";
                bus.post(event);*/
                String storedText = mPreferences.getString(Keys.PREF_INPUT, "Nothing found yet");
                tvRefreshList.setText(storedText);

                break;
        }

    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(HelloWorldEvent event){
        // your implementation
        Toast.makeText(DaggerActivity.this, event.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
