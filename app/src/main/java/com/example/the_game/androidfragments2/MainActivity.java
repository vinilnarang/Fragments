package com.example.the_game.androidfragments2;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class MainActivity extends ActionBarActivity implements InputFragmentListener {

    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        InputFragment iF = new InputFragment();
        ft.replace(R.id.your_placeholder, iF);
        ft.commit();
        //Log.d("abcd",this.abcd+"");
    }


    @Override
    public void sendPhoneNumber(String phoneNumber) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        str = phoneNumber;
        hideKeyboard(this);
        OutputFragment oF = new OutputFragment();
        ft.replace(R.id.your_placeholder, oF);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack("Input Fragment");
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
        ft.replace(R.id.your_placeholder, iF);
        getFragmentManager().popBackStack();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }

    public static void hideKeyboard(Context context) {
        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) context).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }


}
