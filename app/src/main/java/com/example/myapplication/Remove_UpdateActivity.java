package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Remove_UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_update);
    }

    String ConnectionResult = "";
    Connection connection;

    TextView Kod_id;
    TextView nazvanie;
    TextView adres;
    TextView strix_kod;



    public void Delete(View v) {

        Kod_id = findViewById(R.id.Kod_id);
        String id = Kod_id.getText().toString();

        try {
            ConnectionHelp conectionHellper = new ConnectionHelp();
            connection = conectionHellper.connect();

                if (connection != null) {

                    String delet = "DELETE FROM Cklad WHERE Kod_cklada = '"+id+"'";
                    Statement statement2 = connection.createStatement();
                    statement2.execute(delet);
                    Toast.makeText(this,"Успешно удалено", Toast.LENGTH_LONG).show();
                } else {
                    ConnectionResult = "Check Connection";
                }


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void Update(View v)
    {
        Kod_id = findViewById(R.id.Kod_id);
        String id = Kod_id.getText().toString();

        nazvanie = findViewById(R.id.nazvanie);
        String nazv = nazvanie.getText().toString();

        adres = findViewById(R.id.adres);
        String adr = adres.getText().toString();

        strix_kod = findViewById(R.id.strix_kod);
        String strix = strix_kod.getText().toString();

        try {
            ConnectionHelp connectionHelper = new ConnectionHelp();
            connection = connectionHelper.connect();
            if (connection != null) {

                String upd = "update Cklad set Nazvanie ='"
                        + nazvanie.getText().toString()
                        + "',Adres ='" +  adres.getText().toString()
                        + "', Strix_kod_tovara ='" + strix_kod.getText().toString() +
                        "' where Kod_cklada = " + Kod_id.getText().toString() ;
                Statement statement = connection.createStatement();
                statement.execute(upd);
                Toast.makeText(this,"Успешно изменено", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());
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