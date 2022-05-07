package com.example.javaproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.javaproject.model.Member;
import com.example.javaproject.model.User;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.toString();
    int Launch_detail = 101;
    TextView t_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    ActivityResultLauncher<Intent> detailL = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent date=result.getData();
                        Member text= (Member) date.getSerializableExtra("member");
                        t_home.setText(text.toString());
                    }
                }
            });

    void initViews() {
        t_home = findViewById(R.id.t_home);
        Button open = findViewById(R.id.open_detail);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("Otabek", 21);
                openDetailActivity(user);
            }
        });


    }

    void openDetailActivity(User user) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("user", user);
        detailL.launch(intent);
    }
}