package com.example.myapplication;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";
    ArrayList<Animal> animalList = new ArrayList<>();
    ListView item_list;
    Intent add_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item_list = findViewById(R.id.item_list);
        add_activity = new Intent(MainActivity.this,AddActivity.class);

       GetAnimalList();

    }

    public void AddAnimal(View v){
        startActivity(add_activity);
    }
    public void UpdateList(View v){GetAnimalList();}

    public void GetAnimalList(){
        try{
            animalList.clear();
            connect = SQLConnection.connect();
            if(connect != null){
                String qu = "select * from animal";
                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(qu);
                while (resultSet.next()){
                    Log.d(ConnectionResult, resultSet.getString("nickname_animal"));
                    animalList.add(new Animal(resultSet.getString("nickname_animal"),resultSet.getString("kind"),resultSet.getString("age")));
                }
                ConnectionResult = "Success";
                AnimalAdapter adapter = new AnimalAdapter(this,animalList);
                item_list.setAdapter(adapter);
            }
            else {
                ConnectionResult = "Failed";
            }
            Log.d(ConnectionResult,"");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.d(ConnectionResult, throwables.getMessage());
        }
    }
}