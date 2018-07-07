package com.example.windcore.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    TextView textview;
    Button button;
    EditText text;
    //TODO (1) create a sharedpreferences
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textview = (TextView) findViewById(R.id.textview);
        text = (EditText) findViewById(R.id.edittext);

        //TODO (2) use default or init yours --> getSharedPreferences(filename,mode)
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if(preferences.contains("first")){
            //TODO(4) get it out
            textview.setText(preferences.getString("first","noting"));
        }





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO (3) put it in
               preferences.edit().putString("first",text.getText().toString()).commit();
            }
        });

    }


}
