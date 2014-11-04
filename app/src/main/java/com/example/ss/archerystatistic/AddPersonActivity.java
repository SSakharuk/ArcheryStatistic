package com.example.ss.archerystatistic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.ss.archerystatistic.util.ValidationHelper;

import java.util.Date;


public class AddPersonActivity extends BaseActivity {

    protected ValidationHelper validationHelper;
    private EditText textName;
    private EditText textAge;
    private EditText textEmail;
    private Button btnAddPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        textName = (EditText)findViewById(R.id.textName);
        textAge = (EditText)findViewById(R.id.textAge);
        textEmail = (EditText)findViewById(R.id.textEmail);
        btnAddPerson = (Button) findViewById(R.id.buttonAddPerson);

        validationHelper = new ValidationHelper(this);

        registerViews();
    }

    private void registerViews() {

        textName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                validationHelper.hasText(textName);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}

        });

        textEmail.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                validationHelper.isEmailAddress(textEmail, false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        textAge.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                validationHelper.hasText(textAge);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}

        });

        btnAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( checkValidation () )
                    submitForm();
                else
                    Toast.makeText(AddPersonActivity.this, "Form contains error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void submitForm() {
        // Submit your form here. your form is valid
        Toast.makeText(this, "Submitting form...", Toast.LENGTH_LONG).show();
        dataSource.createPerson(textName.getText().toString().trim(), Integer.parseInt(textAge.getText().toString()), textEmail.getText().toString(), new Date(), new Date());
        setResult(RESULT_OK);
        finish();
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!validationHelper.hasText(textName)) {
            ret = false;
        }
        if (!validationHelper.hasText(textAge)) {
            ret = false;
        }
        if (!validationHelper.isEmailAddress(textEmail, false)) {
            ret = false;
        }

        return ret;
    }
}
