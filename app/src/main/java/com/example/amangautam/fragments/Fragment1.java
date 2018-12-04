package com.example.amangautam.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aman Gautam on 20-01-2018.
 */

public class Fragment1 extends android.support.v4.app.Fragment {
    RadioGroup  radioGroup;
    Button button;
    TextView textView;
    OnColorChangedListener onColorChangedListener;
    OnButtonClick onButtonClick;
   //String str;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment1,null);
      radioGroup = view.findViewById(R.id.radioColors);
      textView = view.findViewById(R.id.textf);
         radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 int id= radioGroup.getCheckedRadioButtonId();
                 //radioButton=radioButton.findViewById(id);
                 switch (id){
                     case R.id.radioRed:
                         onColorChangedListener.colorChanged("RED");
                         break;
                     case R.id.radioBlue:
                         onColorChangedListener.colorChanged("BLUE");
                         break;
                     case R.id.radioGreen:
                         onColorChangedListener.colorChanged("GREEN");
                         break;
                 }
             }
         });
      button = view.findViewById(R.id.bttn);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Activity activity = getActivity();
              if (activity != null) {
                  onButtonClick.display();
              }
          }
      });
      /*
       if (getArguments() != null) {
            str = getArguments().getString("message");
            textview.setText(str);
        }
       */
        return view;
    }

    interface OnColorChangedListener{
        void colorChanged(String color);
      }

      interface OnButtonClick{
        void display();
      }
  /*
  public void show(){
     textView.setText("Button is clicked in activity");
   */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onColorChangedListener=(OnColorChangedListener)activity;
        onButtonClick=(OnButtonClick) activity;
    }
}
