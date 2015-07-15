package com.example.the_game.androidfragments2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by the_game on 14/07/15.
 */

public class InputFragment extends Fragment{


    private EditText editText;

    InputFragmentListener activityCommander;

  /*  public interface InputFragmentListener{
        public void sendPhoneNumber(String phoneNumber);
    }
*/
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (InputFragmentListener)activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_fragment,container,false);

        editText = (EditText)view.findViewById(R.id.editText);
        Button button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v){

                        activityCommander.sendPhoneNumber(editText.getText().toString());

                    }

                }
        );

        return view;

    }



}
