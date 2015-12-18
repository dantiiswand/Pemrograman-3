package com.activitylogin;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Activity_welcome extends Activity {
    Button btnExit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_welcome);
		addListenerOnButton();
	}

	public void addListenerOnButton(){
    	final Context context = this;
    	btnExit = (Button) findViewById(R.id.btnExit);
    	btnExit.setOnClickListener(new View.OnClickListener() {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(context,MainActivity.class);
		startActivity(i);
	 }
  });
}

}
