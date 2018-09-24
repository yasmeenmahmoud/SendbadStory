package com.example.sendbadstory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mylist = findViewById(R.id.listview);
        ImageView shareimage = findViewById(R.id.img_share);
        ImageView delete = findViewById(R.id.img_delete);

        String[] items = getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.raw, R.id.storyheader, items);
        mylist.setAdapter(arrayAdapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, mystory.class);
                intent.putExtra("page", position);
                startActivity(intent);
            }
        });
        shareimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sharetxt = "تطبيق السندباد";
                String sharelink = "https://play.google.com/store/apps/details?id=com.example.sendbadstory";
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, sharetxt + "\n" + sharelink);
                startActivity(share);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
