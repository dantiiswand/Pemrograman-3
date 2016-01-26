package com.kamus.android.app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener{
	DatabaseManager dm;
	EditText input;
	ImageButton bcari; 
	Button bTambah;
	TextView output;
	ArrayList<EntitasKamus> isikamus = new ArrayList<EntitasKamus>();
	EntitasKamus komponenkamus;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dm = new DatabaseManager(this);
        bTambah = (Button) findViewById(R.id.bTambah);
        input = (EditText) findViewById(R.id.input);
        bcari = (ImageButton) findViewById(R.id.bSearch);
        
        bTambah.setOnClickListener(this);
        bcari.setOnClickListener(this);
    }

    protected void fungsiterjemah(){
    	ArrayList<Object> baris;
    	baris = dm.terjemahkan(input.getText().toString());
    	if(baris.size() > 0){
    		output.setText((String) baris.get(2));
    		input.setText("");
    	}else{
    		output.setText("tidak ditemukan");
    	}
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSearch: fungsiterjemah();
		break;
		case R.id.bTambah: Intent i = new Intent(Main.this, TambahActivity.class);
		   			       startActivity(i);
		break;
		default:
			break;
		}
	}    
}
