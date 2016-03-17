package heritage.amcdonald.example15_externaldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Customer> customers = new Customer().getCustomers();

        TableLayout tblCust = (TableLayout) findViewById(R.id.tblCustomers);

        for (Customer c : customers) {
            TableRow row = new TableRow(this);

            TextView txtId = new TextView(this);
            TextView txtCompany = new TextView(this);
            TextView txtContact = new TextView(this);
            TextView txtCity = new TextView(this);

            txtId.setText(c.getCustomerID());
            txtCompany.setText(c.getCompanyName());
            txtContact.setText(c.getContactName());
            txtCity.setText(c.getCity());

            row.addView(txtId);
            row.addView(txtCompany);
            row.addView(txtContact);
            row.addView(txtCity);

            tblCust.addView(row);
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
