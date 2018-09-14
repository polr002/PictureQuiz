package com.example.roy.picturequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private int[] imageNames;
    private int currentImageIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);

        imageNames = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3};



        //Prevbutton functionality
        Button prevBtn = findViewById(R.id.prevBtn);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex--;

                if (currentImageIndex <0) {
                    currentImageIndex = 2;
                }
                imageView.setImageResource(imageNames[currentImageIndex]);
            }
        });
        //Check button functionality
        Button checkBtn = findViewById(R.id.checkBtn);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int answerIndex = radioGroup.indexOfChild(radioButton);

                checkResult(answerIndex);

            }
        });
        //Next Button functionality
        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                currentImageIndex++;
                if (currentImageIndex >= imageNames.length) {
                    currentImageIndex = 0;
                }

                imageView.setImageResource(imageNames[currentImageIndex]);

            }
        });



    }
    private void checkResult(int answer) {
        String result;

        if (answer == currentImageIndex) {
            result = "Great!";

        } else {
            result = "Wrong";
        }
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();


    }
}
