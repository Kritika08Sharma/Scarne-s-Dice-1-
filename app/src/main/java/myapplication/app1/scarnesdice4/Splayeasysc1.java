package myapplication.app1.scarnesdice4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Splayeasysc1 extends AppCompatActivity {

    TextView text1;
    String score1;
    View v1;
    Button button;
    Button Home;
    Intent intent;
    Intent intent1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splayeasysc1);

        Bundle bundle = getIntent().getExtras();
        text1 = (TextView) findViewById(R.id.WinScreen);
        score1 =(bundle.getString("Score"));
        View v1 = (View) findViewById(R.id.AppScreen);

        button = (Button) findViewById(R.id.Button1);
        Home = (Button) findViewById(R.id.Home);
        if ((score1.equals("MEC"))||(score1.equals("MMC")) )
        {
            text1.setText("Player1 Wins!!");
        }
        else if((score1.equals("SEC"))||(score1.equals("SMC")))
        {
            text1.setText("OOPS.. YOU LOSE..!! BETTER LUCK NEXT TIME..!!");
        }
        else
        {
            if ((score1.equals("MEU"))||(score1.equals("MMU")))
            {
                text1.setText("Player2 Wins!!");
            }
            //v1.setBackgroundResource(R.drawable.cracker);
            else
            {
                text1.setText("Congratulations..!! You win..!!");
            }
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((score1.equals("SEC"))||(score1.equals("SEU")))
                {
                    Intent intent = new Intent(Splayeasysc1.this,Splayeasy.class);
                    startActivity(intent);


                }
                else if ((score1.equals("SMC"))||(score1.equals("SMU")))
                {
                    Intent intent = new Intent(Splayeasysc1.this,Splaymed.class);
                    startActivity(intent);
                }
                else if((score1.equals("MEC"))||(score1.equals("MEU")))
                {
                    Intent intent = new Intent(Splayeasysc1.this,Mplayeasy.class);
                    startActivity(intent);

                }
                else if((score1.equals("MMC"))||(score1.equals("MMU")))
                {
                    Intent intent = new Intent(Splayeasysc1.this,Mplaymed.class);
                    startActivity(intent);

                }
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Func1();
            }
        });
    }

    public void Func1()
    {
        Intent intent1 = new Intent(Splayeasysc1.this,MainActivity.class);
        startActivity(intent1);
    }

}
