package com.example.generateurdeps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_convert;
    Button btn_trad;
    EditText input_non_ps;
    EditText input_ps;
    Spinner dropdown;
    int nblines ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btn_trad = findViewById(R.id.button);
        this.input_non_ps = findViewById(R.id.editText);
        this.input_ps = findViewById(R.id.editText2);
        this.dropdown=findViewById(R.id.spinner);
    }

    public void change_diviseurs(View view){
        String[] text = this.input_non_ps.getText().toString().split("\n");
        int current_nblines = text.length;
        if (current_nblines!=this.nblines){
            this.nblines = current_nblines;
            ArrayList<String> list = new ArrayList<>();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , R.layout.support_simple_spinner_dropdown_item ,list);
            this.dropdown.setAdapter(adapter);
            ArrayList<String> nouv = new ArrayList<>();
            ArrayList<Integer> divis = diviseurs(this.nblines/2);
            for (Integer a:divis){
                nouv.add(String.valueOf(a));
            }
           ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this , R.layout.support_simple_spinner_dropdown_item ,nouv);
            this.dropdown.setAdapter(adapter2);
        }

    }

    public void convert (View view){
        String[] text = this.input_non_ps.getText().toString().split("\n");

    }

    public void put_ps (View view, String text){

    }

    public void trad (View view){

    }

    public ArrayList<Integer> diviseurs (int n){
        ArrayList<Integer> liste = new ArrayList<>();
        for (int i=0 ; i<(n+1) ;i++ ){
            if (i!=0 && n%i==0){
                liste.add(i);
            }
        }
        return liste;
    }
}



//    String[] text = this.input_non_ps.getText().toString().split("\n");
//        this.input_ps.setText("");
//                for (String s : text) {
//                this.input_ps.getText().append(s);
//                this.input_ps.getText().append("\n");
//                }