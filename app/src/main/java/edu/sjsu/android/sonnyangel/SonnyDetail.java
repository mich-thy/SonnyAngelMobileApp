package edu.sjsu.android.sonnyangel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SonnyDetail extends AppCompatActivity {
    private TextView nameView;
    private ImageView imgView;
    private TextView descriptionView;
    private Toolbar myTool;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        myTool = (Toolbar) findViewById(R.id.my_toolbar1);
        setSupportActionBar(myTool);
        nameView = (TextView) findViewById(R.id.textView);
        imgView = (ImageView) findViewById(R.id.imageView);
        descriptionView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        imgView.setImageResource(intent.getIntExtra("imgNum",0));
        nameView.setText(intent.getStringExtra("nameInfo"));
        descriptionView.setText( intent.getStringExtra("descInfo"));
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.info){
            Intent activity = new Intent(SonnyDetail.this, SonnyDirectory.class);
            startActivity(activity);
            return true;
        }else if(id == R.id.uninstall){
            AlertDialog.Builder warning = new AlertDialog.Builder(SonnyDetail.this);
            warning = new AlertDialog.Builder(SonnyDetail.this);
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
