package kr.hs.emirim.sbb9918.myfirstapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Student on 2016-06-19.
 */
public class TopActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner spinnerTopNation, spinnerTopSize;
    ImageView top_btn;


    Spinner spinner01;        // Spinner
    Spinner spinner02;        // Spinner
    String[] company;
    int index;

    private void populateSpinners() {
        ArrayAdapter<CharSequence> fAdapter;
        fAdapter = ArrayAdapter.createFromResource(this,
                R.array.nation,
                android.R.layout.simple_spinner_item);
        fAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner01.setAdapter(fAdapter);
    }

    private void populateSubSpinners(int itemNum) {
        ArrayAdapter<CharSequence> fAdapter;
        fAdapter = ArrayAdapter.createFromResource(this,
                itemNum,
                android.R.layout.simple_spinner_item);
        fAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner02.setAdapter(fAdapter);
    }

    private AdapterView.OnItemSelectedListener spinSelectedlistener =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    switch (position) {


                        case (0):
                            populateSubSpinners(R.array.usa_top);
                            break;
                        case (1):
                            populateSubSpinners(R.array.eng_top);
                            break;
                        case (2):
                            populateSubSpinners(R.array.japan_top);
                            break;
                        case (3):
                            populateSubSpinners(R.array.france_top);
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }

            };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toplayout);

        top_btn = (ImageView)findViewById(R.id.top_cal_btn);

        //Spinner01초기화
        spinner01 = (Spinner) findViewById(R.id.top_nation_spinner);
        populateSpinners();

        //Spinner02초기화
        spinner02 = (Spinner) findViewById(R.id.top_size_spinner);
        populateSubSpinners(R.array.nation);

        spinner01.setOnItemSelectedListener(spinSelectedlistener);

        company = getResources().getStringArray(R.array.kor_top);
        top_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        index=spinner02.getSelectedItemPosition();
        Toast.makeText(TopActivity.this, "후훗 상의사이즈는 <"+company[index]+"> 이군요~", Toast.LENGTH_SHORT).show();

    }
}
