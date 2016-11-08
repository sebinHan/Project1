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
public class BottomActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner spinnerTopNation, spinnerTopSize;


    Spinner spinner01;        // Spinner
    Spinner spinner02;        // Spinner
    String[] company;
    ImageView bottom_btn;
    int index_b;



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
                        //    <item >미국</item>
                        //    <item >영국</item>
                        //    <item >일본</item>
                        //    <item >프랑스</item>


                        case (0):
                            populateSubSpinners(R.array.usa_bottom);
                            index_b = position;
                            break;
                        case (1):
                            populateSubSpinners(R.array.eng_bottom);
                            index_b = position;
                            break;
                        case (2):
                            populateSubSpinners(R.array.japan_bottom);
                            index_b = position;
                            break;
                        case (3):
                            populateSubSpinners(R.array.france_bottom);
                            index_b = position;
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }

            };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomlayout);

        bottom_btn = (ImageView)findViewById(R.id.bottom_cal_btn);
        //Spinner01초기화
        spinner01 = (Spinner) findViewById(R.id.bottom_nation_spinner);
        populateSpinners();

        //Spinner02초기화
        spinner02 = (Spinner) findViewById(R.id.bottom_size_spinner);
        populateSubSpinners(R.array.nation);

        spinner01.setOnItemSelectedListener(spinSelectedlistener);

        company = getResources().getStringArray(R.array.kor_bottom);

        bottom_btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        index_b=spinner02.getSelectedItemPosition();
        Toast.makeText(BottomActivity.this, "후훗 바지사이즈는 <"+company[index_b]+"> 이군요~", Toast.LENGTH_SHORT).show();
    }
}

