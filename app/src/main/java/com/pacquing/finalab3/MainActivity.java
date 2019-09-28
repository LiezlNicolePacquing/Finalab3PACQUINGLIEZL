package com.pacquing.finalab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7, e8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        e1= findViewById(R.id.editText);
        e2= findViewById(R.id.editText2);
        e3= findViewById(R.id.editText3);
        e4= findViewById(R.id.editText4);
        e5= findViewById(R.id.editText5);
        e6= findViewById(R.id.editText6);
        e7= findViewById(R.id.editText7);
        e8= findViewById(R.id.editText8);

    }

    public void saveDATA(View v){
        String data = e1.getText().toString();
        String data2 = e2.getText().toString();
        String data3 = e3.getText().toString();
        String data4 = e4.getText().toString();
        String data5 = e5.getText().toString();
        String data6 = e6.getText().toString();
        String data7 = e7.getText().toString();
        String data8 = e8.getText().toString();

        String[] addData = {data, data2, data3, data4, data5, data6, data7, data8};
        String entry ="";


        FileOutputStream writer = null;

        for(int i = 0; i <= 7; i++){

            entry = addData[i] + "/";

            try {
                writer = openFileOutput("data1.txt", MODE_APPEND);
                writer.write(entry.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.d("Error","File Not Found..");
            } catch (IOException e) {
                Log.d("Error","Input/Output Error..");
            }finally {
                try {
                    writer.close();
                }catch (IOException e){
                    Log.d("Error", "File Not Found..");
                }
            }

        }

        Toast.makeText(this ,"Data Saved..",Toast.LENGTH_LONG).show();
    }

    public void nextScreen(View v){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
