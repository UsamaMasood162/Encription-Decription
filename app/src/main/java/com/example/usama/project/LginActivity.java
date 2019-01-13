package com.example.usama.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LginActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private  int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lgin);

        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView) findViewById(R.id.tvinfo);
        login=(Button) findViewById(R.id.btnLogin);

        Info.setText("No of Attempts Remaining:  5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(Name.getText().toString(),Password.getText().toString());
            }
        });

}
    private void Validate(String useNrame,String userPassword){
        if( (Name.getText().toString().equals("usama") ) && (Password.getText().toString().equals("12345"))){
            Intent intent= new Intent(LginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            counter--;

            Info.setText("No of Attempts Remaining:  "+ String.valueOf(counter));

            if(counter==0){
                login.setEnabled(false);
            }

        }
    }
}

