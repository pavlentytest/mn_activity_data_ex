package ru.samsung.itschool.mdev.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btn, btn2;
    public static final String KEY = "test";

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == MainActivity2.RCODE) {
                  //  Toast.makeText(getApplicationContext(),
                   //                 result.getData().getStringExtra(MainActivity2.KEY2),
                   //                 Toast.LENGTH_LONG).show();
                    Snackbar.make(findViewById(R.id.root),
                                 result.getData().getStringExtra(MainActivity2.KEY2),
                                    Snackbar.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn.setOnClickListener(view -> {
            // неявное намерение
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String url = "https://mirea.ru";
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
     /*   btn2.setOnClickListener(view -> {
            // явное намерение
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });*/

        btn2.setOnClickListener(view -> makeSmth());
    }

    public void makeSmth() {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("test","Hello from MainActivity!");
        //startActivity(intent);
        launcher.launch(intent);
    }


}