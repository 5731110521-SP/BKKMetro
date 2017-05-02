package com.example.calojy.ui6;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class loginbank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginbank);

        findViewById(R.id.backloginbank).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent dashIntent = new Intent(loginbank.this, splip.class);
                startActivity(dashIntent);
            }
        });

    }
}
