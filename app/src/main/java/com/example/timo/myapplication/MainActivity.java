package com.example.timo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{

    private TextView nachricht;
    private Button weiter_fertig;
    private EditText eingabe;
    private boolean ersterKlick;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nachricht = (TextView) findViewById(R.id.nachricht);
        weiter_fertig = (Button) findViewById(R.id.weiter_fertig);
        eingabe = (EditText) findViewById(R.id.eingabe);

        ersterKlick = true;
        nachricht.setText(R.string.willkommen);
        weiter_fertig.setText(R.string.weiter);

        weiter_fertig.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(ersterKlick)
                {
                    nachricht.setText(getString(R.string.hallo, eingabe.getText()));
                    eingabe.setVisibility(View.INVISIBLE);
                    weiter_fertig.setText(R.string.fertig);
                    ersterKlick = false;
                }
                else
                {
                  finish();
                }
            }
        });

        eingabe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                weiter_fertig.setEnabled(s.length() > 0);
            }
        });
        weiter_fertig.setEnabled(false);
    }

    @Override //aus generierter Klasse übernommen
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the
        // action bar if present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override //aus generierter KLasse übernommen
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
