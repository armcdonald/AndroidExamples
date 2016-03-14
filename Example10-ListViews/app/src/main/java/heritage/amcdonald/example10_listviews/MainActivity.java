package heritage.amcdonald.example10_listviews;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowHeroes = (Button) findViewById(R.id.btnHero);
        Button btnShowVillains = (Button) findViewById(R.id.btnVillain);
        Button btnMixed = (Button) findViewById(R.id.btnGridView);

        btnShowHeroes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Intent inHeroList = new Intent(getApplicationContext(), HeroListActivity.class);
               startActivity(inHeroList);
            }
        });

        btnShowVillains.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent inVillainList = new Intent(getApplicationContext(), VillainListActivity.class);
                startActivity(inVillainList);
            }
        });

        btnMixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inMixed = new Intent(getApplicationContext(), GridViewExample.class);
                startActivity(inMixed);
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
