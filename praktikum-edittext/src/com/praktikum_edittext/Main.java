package com.praktikum_edittext;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {
    
	private EditText edittext; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        addKeyListener();
        
    }

    public void addKeyListener(){
    	//mengambil komponen edit
    	edittext = (EditText) findViewById(R.id.editText);
    	
    	//menambahkan key listener utk mengidentifikasi key yang masuk
    	edittext.setOnKeyListener(new OnKeyListener(){
    		public boolean onKey(View v, int keyCode, KeyEvent event){
    			//jika di klik enter maka menampilkan pesan dibawah
    			if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
    				
    				//menampilkan pesan yang ditulis
    				Toast.makeText(Main.this, edittext.getText(), Toast.LENGTH_LONG).show();
    				
    				return true;
    				
    			}else if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
    				//menampilkan pesan yang ditulis
    				Toast.makeText(Main.this, "Number 9 is pressed!", Toast.LENGTH_LONG).show();
    				return true;
    			}
    			return false;
    		}
    	});
    }
}
