package binh.pc.trigonic;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("");
        categories.add("HOME");
        categories.add("MEN");
        categories.add("WOMEN");
        categories.add("ABOUT US");
        categories.add("ADD PRODUCT");
        categories.add("LOGIN/REGISTER");



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        if(item == "LOGIN/REGISTER"){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if(item == "ADD PRODUCT"){
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
        }
        if(item == "MEN"){
            Intent intent = new Intent(this, MenShoesActivity.class);
            startActivity(intent);
        }
        if(item == "WOMEN"){
            Intent intent = new Intent(this, WomenShoesActivity.class);
            startActivity(intent);
        }
        if(item == "HOME"){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void clickToViewCart(View view) {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        startActivity(intent);
    }
}
