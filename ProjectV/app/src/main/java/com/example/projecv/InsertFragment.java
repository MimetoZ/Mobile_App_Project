package com.example.projecv;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projecv.database.VinetkaDatebase;
import com.example.projecv.modles.Vinetki;


public class InsertFragment extends Fragment {
    EditText editVinetkaNumber, editCarClass, editEmissionClass, editStartDate, editEndDate, editSum, editStatus;
    Button btnInsert;

    OnVinetkaInsertedListener onVinetkaInsertedListener;

    @Override
    public void onAttach(Context context){

        super.onAttach(context);
        onVinetkaInsertedListener = (OnVinetkaInsertedListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_insert, container, false);

        editVinetkaNumber = v.findViewById(R.id.editVinetkaNumber);
        editCarClass = v.findViewById(R.id.editCarClass);
        editEmissionClass = v.findViewById(R.id.editEmissionClass);
        editStartDate = v.findViewById(R.id.editStartDate);
        editEndDate = v.findViewById(R.id.editEndDate);
        editSum = v.findViewById(R.id.editSum);
        editStatus = v.findViewById(R.id.editStatus);
        btnInsert = v.findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(view->{
            String vinetkaNumber = editVinetkaNumber.getText().toString().trim();
            String carClass = editCarClass.getText().toString().trim();
            String emissionClass = editEmissionClass.getText().toString().trim();
            String startDate = editStartDate.getText().toString().trim();
            String endDate = editEndDate.getText().toString().trim();
            String sum = editSum.getText().toString().trim();
            String status = editStatus.getText().toString().trim();

            if(vinetkaNumber.isEmpty() || carClass.isEmpty() || emissionClass.isEmpty()
                    || startDate.isEmpty() || endDate.isEmpty() || sum.isEmpty() || status.isEmpty()){
                Toast.makeText(getActivity(), "Попълни полета",
                        Toast.LENGTH_LONG).show();
                return;
            }
            Vinetki vinetki = new Vinetki();
            vinetki.setVinetkaNumber(vinetkaNumber);
            vinetki.setCarClass(carClass);
            vinetki.setEmissionClass(emissionClass);
            vinetki.setStartDate(startDate);
            vinetki.setEndDate(endDate);
            vinetki.setSum(sum);
            vinetki.setStatus(status);

            Thread t = new Thread(()->{
                VinetkaDatebase.getInstance(getActivity())
                        .vinetkaDao().insertContact(vinetki);

                getActivity().runOnUiThread(
                        ()->{
                            editEmissionClass.setText("");
                            editVinetkaNumber.setText("");
                            editStatus.setText("");
                            editSum.setText("");
                            editEndDate.setText("");
                            editStartDate.setText("");
                            editCarClass.setText("");
                            onVinetkaInsertedListener.OnVinetkaInserted();
                        }
                );
            });
            t.start();;
        });

        return v;
    }
}