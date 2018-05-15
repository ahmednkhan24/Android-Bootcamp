package com.example.faraz.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView leftDice = (ImageView)findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView)findViewById(R.id.image_rightDice);

        final Random randNumGen = new Random();

        final int[] diceArr = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        Button rollButton = (Button)findViewById(R.id.rollButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randNum = randNumGen.nextInt(6);
                leftDice.setImageResource(diceArr[randNum]);

                randNum = randNumGen.nextInt(6);
                rightDice.setImageResource(diceArr[randNum]);
            }
        });
    }
}
