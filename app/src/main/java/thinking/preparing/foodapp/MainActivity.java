package thinking.preparing.foodapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {


    private DBHelper mydb;

    EditText name,phone,email;
    Button button,getButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBHelper(this);
        name = findViewById(R.id.name_edit_text);
        phone = findViewById(R.id.phone_edit_text);
        email = findViewById(R.id.email_edit_text);
        button = findViewById(R.id.button);
        getButton = findViewById(R.id.getButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mydb.insertData(name.getText().toString(),phone.getText().toString(),email.getText().toString());
                if (isInserted == true){
                    Toast.makeText(getApplicationContext(),"data gets inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



//        ArrayList arrayList = mydb.getAllCotacts();
    }
}
