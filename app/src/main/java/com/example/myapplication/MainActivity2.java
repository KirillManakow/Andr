package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    String ConnectionResult = "";
    Connection connection;

    TextView Name_cklada;
    TextView Adres_sklada;
    TextView Strix_kod_sklada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void Add(View v) {

        Name_cklada = findViewById(R.id.Name_cklada);
        Adres_sklada = findViewById(R.id.Adres_sklada);
        Strix_kod_sklada = findViewById(R.id.Strix_kod_sklada);

        String Namec = Name_cklada.getText().toString();
        String Adress = Adres_sklada.getText().toString();
        String Strixs = Strix_kod_sklada.getText().toString();

        try {
            ConnectionHelp conectionHellper = new ConnectionHelp();
            connection = conectionHellper.connect();

            if (Name_cklada.getText().length()==0 || Adres_sklada.getText().length()==0 || Strix_kod_sklada.getText().length()==0 )
            {
                Toast.makeText(this,"Не заполнены обязательные поля", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                if (connection != null) {

                    String query = "INSERT INTO Cklad (Nazvanie, Adres, Strix_kod_tovara) values ('" + Namec + "','" + Adress + "','" + Strixs + "')";
                    Statement statement = connection.createStatement();
                    statement.execute(query);
                    Toast.makeText(this,"Успешно добавлено", Toast.LENGTH_LONG).show();
                } else {
                    ConnectionResult = "Check Connection";
                }
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void back(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}