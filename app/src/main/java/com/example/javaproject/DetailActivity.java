package com.example.javaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.javaproject.model.Member;
import com.example.javaproject.model.User;

public class DetailActivity extends AppCompatActivity {
    static final String TAG = DetailActivity.class.toString();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
    }

    void initViews() {
        TextView text = findViewById(R.id.detail);
        Button b_exit = findViewById(R.id.b_exit);
        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member=new Member("Ali",31);
                back(member);
            }
        });
        User user = (User) getIntent().getSerializableExtra("user");

        text.setText(user.toString());
    }

    void back(Member member) {
        Intent intent=new Intent();
        intent.putExtra("member",member);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

}
