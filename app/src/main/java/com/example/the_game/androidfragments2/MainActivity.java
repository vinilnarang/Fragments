package com.example.the_game.androidfragments2;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements InputFragmentListener {

    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        InputFragment iF = new InputFragment();
        ft.replace(R.id.your_placeholder,iF);
        ft.addToBackStack(null);
        ft.commit();
        //Log.d("abcd",this.abcd+"");
    }


    @Override
    public void sendPhoneNumber(String phoneNumber) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        str = phoneNumber;
        OutputFragment oF = new OutputFragment();
        ft.replace(R.id.your_placeholder, oF);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
        /*OutputFragment o = (OutputFragment) getFragmentManager().findFragmentById(R.id.output_fragment);
        o.update(str);*/
    }

    @Override
    public String setPhoneNumber(){

        return str;
    }

    @Override
    public void goBack(){

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        InputFragment iF = new InputFragment();
        ft.replace(R.id.your_placeholder,iF);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();

    }



}
