package com.example.ss.archerystatistic.util;


import android.content.Context;
import android.widget.EditText;
import com.example.ss.archerystatistic.R;
import java.util.regex.Pattern;

/**
 * Created by SS on 04.11.2014.
 */
public class ValidationHelper {

    private final String REQUIRED_MSG;
    private final String EMAIL_MSG;
    public ValidationHelper(Context context) {

        REQUIRED_MSG = context.getResources().getString(R.string.validation_required_field);
        EMAIL_MSG = context.getResources().getString(R.string.validation_invalid_email);
        }

    private final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean isEmailAddress(EditText editText, boolean required) {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if ( required && !hasText(editText) ) {
            return false;
        }

        // pattern doesn't match so returning false
        if (!text.matches("") && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }
}
