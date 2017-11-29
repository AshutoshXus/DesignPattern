package com.example.ashutosh.designpatterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ashutosh.EventBus.HelloWorldEvent;
import com.example.ashutosh.dagger.DaggerActivity;

import org.greenrobot.eventbus.EventBus;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().postSticky(new HelloWorldEvent("Hello world"));
    }


    public void onBuilderClick(View btn)
    {

        Intent i = new Intent(this,BuilderDesignPatterns.class);
        startActivity(i);

    }

    public void onDaggerClick(View btn)
    {

        Intent i = new Intent(this,DaggerActivity.class);
        startActivity(i);

    }
}
