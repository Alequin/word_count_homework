package com.example.james.textcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText enterTest = (EditText) findViewById(R.id.enter_text_view_main_activity);
        final Button countButton = (Button) findViewById(R.id.count_button_main_activity);
        final TextView outputView = (TextView) findViewById(R.id.output_view_main_activity);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String text = enterTest.getText().toString();
                final int wordCount = WordCounter.count(text);
                outputView.setText(Integer.toString(wordCount));
            }
        });
    }
}
