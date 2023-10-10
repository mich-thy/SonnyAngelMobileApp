package edu.sjsu.android.sonnyangel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SonnyDirectory extends AppCompatActivity {
    private TextView text;
    private Button call;
    private Toolbar myTool;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonny_directory);
        myTool = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myTool);
        text = findViewById(R.id.textView3);
        call = findViewById(R.id.button);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uriP = "tel:888-8888";
                Intent act = new Intent(Intent.ACTION_DIAL, Uri.parse(uriP));
                startActivity(act);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.info){
            return true;
        }else if(id == R.id.uninstall){
            AlertDialog.Builder warning = new AlertDialog.Builder(SonnyDirectory.this);
            warning = new AlertDialog.Builder(SonnyDirectory.this);
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
