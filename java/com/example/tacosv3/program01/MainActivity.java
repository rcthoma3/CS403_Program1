package com.example.tacosv3.program01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> spinnerArray = new ArrayList<String>();
        for (int i=17; i >= 10; i--)
        {
            spinnerArray.add("20" + i);
        }
        for (int i=9; i >= 0; i--)
        {
            spinnerArray.add("200" + i);
        }
        for (int i=99; i >= 10; i--)
        {
            spinnerArray.add("19" + i);
        }
        for (int i=9; i >= 0; i--)
        {
            spinnerArray.add("190" + i);
        }

        Spinner YearSpinner = (Spinner) findViewById(R.id.YearInput);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        YearSpinner.setAdapter(yearAdapter);
    }


    public void submitBio(View view) {
        String BioString = buildBioString();
        Intent submitIntent = new Intent(this, Bio.class);
        submitIntent.putExtra("Bio", BioString);
        startActivity(submitIntent);

    }

    public String buildBioString() {
        String BioString = "";
        BioString += ((EditText) findViewById(R.id.FNameInput)).getText() + " " +
                ((EditText) findViewById(R.id.LNameInput)).getText() + " holds a " +
                ((Spinner) findViewById(R.id.DegreeInput)).getSelectedItem().toString() + " in " +
                ((EditText) findViewById(R.id.MajorInput)).getText() + " from " +
                ((EditText) findViewById(R.id.SchoolInput)).getText() + ", and graduated in " +
                ((Spinner) findViewById(R.id.YearInput)).getSelectedItem().toString() + ".";
        if (((Switch) findViewById(R.id.SwitchInput)).isChecked())
            BioString += " " + ((EditText) findViewById(R.id.ActivitiesInput)).getText() + ".";
        return BioString;
    }
}
