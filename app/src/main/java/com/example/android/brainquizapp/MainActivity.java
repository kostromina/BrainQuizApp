package com.example.android.brainquizapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String VALID_TAG_VALUE = "valid";
    private RadioGroup mQuestion1, mQuestion2, mQuestion3, mQuestion4, mQuestion5, mQuestion6,
            mQuestion7, mQuestion8, mQuestion9;
    private EditText customerNameEditText;
    private CheckBox mQuestion10a;
    private CheckBox mQuestion10b;
    private CheckBox mQuestion10c;
    private CheckBox mQuestion10d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView() {
        final Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonPressed();
            }
        });

        mQuestion1 = (RadioGroup) findViewById(R.id.answer_to_question_1);
        mQuestion2 = (RadioGroup) findViewById(R.id.answer_to_question_2);
        mQuestion3 = (RadioGroup) findViewById(R.id.answer_to_question_3);
        mQuestion4 = (RadioGroup) findViewById(R.id.answer_to_question_4);
        mQuestion5 = (RadioGroup) findViewById(R.id.answer_to_question_5);
        mQuestion6 = (RadioGroup) findViewById(R.id.answer_to_question_6);
        mQuestion7 = (RadioGroup) findViewById(R.id.answer_to_question_7);
        mQuestion8 = (RadioGroup) findViewById(R.id.answer_to_question_8);
        mQuestion9 = (RadioGroup) findViewById(R.id.answer_to_question_9);

        mQuestion10a = (CheckBox) findViewById(R.id.answer_10a);
        mQuestion10b = (CheckBox) findViewById(R.id.answer_10b);
        mQuestion10c = (CheckBox) findViewById(R.id.answer_10c);
        mQuestion10d = (CheckBox) findViewById(R.id.answer_10d);

        customerNameEditText = (EditText) findViewById(R.id.answer_11);
    }

    private void submitButtonPressed() {
        int mResult = 0;
        if (mQuestion1.getCheckedRadioButtonId() == R.id.answer_1a) {
            mResult += 10;
        } else if (mQuestion1.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion2.getCheckedRadioButtonId() == R.id.answer_2c) {
            mResult += 10;
        } else if (mQuestion2.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion3.getCheckedRadioButtonId() == R.id.answer_3b) {
            mResult += 10;
        } else if (mQuestion3.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion4.getCheckedRadioButtonId() == R.id.answer_4a) {
            mResult += 10;
        } else if (mQuestion4.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion5.getCheckedRadioButtonId() == R.id.answer_5b) {
            mResult += 10;
        } else if (mQuestion5.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion6.getCheckedRadioButtonId() == R.id.answer_6c) {
            mResult += 10;
        } else if (mQuestion6.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion7.getCheckedRadioButtonId() == R.id.answer_7c) {
            mResult += 10;
        } else if (mQuestion7.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion8.getCheckedRadioButtonId() == R.id.answer_8a) {
            mResult += 10;
        } else if (mQuestion8.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion9.getCheckedRadioButtonId() == R.id.answer_9a) {
            mResult += 10;
        } else if (mQuestion9.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (mQuestion10a.isChecked() == false && mQuestion10b.isChecked() == false &&
                mQuestion10c.isChecked() == false && mQuestion10d.isChecked() == false) {
            showError();
            return;
        }

        if (mQuestion10a.isChecked()) {
            mResult += 5;
        }
        if (mQuestion10c.isChecked()) {
            mResult += 5;
        }

        if (customerNameEditText.getText().toString().isEmpty()) {
            showError();
            return;
        }


        displayMessage(mResult);
    }

    void displayMessage(int score) {
        String userName = customerNameEditText.getText().toString();
        String message = "Dear " + userName + ",\nYour score is: " + String.valueOf(score) + " ofÅ 100";
        message += "\n" + quizResultMessage(score);

        new AlertDialog.Builder(this).setMessage(message).show();
    }

    String quizResultMessage(int score) {
        if (score <= 40) {
            return getString(R.string.result_0_40);
        } else if (score > 40 && score <= 60) {
            return getString(R.string.result_50_60);
        } else if (score > 60 && score <= 90) {
            return getString(R.string.result_70_90);
        } else {
            return getString(R.string.result_90_100);
        }
    }

    void showError() {
        // Show an error message as a toast
        Toast.makeText(this, "Please select answers to all questions.", Toast.LENGTH_SHORT).show();
    }
}
