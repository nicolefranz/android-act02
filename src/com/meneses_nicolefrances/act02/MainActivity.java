package com.meneses_nicolefrances.act02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	int num;
	EditText txtNumber;
	Button btnSubmit, btnReset;
	TextView txtPrimeCompo, txtBinary, txtDivisible;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtNumber = (EditText)findViewById(R.id.Number);
		btnSubmit = (Button)findViewById(R.id.Submit);
		btnReset = (Button)findViewById(R.id.Reset);
		txtPrimeCompo = (TextView)findViewById(R.id.PrimeComposite);
		txtBinary = (TextView)findViewById(R.id.Binary);
		txtDivisible = (TextView)findViewById(R.id.DivisibleNum);
		
		/* 
		 *EVENT LISTENER : SUBMIT 
		 */
		
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (txtNumber.getText().toString().equals("")) 
				{	
					Toast.makeText(MainActivity.this, "please input a number", Toast.LENGTH_SHORT).show();
					txtNumber.setError("Empty Field!");
					return;
				}
				
			num = Integer.valueOf(txtNumber.getText().toString());
				
				/*
				 * DISPLAY PRIME OR COMPOSITE NUMBER
				 */
				
				boolean number = false;
			    for (int i = 2; i <= num / 2; ++i) {
			      if (num % i == 0) {
			        number = true;
			        break;
			      }
			    }
			    
			    if (!number) {
			    	//PRIME NUMBER
			    	txtPrimeCompo.setText("PRIME NUMBER");
			    } else {
			    	//COMPOSITE NUMBER
			    	txtPrimeCompo.setText("COMPOSITE NUMBER");
			    }
			    
			    
			    /*
				 * DISPLAY BINARY EQUIVALENT
				 */
				txtBinary.setText(""+Integer.toBinaryString(num));
				
				
				/*
				 * DISPLAY DIVISIBLE NUMBERS
				 */
				StringBuilder builder = new StringBuilder();
				
				for (int a = 1; a <= num; ++a) {
					if (num % a == 0) 
						builder.append(a + "  ");
				       txtDivisible.setText(builder.toString()); 
				}	
			}
		});
		
		
		/*
		 * EVENT LISTENER: RESET BUTTON
		 */
		btnReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				txtNumber.setText(null);
				txtBinary.setText(null);
				txtDivisible.setText(null);
				txtPrimeCompo.setText(null);
			}
		});
				
	}
}
