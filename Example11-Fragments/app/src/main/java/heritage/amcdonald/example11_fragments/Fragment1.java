package heritage.amcdonald.example11_fragments;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment_fragment1, container, false);
        final String[] heroes={"Batman", "Flash", "Hawkeye", "Hulk", "Human Torch", "Invisible Woman", "IronMan", "Spider Man", "Thor"};
        ListView heroesList = (ListView) vw.findViewById(R.id.hero_list);
        ArrayAdapter<String> arrayAdpt= new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1, heroes);
        heroesList.setAdapter(arrayAdpt);
        heroesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    TextView selectedOpt = (TextView) getActivity().findViewById(R.id.selectedopt);
                    selectedOpt.setText("You have selected "+((TextView) v).getText().toString());
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(),  ShowItemActivity.class);
                    intent.putExtra("item", ((TextView) v).getText().toString());
                    startActivity(intent);
                }
            }
        });
        return vw;
    }


}
