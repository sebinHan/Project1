package kr.hs.emirim.sbb9918.myfirstapplication;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView tImgView, bImgView, uImgView, sImgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tImgView = (ImageView)findViewById(R.id.top_iv);
        bImgView = (ImageView)findViewById(R.id.bottom_iv);
        uImgView = (ImageView)findViewById(R.id.under_iv);
        sImgView = (ImageView)findViewById(R.id.shoes_iv);

        tImgView.setOnClickListener(this);
        bImgView.setOnClickListener(this);
        uImgView.setOnClickListener(this);
        sImgView.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //overridePendingTransition(R.anim.hold,R.anim.hold);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.top_iv:
                Intent intent_t = new Intent(this, TopActivity.class);
                startActivity(intent_t);
                break;
            case R.id.bottom_iv:
                Intent intent_b = new Intent(this, BottomActivity.class);
                startActivity(intent_b);
                break;
            case R.id.shoes_iv:
                Intent intent_s = new Intent(this, ShoesActivity.class);
                startActivity(intent_s);
                break;
            case R.id.under_iv:
                Intent intent_u = new Intent(this, UnderWearActivity.class);
                startActivity(intent_u);
                break;

        }
    }
}