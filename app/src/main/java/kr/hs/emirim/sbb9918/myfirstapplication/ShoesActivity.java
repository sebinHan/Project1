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
public class ShoesActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spinnerTopNation, spinnerTopSize;


    Spinner spinner01;        // Spinner
    Spinner spinner02;        // Spinner
    ImageView shoes_btn;
    String[] company;
    int index_s;


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
        fAdapter = ArrayAdapter.createFromResource(this, itemNum, android.R.layout.simple_spinner_item);
        fAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner02.setAdapter(fAdapter);
    }

    private AdapterView.OnItemSelectedListener spinSelectedlistener =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    switch (position) {
                        //    <item >미국</item>
                        //    <item >영국</item>
                        //    <item >일본</item>
                        //    <item >프랑스</item>


                        case (0):
                            populateSubSpinners(R.array.usa_shoes);
                            index_s = position;
                            break;
                        case (1):
                            populateSubSpinners(R.array.eng_shoes);
                            index_s = position;
                            break;
                        case (2):
                            populateSubSpinners(R.array.japan_shoes);
                            index_s = position;
                            break;
                        case (3):
                            populateSubSpinners(R.array.france_shoes);
                            index_s = position;
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoeslayout);
        shoes_btn = (ImageView)findViewById(R.id.shoes_cal_btn);
        //Spinner01초기화
        spinner01 = (Spinner) findViewById(R.id.shoes_nation_spinner);
        populateSpinners();

        //Spinner02초기화
        spinner02 = (Spinner) findViewById(R.id.shoes_size_spinner);
        populateSubSpinners(R.array.nation);

        spinner01.setOnItemSelectedListener(spinSelectedlistener);
        company = getResources().getStringArray(R.array.kor_shoes);

        shoes_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        index_s=spinner02.getSelectedItemPosition();
        Toast.makeText(ShoesActivity.this, "후훗 신발사이즈는 <"+company[index_s]+"> 이군요~", Toast.LENGTH_SHORT).show();
    }
}
