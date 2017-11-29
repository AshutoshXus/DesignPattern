package com.example.ashutosh.designpatterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ashutosh on 18/2/16.
 */
public class BuilderDesignPatterns extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_build_pattern);

        TextView tvUserInfo = (TextView)findViewById(R.id.tvUserDetails);

        User user;
        try {

             user = new User.UserBuilder("Jhon","Doe")
                    .age(50)
                    .phone("9716385999")
                    .address("Parathe wali gali")
                    .build();

            tvUserInfo.setText(user.toString());
        }
        catch (IllegalStateException e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }








    }
}
