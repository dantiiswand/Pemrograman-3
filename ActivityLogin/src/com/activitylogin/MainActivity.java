package com.activitylogin;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	String pass;
	String nama;
	String myname = "Danti Iswandhari";
	String mypass = "280196";
	EditText name;
	EditText passw,tampil;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        name = (EditText)findViewById(R.id.User);
        passw = (EditText)findViewById(R.id.Password);
        Button submit = (Button)findViewById(R.id.btnExit);
        submit.setOnClickListener(new click());
    }

    @SuppressLint("ShowToast")
    class click implements Button.OnClickListener{
    	@SuppressLint("ShowToast")
    	public void onClick(View v){
    		nama = name.getText().toString();
    		pass = passw.getText().toString();
    		 if((pass.equals(mypass))&&(nama.equals(myname))){
                 Toast.makeText(getApplicationContext(),"Selamat datang, anda berhasil login..." ,31).show();
                 Intent i = new Intent(MainActivity.this, Activity_welcome.class);
                 startActivity(i);
          }else{
                 Toast.makeText(getApplicationContext(),"Ma'af..., Username atau password salah",23).show();
                 name.setText("");
                 passw.setText("");
          }
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
