package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class AddActivity extends Activity {

    Connection connect;
    TextInputLayout name;
    TextInputLayout kind;
    TextInputLayout age;
    TextInputLayout weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        name = findViewById(R.id.text_name);
        kind = findViewById(R.id.text_kind);
        age = findViewById(R.id.text_age);
        weight = findViewById(R.id.text_weight);
    }

    public void AddAnimal(View view){
        Log.d("name - ", String.valueOf(Objects.requireNonNull(name.getEditText()).getText()));
        try{
            SQLConnection connection = new SQLConnection();
            connect = connection.connect();
            String qu = "insert into animal values("
                    + Integer.parseInt(String.valueOf(weight.getEditText().getText()))
                    + ",\'" + Objects.requireNonNull(name.getEditText()).getText()
                    + "\',\'" + Objects.requireNonNull(kind.getEditText()).getText()+
                    "\'," + Integer.parseInt(String.valueOf(age.getEditText().getText()))+
                    ")";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(qu);
            connect.close();
            Log.d("", String.valueOf((resultSet.last())));
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.d("Error - ",throwables.getMessage());
        }
    }
}
