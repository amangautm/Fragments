package com.example.amangautam.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnColorChangedListener,Fragment1.OnButtonClick {
    Fragment1 fragment1;
    LinearLayout linearLayout;
    TextView tv,tvf;
    Button button;
    //OnButtonPress onButtonPress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.text1);
        tvf = findViewById(R.id.textf);
        linearLayout = findViewById(R.id.fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment1 = new Fragment1();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, fragment1);
        fragmentTransaction.commit();

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Bundle bundle = new Bundle();
                   bundle.putString("message", "Buttonn clicked in activity");
                 Fragment1 frag = new Fragment1();
                  frag.setArguments(bundle);
                 */
                Toast.makeText(MainActivity.this, "Button clicked in activity", Toast.LENGTH_SHORT).show();
                // onButtonPress.show();
            }
        });
    }
    @Override
    public void colorChanged(String color) {
            if (color == "RED") {
                linearLayout.setBackgroundColor(Color.RED);
            } else if (color == "BLUE") {
                linearLayout.setBackgroundColor(Color.BLUE);
            } else if(color == "GREEN"){
                linearLayout.setBackgroundColor(Color.GREEN);
            }


    }
    /*
    interface OnButtonPress{
          void show();
          }
     */
    @Override
    public void display()
    {
       tv.setText("Button is clicked in fragment");
    }
}


