package myapplication.app1.scarnesdice4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Splaymed extends AppCompatActivity {

    Button back;
    Intent intent;
    TextView Ttop;
    TextView Tsec;
    TextView Tturn;
    ImageView Image1;
    ImageView Image2;
    Button Broll;
    Button Bhold;
    Button Breset;
    Button StartGame;
    int UserTurnScore = 0;
    int UserOverallScore = 0;
    int ComputerTurnScore = 0;
    int ComputerOverallScore = 0;
    int flag=0, CompNum1, CompNum2, ButtonEnable = 0,value1,value2;
    int[] Drawables = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splaymed);


        Ttop = (TextView) findViewById(R.id.text1);
        Tsec = (TextView) findViewById(R.id.text2);
        Tturn = (TextView) findViewById(R.id.text3);
        Image1 = (ImageView) findViewById(R.id.Img1);
        Image2 = (ImageView) findViewById(R.id.Img2);
        Broll = (Button) findViewById(R.id.Roll);
        Bhold = (Button) findViewById(R.id.Hold);
        Breset = (Button) findViewById(R.id.Reset);


        back = (Button) findViewById(R.id.Back3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Splaymed.this , MainActivity.class);
                startActivity(intent);
            }
        });
        Broll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Animation anim1 = AnimationUtils.loadAnimation(Splaymed.this,R.anim.shake);
                final Animation anim2 = AnimationUtils.loadAnimation(Splaymed.this,R.anim.shake);
                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override

                    public void onAnimationStart(Animation animation)
                    {

                    }

                    @Override

                    public void onAnimationEnd(Animation animation) {

                        value1 = RandomNum();
                         value2 = RandomNum();
                        if (animation==anim1) {
                            Image1.setImageResource(Drawables[value1 - 1]);
                            Image2.setImageResource(Drawables[value2 - 1]);
                            if ((value1 == 1) && (value2 == 1)) {
                                if (ButtonEnable == 1) {
                                    Bhold.setEnabled(true);
                                    UserTurnScore = 0;
                                    UserOverallScore = 0;
                                    Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                                    Tsec.setText("Your Turn Score : " + UserTurnScore);
                                    Tturn.setText("Oops!! You lose your turn and total score!!");
                                    ComputerScore();
                                } else {
                                    UserTurnScore = 0;
                                    UserOverallScore = 0;
                                    Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                                    Tsec.setText("Your Turn Score : " + UserTurnScore);
                                    Tturn.setText("Oops!! You lose your turn and total score!!");
                                    ComputerScore();
                                }

                            } else if ((value1 == 1) || (value2 == 1)) {
                                if (ButtonEnable == 1) {
                                    Bhold.setEnabled(true);
                                    UserTurnScore = 0;
                                    UserOverallScore += UserTurnScore;
                                    Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                                    Tsec.setText("Your Turn Score : " + UserTurnScore);
                                    Tturn.setText("Oops!! You lose your turn and turn score!!");
                                    ComputerScore();

                                } else {
                                    UserTurnScore = 0;
                                    UserOverallScore += UserTurnScore;
                                    Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                                    Tsec.setText("Your Turn Score : " + UserTurnScore);
                                    Tturn.setText("Oops!! You lose your turn and turn score!!");
                                    ComputerScore();
                                }
                            } else if (value1 == value2) {
                                ButtonEnable = 1;
                                UserTurnScore += value1 + value2;
                                Bhold.setEnabled(false);
                                Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                                Tsec.setText("Your Turn Score : " + UserTurnScore);
                                Tturn.setText("Roll the dice once more!!");

                            } else {
                                if (ButtonEnable == 1) {
                                    Bhold.setEnabled(true);
                                    UserTurnScore += value1 + value2;
                                    Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                                    Tsec.setText("Your Turn Score : " + UserTurnScore);
                                    Tturn.setText("ROLL or HOLD!!");

                                } else {
                                    UserTurnScore += value1 + value2;
                                    Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                                    Tsec.setText("Your Turn Score : " + UserTurnScore);
                                    Tturn.setText("ROLL or HOLD!!");
                                }
                            }
                        }

                    }

                    public void onAnimationRepeat(Animation animation)
                    {}};

                anim1.setAnimationListener(animationListener);
                anim2.setAnimationListener(animationListener);

                Image1.startAnimation(anim1);
                Image2.startAnimation(anim2);


            }
        });

        Bhold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserOverallScore += UserTurnScore;
                UserTurnScore = 0;
                Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                Tsec.setText("Your Turn Score : " + UserTurnScore);
                if (UserOverallScore < 100) {
                    ComputerScore();
                }
                else
                {
                    flag =1;
                    WinActivity(flag);
                }
            }
        });

        //on clicking reset
        Breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserOverallScore = 0;
                UserTurnScore = 0;
                ComputerOverallScore = 0;
                ComputerTurnScore = 0;
                Broll.setEnabled(false);
                Bhold.setEnabled(false);
                Breset.setEnabled(false);
                StartGame.setEnabled(true);
                Image1.setImageResource(Drawables[0]);
                Image2.setImageResource(Drawables[0]);
            }
        });


    }





    //Random number generation
    public int RandomNum() {
        int NumOnRoll = 1 + (int) (Math.random() * 5);
        return NumOnRoll;
    }


    public void ComputerScore()
    {

        Broll.setEnabled(true);
        Bhold.setEnabled(true);
        while (true)
        {
            CompNum1 = RandomNum();
            CompNum2 = RandomNum();

            if (ComputerTurnScore >= 10)
            {
                ComputerOverallScore+=ComputerTurnScore;
                ComputerTurnScore=0;
                Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                Tsec.setText("Your Turn Score : " + UserTurnScore);

                break;
            }
            if ((CompNum1 == 1) && (CompNum2 == 1))
            {
                ComputerOverallScore=0;
                ComputerTurnScore=0;
                Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                Tsec.setText("Your Turn Score : " + UserTurnScore);

                break;
            }
            else if ((CompNum1 == 1)||(CompNum2 == 1))
            {
                ComputerTurnScore = 0;
                Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                Tsec.setText("Your Turn Score : " + UserTurnScore);

                break;
            }
            else if (CompNum1==CompNum2)
            {

                ComputerScore();
            }
            else
            {
                ComputerTurnScore = ComputerTurnScore + CompNum2+CompNum1;
                Ttop.setText("Your Score : " + UserOverallScore + " Computer's Score : " + ComputerOverallScore);
                Tsec.setText("Your Turn Score : " + UserTurnScore);

            }
        }
        if (ComputerOverallScore>=100)
        {
            flag=2;
            WinActivity(flag);
        }

    }

    public void WinActivity(int value)
    {
        Intent intent = new Intent(Splaymed.this,Splayeasysc1.class);
        if (value==1)
        {
            intent.putExtra("Score","SMU");
            startActivity(intent);
        }
        else if(value==2)
        {
            intent.putExtra("Score","SMC");
            startActivity(intent);
        }
    }


}

