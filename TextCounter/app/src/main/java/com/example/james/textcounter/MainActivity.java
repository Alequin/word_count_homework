package com.example.james.textcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText enterText;
    private TextView outputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = (EditText) findViewById(R.id.enter_text_view_main_activity);
        outputView = (TextView) findViewById(R.id.output_view_main_activity);

    }

    public void onClickCountButton(View view){
        final String text = enterText.getText().toString();
        final int wordCount = WordCounter.count(text);
        outputView.setText(Integer.toString(wordCount));
    }

    public void onClickOccurrenceButton(View view){
        final String text = enterText.getText().toString();
        final HashMap<String, Integer> wordOccurrenceHash = WordCounter.getOccurrenceHash(text);
        final String wordOccurrenceText = WordCounter.formatOccurrenceHash(wordOccurrenceHash);
        outputView.setText(wordOccurrenceText);
    }
}
