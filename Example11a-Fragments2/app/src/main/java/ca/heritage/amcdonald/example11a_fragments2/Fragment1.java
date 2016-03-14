package ca.heritage.amcdonald.example11a_fragments2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import ca.heritage.amcdonald.example11a_fragments2.DoStuff;

public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment1, container, false);
        final String[] provinces={"British Columbia", "Alberta", "Saskatchewan", "Manitoba", "Ontario", "Quebec", "New Brunswick", "Nova Scotia", "PEI", "Newfoundland"};
        ListView heroesList = (ListView) vw.findViewById(R.id.prov_list);
        ArrayAdapter<String> arrayAdapt= new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1, provinces);
        heroesList.setAdapter(arrayAdapt);
        heroesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    TextView selectedOpt = (TextView) getActivity().findViewById(R.id.selectedProv);
                    TextView theProduct = (TextView) getActivity().findViewById(R.id.tvProduct);
                    String selectedProvince = ((TextView) v).getText().toString();

                    DoStuff doIt = new DoStuff();
                    Integer retValue = doIt.doWork(selectedProvince);
                    selectedOpt.setText("You have selected " + selectedProvince);
                    theProduct.setText("The product is: " + retValue.toString());

                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(),  FragmentFill.class);
                    intent.putExtra("province", ((TextView) v).getText().toString());
                    startActivity(intent);
                }
            }
        });
        return vw;
    }


}
