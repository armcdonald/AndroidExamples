package heritage.amcdonald.example11_fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Allan on 2015/10/17.
 */
public class ShowItemActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.fragment_fragment2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedItem = extras.getString("item");
            TextView textView = (TextView) findViewById(R.id.selectedopt);
            textView.setText("You have selected "+selectedItem);
        }
    }
}
