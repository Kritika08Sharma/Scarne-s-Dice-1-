package myapplication.app1.scarnesdice4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Seasy,Smed,Measy,Mmed;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Seasy = (Button) findViewById(R.id.Splayeasy);
        Smed = (Button) findViewById(R.id.Splaymod);
        Measy =(Button) findViewById(R.id.Mplayeasy);
        Mmed = (Button) findViewById(R.id.Mplaymod);
        Seasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,Splayeasy.class);
                startActivity(intent);
            }
        });

        Smed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,Splaymed.class);
                startActivity(intent);
            }
        });

        Measy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,Mplayeasy.class);
                startActivity(intent);
            }
        });

        Mmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,Mplaymed.class);
                startActivity(intent);
            }
        });


    }

}

