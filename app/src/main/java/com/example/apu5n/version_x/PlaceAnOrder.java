package com.example.apu5n.version_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlaceAnOrder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp1;
    ArrayAdapter<String> spinnerArrayAdapter;
    List<String> categories;
    Integer Total_Cost[] = {500,600,700};
    Integer i;
    EditText name,address,phone;
    TextView Total_Cost_is;
    Button pao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_an_order);
        sp1 = (Spinner) (findViewById(R.id.PAO_Spinner_List));
        // Spinner click listener
        sp1.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        categories = new ArrayList<String>();
        categories.add("Adhik Mass");
        categories.add("Satyanarayan");
        categories.add("Diwali Puja");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        sp1.setAdapter(dataAdapter);

        name = (EditText)findViewById(R.id.Name);
        address = (EditText)findViewById(R.id.Address);
        phone = (EditText)findViewById(R.id.Phone);
        pao = (Button)findViewById(R.id.PlaceTheOrder);
        pao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().length() == 0){
                    name.setError("This field is required!");
                    name.requestFocus();
                }
                else if(address.getText().toString().length() == 0){
                    address.setError("This field is required!");
                    address.requestFocus();
                }
                else if(phone.getText().toString().length() == 0){
                    phone.setError("This field is required!");
                    phone.requestFocus();
                }
                else if(phone.getText().toString().length() < 10){
                    phone.setError("Mobile number should be of 10 digits");
                    phone.requestFocus();
                }
                else{
                    startActivity(new Intent(getApplication(),Thank_You.class));
                }
            }
        });


    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        Total_Cost_is = (TextView)findViewById(R.id.TotalCosts);
        String Result,r1="";

        String value = sp1.getSelectedItem().toString();

        for(i = 0;i<categories.size();i++ ) {
            if (value == categories.get(i)) {
                r1 = Total_Cost[i].toString();
            }
        }

        Result = "You need to pay Rs."+r1;
        Total_Cost_is.setText(Result);
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



















    public void Puja_List(View view){
        Intent Puja_List = new Intent(this,PujaList.class);
        startActivity(Puja_List);
        finish();
    }

    public void Home(View view){
        Intent Home = new Intent(this,MainActivity.class);
        startActivity(Home);
        finish();
    }

    public void Place_An_Order(View view){
        Intent Place_An_Order = new Intent(this,PlaceAnOrder.class);
        startActivity(Place_An_Order);
        finish();
    }
}
