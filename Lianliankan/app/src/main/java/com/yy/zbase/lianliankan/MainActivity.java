package com.yy.zbase.lianliankan;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private String currentText;
    private int currentPoistion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView mainGrid = (GridView) findViewById(R.id.mainGrid);
//        mainGrid.setOnItemClickListener(new OnItemClickListener()
        mainGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                if (null == textView || null == textView.getText() || "" == textView.getText()) {
                    return;
                }
                if (textView.getText().toString().equals(currentText)) {
                    Toast.makeText(MainActivity.this, "pic" + position, Toast.LENGTH_SHORT).show();
                    textView.setText("");
                    textView.setVisibility(View.INVISIBLE);
                    TextView itemAtPosition = (TextView) parent.getItemAtPosition(currentPoistion);
                    itemAtPosition.setText("");
                    itemAtPosition.setVisibility(View.INVISIBLE);

                    return;
                }
                currentPoistion=position;
                currentText = textView.getText().toString();
                Log.i("11", currentText);
//                Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
        mainGrid.setAdapter(new MainAdapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
