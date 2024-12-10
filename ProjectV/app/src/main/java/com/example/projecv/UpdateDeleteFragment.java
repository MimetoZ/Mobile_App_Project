package com.example.projecv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projecv.database.VinetkaDatebase;
import com.example.projecv.modles.Vinetki;


public class UpdateDeleteFragment extends Fragment {

    String Id;
    EditText editVinetkaNumber, editCarClass, editEmissionClass, editStartDate, editEndDate, editSum, editStatus;
    Button btnUpdate, btnDelete;
    onVinetkaDeleted vinetkaDeleted;
    onVinetkaUpdate vinetkaUpdate;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        vinetkaDeleted = (onVinetkaDeleted) context;
        vinetkaUpdate = (onVinetkaUpdate) context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update_delete, container, false);
        editVinetkaNumber = v.findViewById(R.id.editVinetkaNumber);
        editCarClass = v.findViewById(R.id.editCarClass);
        editEmissionClass = v.findViewById(R.id.editEmissionClass);
        editStartDate = v.findViewById(R.id.editStartDate);
        editEndDate = v.findViewById(R.id.editEndDate);
        editSum = v.findViewById(R.id.editSum);
        editStatus = v.findViewById(R.id.editStatus);
        btnUpdate = v.findViewById(R.id.btnUpdate);
        btnDelete = v.findViewById(R.id.btnDelete);

        if(getArguments() == null) {
            return v;
        }

            Vinetki vinetki = (Vinetki) getArguments().getSerializable("vinetka");
            Id = "" + vinetki.getId();
            editVinetkaNumber.setText(vinetki.getVinetkaNumber());
            editCarClass.setText(vinetki.getCarClass());
            editEmissionClass.setText(vinetki.getEmissionClass());
            editStartDate.setText(vinetki.getStartDate());
            editEndDate.setText(vinetki.getEndDate());
            editStatus.setText(vinetki.getStatus());
            editSum.setText(vinetki.getSum());

            btnDelete.setOnClickListener(v1 -> {
                Thread thread = new Thread(() -> {
                    VinetkaDatebase.getInstance((getContext()))
                            .vinetkaDao().deleteVinetka(vinetki.getId());
                    getActivity().runOnUiThread(() -> {
                        vinetkaDeleted.vinetkadeleted(vinetki.getId());
                    });
                });
                thread.start();
            });

            btnUpdate.setOnClickListener(v1 -> {
                Thread thread = new Thread(() -> {
                    VinetkaDatebase.getInstance((getContext()))
                            .vinetkaDao()
                            .updateVinetka(vinetki.getId(), editVinetkaNumber.getText().toString(),
                                    editCarClass.getText().toString(), editEmissionClass.getText().toString(),
                                    editStartDate.getText().toString(), editEndDate.getText().toString(),
                                    editSum.getText().toString(), editStatus.getText().toString());
                    getActivity().runOnUiThread(() -> {
                        vinetkaUpdate.vinetkaUpdate(vinetki.getId());
                    });
                });
                thread.start();
            });

        v.findViewById(R.id.btnQrCode).setOnClickListener(view->{
            Bundle bundle = new Bundle();
            bundle.putString("VinetkaNumber", editVinetkaNumber.getText().toString());
            bundle.putString("EndDate", editEndDate.getText().toString());
            Intent intent = new Intent(getActivity(), QRCodeActivity.class);
            intent.putExtras(bundle);
            startActivity(intent, bundle);
        });


        return v;
    }
}