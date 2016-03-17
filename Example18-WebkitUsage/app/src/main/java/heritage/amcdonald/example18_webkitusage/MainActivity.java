package heritage.amcdonald.example18_webkitusage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    final String myPage = "<html><head><title>eg 2</title></head><body><h1>Hello class</h1></body></html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSwitch = (Button) findViewById(R.id.btnSwitch);

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = (counter+1) % 3;
                showPage(counter);
            }
        });

    }

    private void showPage(int counter) {
        WebView browser = (WebView) findViewById(R.id.wvBrowser);
        switch (counter) {
            case 0: browser.loadUrl("http://www.cegep-heritage.qc.ca");
                    break;
            case 1: browser.loadData(myPage, "text/html", "UTF-8");
                    break;
            case 2: browser.loadUrl("http://www.feedforall.com/sample.xml");
                    break;
        }
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
