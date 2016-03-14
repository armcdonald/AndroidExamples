package com.example.amcdonald.example09_createdynamicwidgets;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout rlMy = (LinearLayout) findViewById(R.id.myLayout);

        TextView tv1 = new TextView(this);
        tv1.setId(124);
        tv1.setTextSize(68);
        tv1.setText("This is a text view");
        tv1.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        tv1.setHeight(240);
        rlMy.addView(tv1);

        Button btn1 = new Button(this);
        btn1.setId(123);
        btn1.setText("Button Text");
        btn1.setBackgroundColor(Color.rgb(255, 0, 0));
        btn1.setTextColor(Color.rgb(255, 255, 255));
        rlMy.addView(btn1);

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
        if (id == R.id.action_doOne) {
            /*Do something when menu option with id action_doOne is selected */
            setTable();
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_doTwo) {
            /*Do something when menu option with id action_doTwo is selected */
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setTable() {
        TableLayout table = (TableLayout) findViewById(R.id.myTable);

        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams();
        tableParams.weight = 1;

        TableRow.LayoutParams trParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        trParams.weight = 1;
        trParams.bottomMargin = 4;
        trParams.topMargin = 4;
        trParams.leftMargin = 4;
        trParams.rightMargin = 4;

        table.removeAllViews();
        //table
        for (int i = 0; i < 16; i+=4) {
            TableRow curRow = new TableRow(this);
            for (int j = 1; j <=4; j++) {
                //cell
                final int btnNum = i+j;
                Button btnTable = new Button(this);
                btnTable.setId(Integer.parseInt(String.valueOf(btnNum)));
                btnTable.setText(String.valueOf(btnNum));
                btnTable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(MainActivity.this, "Pressed button " + String.valueOf(btnNum), Toast.LENGTH_SHORT);
                        toast.show();
                        /*do something here*/
                    }
                });
                curRow.addView(btnTable, trParams);
            }
            table.addView(curRow, tableParams);
        }
    }
}
