package com.cnoi.boulfaf;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Mboulfafity extends AppCompatActivity implements View.OnClickListener {
    ImageView iboulfafm1;
    ImageView iboulfafm2;
    ImageView imboulfaf3;
    ImageView imboulfaf4;
    ImageView imboulfaf5;
    ImageView imboulfaf6;
    ImageView imboulfaf7;
    ImageView imboulfaf8;
    ImageView temboulfafp1;
    ImageView temboulfafp2;
    ImageView nowCboulfaflicked;
    int cardboulfafsOpen = 0;
    boolean animStopboulfafped = true;
    boolean restartCboulfaflicked;
    int[] carboulfafds = {R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmboulfafy_game);
        iboulfafm1 = findViewById(R.id.imageView1);
        iboulfafm2 = findViewById(R.id.imageView2);
        imboulfaf3 = findViewById(R.id.imageView3);
        imboulfaf4 = findViewById(R.id.imageView4);
        imboulfaf5 = findViewById(R.id.imageView5);
        imboulfaf6 = findViewById(R.id.imageView6);
        imboulfaf7 = findViewById(R.id.imageView7);
        imboulfaf8 = findViewById(R.id.imageView8);
        iboulfafm1.setOnClickListener(this);
        iboulfafm2.setOnClickListener(this);
        imboulfaf3.setOnClickListener(this);
        imboulfaf4.setOnClickListener(this);
        imboulfaf5.setOnClickListener(this);
        imboulfaf6.setOnClickListener(this);
        imboulfaf7.setOnClickListener(this);
        imboulfaf8.setOnClickListener(this);
        carboulfafds = rboulfafand(carboulfafds);
    }


    @Override
    public void onClick(View view) {
        int cardNumb = 0;
        switch (view.getId()) {
            case R.id.imageView1:
                cardNumb = 0;
                break;
            case R.id.imageView2:
                cardNumb = 1;
                break;
            case R.id.imageView3:
                cardNumb = 2;
                break;
            case R.id.imageView4:
                cardNumb = 3;
                break;
            case R.id.imageView5:
                cardNumb = 4;
                break;
            case R.id.imageView6:
                cardNumb = 5;
                break;
            case R.id.imageView7:
                cardNumb = 6;
                break;
            case R.id.imageView8:
                cardNumb = 7;
                break;
        }
        if (view != nowCboulfaflicked) {
            if (animStopboulfafped) {
                if (cardboulfafsOpen == 0) {
                    temboulfafp1 = (ImageView) view;
                }
                if (cardboulfafsOpen == 1) {
                    temboulfafp2 = (ImageView) view;
                }
                if (cardboulfafsOpen < 2) {
                    cardboulfafsOpen++;
                    view.setTag(carboulfafds[cardNumb]);
                    startFliboulfafpAnimation((ImageView) view, carboulfafds[cardNumb]);
                }
            }
        }
    }

    void startFliboulfafpAnimation(ImageView imageboulfafView, int resboulfafId) {
        animStopboulfafped = false;
        ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.flipboulfafping);
        anim.setTarget(imageboulfafView);
        anim.setDuration(500);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                imageboulfafView.setImageResource(resboulfafId);
                endFliboulfafpAnimation(imageboulfafView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        anim.start();
    }


    void endFliboulfafpAnimation(ImageView imagboulfafeView) {
        ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.flippboulfafing_end);
        anim.setTarget(imagboulfafeView);
        anim.setDuration(500);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                nowCboulfaflicked = imagboulfafeView;
                if (temboulfafp2 != null) {
                    if (temboulfafp1.getTag().equals(temboulfafp2.getTag())) {
                        temboulfafp1 = null;
                        temboulfafp2 = null;
                        cardboulfafsOpen = 0;
                        animStopboulfafped = true;
                    } else {
                        if (cardboulfafsOpen == 2) {
                            animStopboulfafped = false;
                            startCloseAnimaboulfaftion(temboulfafp1);
                            temboulfafp1 = null;
                            startCloseAnimaboulfaftion(temboulfafp2);
                            temboulfafp2 = null;
                            cardboulfafsOpen = 0;
                        }
                    }
                } else if (cardboulfafsOpen == 1)
                    animStopboulfafped = true;
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        anim.start();
    }


    void startCloseAnimaboulfaftion(ImageView iboulfafmageView) {
        ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.flipping_cboulfaflose_start);
        anim.setTarget(iboulfafmageView);
        anim.setDuration(500);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                iboulfafmageView.setImageResource(R.drawable.slot);
                ObjectAnimator animEnd = (ObjectAnimator) AnimatorInflater.loadAnimator(getBaseContext(), R.animator.flipping_cloboulfafse_end);
                animEnd.setTarget(iboulfafmageView);
                animEnd.setDuration(500);
                animEnd.start();
                animStopboulfafped = true;

                if (iboulfafmageView == imboulfaf8 && restartCboulfaflicked) {
                    cardboulfafsOpen = 0;
                    temboulfafp1 = null;
                    temboulfafp2 = null;
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        anim.start();
    }


    static int[] rboulfafand(int array[]) {
        Random rd = new Random();
        int a = array.length - 1;
        for (int i = a - 1; i > 0; i--) {
            int j = rd.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    public void restaboulfafrtGame(View view) {
        startCloseAnimaboulfaftion(iboulfafm1);
        startCloseAnimaboulfaftion(iboulfafm2);
        startCloseAnimaboulfaftion(imboulfaf3);
        startCloseAnimaboulfaftion(imboulfaf4);
        startCloseAnimaboulfaftion(imboulfaf5);
        startCloseAnimaboulfaftion(imboulfaf6);
        startCloseAnimaboulfaftion(imboulfaf7);
        startCloseAnimaboulfaftion(imboulfaf8);
        restartCboulfaflicked = true;
    }

    public void fliboulfafp(View view) {
        startActivity(new Intent(this, Mboulfafity.class));
        finish();
    }

    public void rexitrtGame(View view) {
        finish();
    }
}