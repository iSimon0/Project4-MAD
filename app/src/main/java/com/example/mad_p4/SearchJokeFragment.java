package com.example.mad_p4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SearchJokeFragment extends Fragment {
    private float inputTemp;
    private String label;
    private boolean converge;
    private float finalTemp;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.temp_activity,
                container, false);
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putFloat("temp", inputTemp);
        outState.putBoolean("converge", converge);
        outState.putString("label", label);
        outState.putFloat("final", finalTemp);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        final EditText input = view.findViewById(R.id.editText2);
        final Switch conversion = view.findViewById(R.id.switch2);
        final TextView output = view.findViewById(R.id.textView3);
        final Button button = (Button) view.findViewById(R.id.button);
        final TextView outputUnit = view.findViewById(R.id.textView4);
        if(savedInstanceState != null){
            inputTemp = savedInstanceState.getFloat("temp");
            converge = savedInstanceState.getBoolean("converge");
            label = savedInstanceState.getString("label");
            finalTemp = savedInstanceState.getFloat("final");
            conversion.setChecked(converge);
            input.setText(Float.toString(inputTemp));
            output.setText(Float.toString(finalTemp));
            outputUnit.setText(label);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(conversion.isChecked()){
                    converge = true;
                    label = "Fahrenheit";
                }
                else{
                    converge = false;
                    label = "Celsius";
                }
                inputTemp = Float.valueOf(input.getText().toString());
                if(converge){
                    finalTemp = (inputTemp * 1.8f) + 32;
                    output.setText(Float.toString(finalTemp));
                    outputUnit.setText(label);
                }
                else{
                    finalTemp = (inputTemp - 32) * 5/9;
                    output.setText(Float.toString(finalTemp));
                    outputUnit.setText(label);
                }

            }
        });
    }
}
