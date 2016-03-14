package heritage.amcdonald.example10_listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HeroListActivity extends AppCompatActivity {

    ArrayList<String> lvHeroList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list);

        ListView lvHeroes = (ListView) findViewById(R.id.lvHero);

        lvHeroList = new ArrayList<String>();
        getArrayValues();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lvHeroList);

        lvHeroes.setAdapter(arrayAdapter);

        lvHeroes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sItem = lvHeroList.get(position);
                Toast.makeText(getApplicationContext(), "You Selected: " + sItem, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hero_list, menu);
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

    void getArrayValues()
    {
        lvHeroList.add("Antman");
        lvHeroList.add("Arrow");
        lvHeroList.add("Batman");
        lvHeroList.add("Cyclops");
        lvHeroList.add("Flash");
        lvHeroList.add("Professor Xavier");
        lvHeroList.add("Quicksilver");
        lvHeroList.add("Rogue");
        lvHeroList.add("Spiderman");
        lvHeroList.add("Storm");
        lvHeroList.add("Superman");
        lvHeroList.add("White Witch");
        lvHeroList.add("Wolverine");
    }

}
