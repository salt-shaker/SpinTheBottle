package com.e.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button spinBtn;
    View iv_bottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinBtn = findViewById(R.id.spinBtn);
        iv_bottle = findViewById(R.id.iv_bottle);

        spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int theSpinDegrees;
                Random r = new Random();

                theSpinDegrees = r.nextInt(3600);

                RotateAnimation rotateBottle = new RotateAnimation(0, theSpinDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);

                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(theSpinDegrees % 360 > 0 && theSpinDegrees % 360 < 89){
                            Toast.makeText(MainActivity.this, "NE has been choosen!", Toast.LENGTH_SHORT).show();
                        } else if(theSpinDegrees % 360 > 90 && theSpinDegrees % 360 < 179) {
                            Toast.makeText(MainActivity.this, "SE has been choosen!", Toast.LENGTH_SHORT).show();
                        } else if(theSpinDegrees % 360 > 180 && theSpinDegrees % 360 < 269) {
                            Toast.makeText(MainActivity.this, "SW has been choosen!", Toast.LENGTH_SHORT).show();
                        } else if(theSpinDegrees % 360 > 270 && theSpinDegrees % 360 < 360) {
                            Toast.makeText(MainActivity.this, "NW has been choosen!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                iv_bottle.startAnimation(rotateBottle);
            }
        });
    }
}
