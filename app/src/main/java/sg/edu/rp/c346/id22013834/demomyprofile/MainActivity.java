package sg.edu.rp.c346.id22013834.demomyprofile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);

        sharedPreferences = getSharedPreferences("MyProfile", MODE_PRIVATE);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Get the user input from the EditText and store it in variables
        String name = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        // Obtain an instance of the SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyProfile", MODE_PRIVATE);

        // Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Add the key-value pairs
        editor.putString("name", name);
        editor.putFloat("gpa", gpa);

        // Call apply() to save the changes into SharedPreferences
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Obtain an instance of the SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyProfile", MODE_PRIVATE);

        // Retrieve the saved data from the SharedPreferences object
        String name = sharedPreferences.getString("name", "John");
        float gpa = sharedPreferences.getFloat("gpa", 4.0f);

        // Update the UI elements with the retrieved values
        etName.setText(name);
        etGPA.setText(String.valueOf(gpa));
    }
}