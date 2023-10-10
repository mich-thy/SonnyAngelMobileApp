package edu.sjsu.android.sonnyangel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    private Toolbar myTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTool = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myTool);
        recyclerView = (RecyclerView) findViewById(R.id.myRecycle);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<SonnyAngelInfo> input = new ArrayList<>();
        input.add(new SonnyAngelInfo("Strawberry Shortcake",
                R.drawable.sa_strawberryshortcake_01, "Strawberry Sonny Angel is a " +
                "figurine based of the Kewpie Angel. It is a collectable from the Sweets " +
                "Series. He is a regular type that wears a hat of a strawberry shortcake."));
        input.add(new SonnyAngelInfo("Acorn",
                R.drawable.acorn, "The Acorn Sonny Angel is a collectable figure from the " +
                "Flower series. This series was released in 2019 and features a Kewpie Angel" +
                "wearing an acorn hat. In addition, the Acorn Sonny is a regular figure from" +
                "the blind box."));
        input.add(new SonnyAngelInfo("Starfish",
                R.drawable.starfish, "The Starfish Sonny Angel is a collectable figure from " +
                "the Marine Series. He is one of the 12 possible figurines from the blind" +
                "box. The Starfish is a regular character wearing a starfish hat. He is " +
                "based of a Kewpie Angel"));
        input.add(new SonnyAngelInfo("Zucchini",
                R.drawable.zucchini, "The Zucchini Sonny Angel is one of 12 possible " +
                "figurines from the Vegetable Series. He is a regular collectable and is seen " +
                "wearing a hat that looks like a Zucchini. The figurine is based of a " +
                "Kewpie Angel"));
        input.add(new SonnyAngelInfo("Apple",
                R.drawable.apple, "The Apple Sonny Angel is a collectable figurine from " +
                "the Sonny Angel collection. Specifically, he is from the Fruit series, " +
                "which shows Kewpie Angels in fruit related hats. The Apple is one of " +
                "the 12 possible fruit babies one can get from the collection."));
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.info){
            Intent activity = new Intent(MainActivity.this, SonnyDirectory.class);
            startActivity(activity);
            return true;
        }else if(id == R.id.uninstall){
            AlertDialog.Builder warning = new AlertDialog.Builder(MainActivity.this);
            warning = new AlertDialog.Builder(MainActivity.this);
            warning.setMessage("Do you want to uninstall this app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            Intent in = new Intent(Intent.ACTION_DELETE);
                            startActivity(in);
                        }
                    })
                    .setNegativeButton("No", null);
            AlertDialog x = warning.create();
            x.show();
        }
        return super.onOptionsItemSelected(item);
    }

}