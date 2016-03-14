package heritage.amcdonald.example14_sqlite3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayContact extends Activity {

    int whereAmIComingFrom = 0;
    private DatabaseHandler myDb ;
    TextView name ;
    TextView phone;
    TextView email;
    TextView street;
    TextView place;
    int idToUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        email = (TextView) findViewById(R.id.editTextStreet);
        street = (TextView) findViewById(R.id.editTextEmail);
        place = (TextView) findViewById(R.id.editTextCity);

        myDb = new DatabaseHandler(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int value = extras.getInt("id");
            if(value>0){
                //means this is the view part not the add contact part.
                Cursor rs = myDb.getData(value);
                idToUpdate = value;
                rs.moveToFirst();
                String theName = rs.getString(rs.getColumnIndex(DatabaseHandler.CONTACTS_COLUMN_NAME));
                String thePhone = rs.getString(rs.getColumnIndex(DatabaseHandler.CONTACTS_COLUMN_PHONE));
                String theEmail = rs.getString(rs.getColumnIndex(DatabaseHandler.CONTACTS_COLUMN_EMAIL));
                String theStreet = rs.getString(rs.getColumnIndex(DatabaseHandler.CONTACTS_COLUMN_STREET));
                String thePlace = rs.getString(rs.getColumnIndex(DatabaseHandler.CONTACTS_COLUMN_CITY));
                if (!rs.isClosed())
                {
                    rs.close();
                }
                Button b = (Button)findViewById(R.id.btn1);
                b.setVisibility(View.INVISIBLE);

                name.setText((CharSequence)theName);
                name.setFocusable(false);
                name.setClickable(false);

                phone.setText((CharSequence)thePhone);
                phone.setFocusable(false);
                phone.setClickable(false);

                email.setText((CharSequence)theEmail);
                email.setFocusable(false);
                email.setClickable(false);

                street.setText((CharSequence)theStreet);
                street.setFocusable(false);
                street.setClickable(false);

                place.setText((CharSequence)thePlace);
                place.setFocusable(false);
                place.setClickable(false);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("id");
            if (value > 0) {
                getMenuInflater().inflate(R.menu.menu_display_contact, menu);
            } else {
                getMenuInflater().inflate(R.menu.menu_main, menu);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.Edit_Contact:
                Button b = (Button)findViewById(R.id.btn1);
                b.setVisibility(View.VISIBLE);
                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);

                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);

                email.setEnabled(true);
                email.setFocusableInTouchMode(true);
                email.setClickable(true);

                street.setEnabled(true);
                street.setFocusableInTouchMode(true);
                street.setClickable(true);

                place.setEnabled(true);
                place.setFocusableInTouchMode(true);
                place.setClickable(true);

                return true;
            case R.id.Delete_Contact:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void run(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int Value = extras.getInt("id");
            if(Value>0){
                if(myDb.updateContact(idToUpdate,name.getText().toString(), phone.getText().toString(), email.getText().toString(), street.getText().toString(), place.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                if(myDb.insertContact(name.getText().toString(), phone.getText().toString(), email.getText().toString(), street.getText().toString(), place.getText().toString())){
                    Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }

}
