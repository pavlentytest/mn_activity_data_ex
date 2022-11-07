package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv2;
    private Button btn;
    public static final String KEY2 = "ttt";
    public static final int RCODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv2 = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            tv2.setText(bundle.getString(MainActivity.KEY));
        }
        btn = findViewById(R.id.button3);
        btn.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(KEY2,"Data from MainActivity2!");
            setResult(RCODE,intent);
            finish();
        });
    }
}