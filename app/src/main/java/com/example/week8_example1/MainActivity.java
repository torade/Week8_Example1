package com.example.week8_example1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText textInput;
    private TextView textOutput;
    private int fontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textInput = findViewById(R.id.inputTextField);
        textOutput = findViewById(R.id.outputTextField);
        fontSize = 14;

    }

    public void transformText(View view)
    {
        System.out.println(textInput.getText());

        StringBuilder sb = new StringBuilder(textInput.getText().toString());
        sb.reverse();

        // TOAST!!!
        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();


        textOutput.setText(sb.toString());
    }

    public void increaseTextSize(View view)
    {

        textOutput.setTextSize(++fontSize);
    }
    public void decreaseTextSize(View view)
    {
        textOutput.setTextSize(--fontSize);
    }
}