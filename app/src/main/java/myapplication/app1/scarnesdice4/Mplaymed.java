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

import static android.R.attr.animation;

public class Mplaymed extends AppCompatActivity {

    Button back;
    Intent intent;
    TextView tv1,tv2,tv3,Tturn;

    ImageView Image1;
    ImageView Image2;
    Button Broll;
    Button Bhold;
    Button Breset;
    int User1TurnScore = 0;
    int User1OverallScore = 0;
    int User2TurnScore = 0;
    int User2OverallScore = 0;
    int flag=0, ButtonEnable = 0,value1,value2;
    int[] Drawables = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mplaymed);

        tv1 = (TextView) findViewById(R.id.MtextView1);
        tv2 = (TextView) findViewById(R.id.MtextView2);
        tv3 = (TextView) findViewById(R.id.MtextView3);
        Tturn = (TextView) findViewById(R.id.text3);
        Image1 = (ImageView) findViewById(R.id.Img1);
        Image2 = (ImageView) findViewById(R.id.Img2);
        Broll = (Button) findViewById(R.id.Roll);
        Bhold = (Button) findViewById(R.id.Hold);
        Breset = (Button) findViewById(R.id.Reset);


        back = (Button) findViewById(R.id.Back5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Mplaymed.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //on clicking reset
        Breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User1OverallScore = 0;
                User1TurnScore = 0;
                User2OverallScore = 0;
                User2TurnScore = 0;
                Broll.setEnabled(true);
                Bhold.setEnabled(true);
                Breset.setEnabled(true);
                Image1.setImageResource(Drawables[0]);
                Image2.setImageResource(Drawables[0]);
            }
        });


        User1Score();

    }

    public void User1Score()
    {
        Tturn.setText("Player1");
        Broll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Animation anim1 = AnimationUtils.loadAnimation(Mplaymed.this,R.anim.shake);
                final Animation anim2 = AnimationUtils.loadAnimation(Mplaymed.this,R.anim.shake);
                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override

                    public void onAnimationStart(Animation animation)
                    {

                    }

                    @Override

                    public void onAnimationEnd(Animation animation) {


                        value1 = RandomNum();
                value2 = RandomNum();
                        if(animation==anim1)
                        {
                Image1.setImageResource(Drawables[value1 - 1]);
                //Image2.setImageResource(Drawables[value2 - 1]);
                if ((value1 == 1) && (value2 == 1)) {
                    if (ButtonEnable == 1) {
                        Bhold.setEnabled(true);
                        User1TurnScore = 0;
                        User1OverallScore = 0;
                        Tturn.setText("Oops!! You lose your turn and total score!!");
                        User2Score();
                    } else {
                        User1TurnScore = 0;
                        User1OverallScore = 0;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);   Tturn.setText("Oops!! You lose your turn and total score!!");
                        User2Score();
                    }

                } else if ((value1 == 1) || (value2 == 1)) {
                    if (ButtonEnable == 1) {
                        Bhold.setEnabled(true);
                        User1TurnScore = 0;
                        User1OverallScore+=User1TurnScore;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);Tturn.setText("Oops!! You lose your turn and turn score!!");
                        User2Score();

                    } else {
                        User1TurnScore = 0;
                        User1OverallScore+=User1TurnScore;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);
                        Tturn.setText("Oops!! You lose your turn and turn score!!");
                        User2Score();
                    }
                } else if (value1 == value2) {
                    ButtonEnable = 1;
                    User1TurnScore += value1 + value2;
                    Bhold.setEnabled(false);
                    tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                    tv2.setText("Player1 Turn Score : " + User1TurnScore);
                    tv3.setText("Player2 Turn Score : "+User2TurnScore);Tturn.setText("Roll the dice once more!!");

                } else {
                    if (ButtonEnable == 1) {
                        Bhold.setEnabled(true);
                        User1TurnScore += value1 + value2;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);Tturn.setText("ROLL or HOLD!!");

                    } else {
                        User1TurnScore += value1 + value2;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);    Tturn.setText("ROLL or HOLD!!");
                    }
                }}
                        else
                        {
                            //Image2.setImageResource(Drawables[value2 - 1]);
                            if ((value1 == 1) && (value2 == 1)) {
                                if (ButtonEnable == 1) {
                                    Bhold.setEnabled(true);
                                    User1TurnScore = 0;
                                    User1OverallScore = 0;
                                    Tturn.setText("Oops!! You lose your turn and total score!!");
                                    User2Score();
                                } else {
                                    User1TurnScore = 0;
                                    User1OverallScore = 0;
                                    tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                                    tv2.setText("Player1 Turn Score : " + User1TurnScore);
                                    tv3.setText("Player2 Turn Score : "+User2TurnScore);   Tturn.setText("Oops!! You lose your turn and total score!!");
                                    User2Score();
                                }

                            } else if ((value1 == 1) || (value2 == 1)) {
                                if (ButtonEnable == 1) {
                                    Bhold.setEnabled(true);
                                    User1TurnScore = 0;
                                    User1OverallScore+=User1TurnScore;
                                    tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                                    tv2.setText("Player1 Turn Score : " + User1TurnScore);
                                    tv3.setText("Player2 Turn Score : "+User2TurnScore);Tturn.setText("Oops!! You lose your turn and turn score!!");
                                    User2Score();

                                } else {
                                    User1TurnScore = 0;
                                    User1OverallScore+=User1TurnScore;
                                    tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                                    tv2.setText("Player1 Turn Score : " + User1TurnScore);
                                    tv3.setText("Player2 Turn Score : "+User2TurnScore);
                                    Tturn.setText("Oops!! You lose your turn and turn score!!");
                                    User2Score();
                                }
                            } else if (value1 == value2) {
                                ButtonEnable = 1;
                                User1TurnScore += value1 + value2;
                                Bhold.setEnabled(false);
                                tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                                tv2.setText("Player1 Turn Score : " + User1TurnScore);
                                tv3.setText("Player2 Turn Score : "+User2TurnScore);Tturn.setText("Roll the dice once more!!");

                            } else {
                                if (ButtonEnable == 1) {
                                    Bhold.setEnabled(true);
                                    User1TurnScore += value1 + value2;
                                    tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                                    tv2.setText("Player1 Turn Score : " + User1TurnScore);
                                    tv3.setText("Player2 Turn Score : "+User2TurnScore);Tturn.setText("ROLL or HOLD!!");

                                } else {
                                    User1TurnScore += value1 + value2;
                                    tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                                    tv2.setText("Player1 Turn Score : " + User1TurnScore);
                                    tv3.setText("Player2 Turn Score : "+User2TurnScore);    Tturn.setText("ROLL or HOLD!!");
                                }
                            }}
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
                User1OverallScore += User1TurnScore;
                User1TurnScore = 0;
                tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                tv2.setText("Player1 Turn Score : " + User1TurnScore);
                tv3.setText("Player2 Turn Score : "+User2TurnScore);  if (User1OverallScore < 100) {
                    User2Score();
                }
                else
                {
                    flag =1;
                    WinActivity(flag);
                }
            }
        });



    }

    public void User2Score()
    {
        Tturn.setText("Player2");

        Broll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Animation anim1 = AnimationUtils.loadAnimation(Mplaymed.this,R.anim.shake);
                final Animation anim2 = AnimationUtils.loadAnimation(Mplaymed.this,R.anim.shake);

                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override

                    public void onAnimationStart(Animation animation)
                    {

                    }

                    @Override

                    public void onAnimationEnd(Animation animation) {


                        value1 = RandomNum();
                value2 = RandomNum();
                        if(animation==anim1)
                        {
                Image1.setImageResource(Drawables[value1 - 1]);
                Image2.setImageResource(Drawables[value2 - 1]);
                if ((value1 == 1) && (value2 == 1)) {
                    if (ButtonEnable == 1) {
                        Bhold.setEnabled(true);
                        User2TurnScore = 0;
                        User2OverallScore = 0;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);
                        Tturn.setText("Oops!! You lose your turn and total score!!");
                        User1Score();
                    } else {
                        User2TurnScore = 0;
                        User2OverallScore = 0;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);
                        Tturn.setText("Oops!! You lose your turn and total score!!");
                        User1Score();
                    }

                } else if ((value1 == 1) || (value2 == 1)) {
                    if (ButtonEnable == 1) {
                        Bhold.setEnabled(true);
                        User2TurnScore = 0;
                        User2OverallScore+=User2TurnScore;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);
                        Tturn.setText("Oops!! You lose your turn and turn score!!");
                        User1Score();

                    } else {
                        User2TurnScore = 0;
                        User2OverallScore+=User2TurnScore;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);
                        Tturn.setText("Oops!! You lose your turn and turn score!!");
                        User1Score();
                    }
                } else if (value1 == value2) {
                    ButtonEnable = 1;
                    User2TurnScore += value1 + value2;
                    Bhold.setEnabled(false);
                    tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                    tv2.setText("Player1 Turn Score : " + User1TurnScore);
                    tv3.setText("Player2 Turn Score : "+User2TurnScore);
                    Tturn.setText("Roll the dice once more!!");

                } else {
                    if (ButtonEnable == 1) {
                        Bhold.setEnabled(true);
                        User2TurnScore += value1 + value2;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);
                        Tturn.setText("ROLL or HOLD!!");

                    } else {
                        User2TurnScore += value1 + value2;
                        tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                        tv2.setText("Player1 Turn Score : " + User1TurnScore);
                        tv3.setText("Player2 Turn Score : "+User2TurnScore);
                        Tturn.setText("ROLL or HOLD!!");
                    }
                }}

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
                User2OverallScore += User2TurnScore;
                User2TurnScore = 0;
                tv1.setText("Player1 Score : " + User1OverallScore + "  Player2 Score : " + User2OverallScore);
                tv2.setText("Player1 Turn Score : " + User1TurnScore);
                tv3.setText("Player2 Turn Score : "+User2TurnScore);
                if (User2OverallScore < 100) {
                    User1Score();
                }
                else
                {
                    flag =1;
                    WinActivity(flag);
                }
            }
        });


    }





    //Random number generation
    public int RandomNum() {
        int NumOnRoll = 1 + (int) (Math.random() * 5);
        return NumOnRoll;
    }

    public void WinActivity(int value)
    {
        intent = new Intent(Mplaymed.this,Splayeasysc1.class);
        if (value==1)
        {

            intent.putExtra("Score","MMU");
            startActivity(intent);
        }
        else if(value==2)
        {
            intent.putExtra("Score","MMC");
            startActivity(intent);


        }
    }











}

