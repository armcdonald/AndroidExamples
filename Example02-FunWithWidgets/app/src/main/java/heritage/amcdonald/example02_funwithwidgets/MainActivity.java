package heritage.amcdonald.example02_funwithwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.security.KeyException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTitle = (Button) findViewById(R.id.btnTitle);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final TextView tvName = (TextView) findViewById(R.id.tvPrompt);

        btnTitle.setOnClickListener(new View.OnClickListener() {

            int count = 0;
            String newTitle = "";
            TextView tv1 = (TextView) findViewById(R.id.tvTitle);

            @Override
            public void onClick(View v) {

                switch ((++count) % 2) {
                    case 0:
                        newTitle = getString(R.string.strTitle);
                        break;
                    case 1:
                        newTitle = getString(R.string.strNewTitle);
                        break;
                }
                tv1.setText(newTitle);
            }
        });

        etName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String getText = etName.getText().toString();
                if (getText.equals("Enter name")) {
                    etName.setText("");
                    tvName.setVisibility(View.VISIBLE);
                }
            }
        });

        Button btnCheck = (Button) findViewById(R.id.btnCheck);
        final ToggleButton btnToggle = (ToggleButton) findViewById(R.id.tBtnOne);
        final CheckBox cbTest = (CheckBox) findViewById(R.id.cbOne);
        final RadioButton rbTwo = (RadioButton) findViewById(R.id.rBtnTwo);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbTest.toggle();
                btnToggle.toggle();
                rbTwo.setChecked(true);
            }
        });

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
