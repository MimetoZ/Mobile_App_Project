package com.example.projecv;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projecv.modles.Vinetki;
import com.example.projecv.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.projecv.databinding.FragmentListViewBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyIListViewAdapter extends RecyclerView.Adapter<MyIListViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;

    public MyIListViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentListViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.viewVinetkaNumber.setText(mValues.get(position).vinetkaNumber);
        holder.viewCarClass.setText(mValues.get(position).carClass);
        holder.viewEmissionClass.setText(mValues.get(position).emissionClass);
        holder.viewStartDate.setText(mValues.get(position).startDate);
        holder.viewEndDate.setText(mValues.get(position).endDate);
        holder.viewSum.setText(mValues.get(position).sum);
        holder.viewStatus.setText(mValues.get(position).status);
        holder.viewId.setText(mValues.get(position).id);

        holder.itemView.setOnClickListener(view->{
            Fragment fragment = new UpdateDeleteFragment();

            Vinetki v = VinetkaBuilder.Build(
                    Integer.parseInt(holder.viewId.getText().toString()),
                    holder.viewVinetkaNumber.getText().toString(),
                    holder.viewCarClass.getText().toString(),
                    holder.viewEmissionClass.getText().toString(),
                    holder.viewStartDate.getText().toString(),
                    holder.viewEndDate.getText().toString(),
                    holder.viewSum.getText().toString(),
                    holder.viewStatus.getText().toString()
            );

            Bundle b = new Bundle();
            b.putSerializable("vinetka", v);

            fragment.setArguments(b);
            ((MainActivity)view.getContext())
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_update_delete_container, fragment)
                    .addToBackStack(null)
                    .commit();

        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public PlaceholderItem mItem;

        public final TextView viewVinetkaNumber, viewCarClass, viewEmissionClass,
        viewStartDate, viewEndDate, viewSum, viewStatus, viewId;

        public ViewHolder(FragmentListViewBinding binding) {
            super(binding.getRoot());
            viewVinetkaNumber = binding.VinetkaNumber;
            viewCarClass = binding.CarClass;
            viewEmissionClass = binding.EmissionClass;
            viewStartDate = binding.StartDate;
            viewEndDate = binding.EndDate;
            viewSum = binding.Sum;
            viewStatus = binding.Status;
            viewId = binding.Id;
        }

        @Override
        public String toString(){
            return viewVinetkaNumber.getText().toString()+"\t"
                    +viewCarClass.getText().toString()+"\t"
                    +viewEmissionClass.getText().toString()+"\t"
                    +viewStartDate.getText().toString()+"\t"
                    +viewEndDate.getText().toString()+"\t"
                    +viewSum.getText().toString()+"\t"
                    +viewStatus.getText().toString();
        }
    }
}