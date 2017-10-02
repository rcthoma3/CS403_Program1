package com.example.tacosv3.program01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by TacosV3 on 10/1/2017.
 */

public class Bio extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bio);

        Intent intent = getIntent();
        String BioString = intent.getStringExtra("Bio");

        ((TextView) findViewById(R.id.BioOutput)).setText(BioString);
    }
}
