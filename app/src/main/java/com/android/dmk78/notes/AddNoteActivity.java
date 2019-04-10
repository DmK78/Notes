package com.android.dmk78.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import static com.android.dmk78.notes.MainActivity.notes;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDayOfWeek;
    private RadioGroup radioGroupPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle=findViewById(R.id.editTextTitle);
        editTextDescription=findViewById(R.id.editTextDescription);
        spinnerDayOfWeek=findViewById(R.id.spinnerDayOfWeek);
        radioGroupPriority=findViewById(R.id.radioGroupPriority);

    }

    public void onClickSaveNote(View view) {

        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String dayOfWeek = spinnerDayOfWeek.getSelectedItem().toString();
        int radioButtonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        int priority = Integer.parseInt(radioButton.getText().toString());


        notes.add(new Note(title,description,dayOfWeek,priority));

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }


}
