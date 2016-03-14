package ca.heritage.amcdonald.example11a_fragments2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ca.heritage.amcdonald.example11a_fragments2.DoStuff;

public class FragmentFill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.fragment2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedItem = extras.getString("province");
            DoStuff doIt = new DoStuff();
            Integer retValue = doIt.doWork(selectedItem);
            TextView textView = (TextView) findViewById(R.id.selectedProv);
            TextView resultView = (TextView) findViewById(R.id.tvProduct);
            textView.setText("You have selected "+ selectedItem);
            resultView.setText("The product is "+ retValue.toString());
        }
    }

}
