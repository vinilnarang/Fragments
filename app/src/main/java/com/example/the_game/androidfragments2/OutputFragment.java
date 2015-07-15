package com.example.the_game.androidfragments2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by the_game on 14/07/15.
 */
public class OutputFragment extends Fragment {

    InputFragmentListener i;
    private static TextView textView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            i = (InputFragmentListener)activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.output_fragment,container,false);

        textView = (TextView)view.findViewById(R.id.textView);
        textView.setText(i.setPhoneNumber());

        Button button = (Button)view.findViewById(R.id.button2);
        button.setOnClickListener(
               new View.OnClickListener(){
                   public void onClick(View v) {

                       i.goBack();

                   }

               }
        );

        return view;
    }

    void update(String str) {

        textView.setText(str);
        textView.setVisibility(View.VISIBLE);

    }




}
