package ca.heritage.amcdonald.example11a_fragments2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Allan on 2015/11/01.
 */
public class DoStuff extends AppCompatActivity {

    public DoStuff() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment2);
    }

    public Integer doWork(String valueSelected) {
        int i = 2;
        int j = 3;
        int k = i * j;
        return k;
    }

}
