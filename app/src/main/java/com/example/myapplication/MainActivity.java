package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnectionResult="";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
     }
     SimpleAdapter ad;

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonadd:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);

        }
    }

    public void Delete(View v) {
        switch (v.getId()) {
            case R.id.buttondelete:
                Intent intent = new Intent(this, Remove_UpdateActivity.class);
                startActivity(intent);

        }
    }



 public void GetList(View v)
 {

     ListView lstv=(ListView)  findViewById(R.id.listview1);

     List<Map<String, String>> Mydatalist = null;
     ListItem MyData= new ListItem();
     Mydatalist = MyData.getlist();

     String[] From={"Kod","IName","IdAdres","StrixKod"};
     int[ ] Tow= { R.id.Kod,R.id.IName,R.id.IdAdres,R.id.StrixKod};
     ad = new SimpleAdapter(MainActivity.this,Mydatalist,R.layout.listlayoutetemplate,From,Tow);
     lstv.setAdapter((ad));

 }

}