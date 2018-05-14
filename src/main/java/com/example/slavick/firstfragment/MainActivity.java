package com.example.slavick.firstfragment;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener, SecondFragment.OnFragmentInteractionListener, ThirdFragment.OnFragmentInteractionListener, FourthFragment.OnFragmentInteractionListener {
    @BindView(R.id.button)
    Button button;
    long fourClick;
    long threeClick;
    long twoClick;
    long oneClick;
    long begin;
    long check1;
    long check2;
    long check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
        if (oneClick == 0) {
            begin = System.currentTimeMillis();
            oneClick = System.currentTimeMillis();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, FirstFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        } else if (twoClick == 0) {
            twoClick = System.currentTimeMillis();
            if (twoClick - oneClick < 600) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            } else {
                oneClick = 0;
                twoClick = 0;
            }
        } else if (threeClick == 0) {
            threeClick = System.currentTimeMillis();
            if (threeClick - twoClick < 600) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, ThirdFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            } else {
                twoClick = 0;
                oneClick = 0;
                threeClick = 0;
            }
        } else if (fourClick == 0) {
            fourClick = System.currentTimeMillis();
            if (fourClick - threeClick < 600) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, FourthFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }

        } else {
            twoClick =0;
            oneClick =0;
            fourClick = 0;
            threeClick = 0;
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
