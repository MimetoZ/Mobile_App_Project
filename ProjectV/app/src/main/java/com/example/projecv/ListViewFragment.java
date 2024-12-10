package com.example.projecv;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projecv.database.VinetkaDatebase;
import com.example.projecv.modles.Vinetki;
import com.example.projecv.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ListViewFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListViewFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListViewFragment newInstance(int columnCount) {
        ListViewFragment fragment = new ListViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    public void reloadData(){
        Thread t = new Thread(()->{
            List<Vinetki> vinetkis = VinetkaDatebase.getInstance(getActivity())
                    .vinetkaDao().getAllContacts();
            List<PlaceholderContent.PlaceholderItem> items =
                    new ArrayList<>();
            for(Vinetki v: vinetkis){
                items.add(new PlaceholderContent.PlaceholderItem(
                        ""+v.getId(), v.getVinetkaNumber(), v.getCarClass(),
                        v.getEmissionClass(), v.getStartDate(), v.getStartDate(),
                        v.getSum(), v.getStatus()
                ));
            }
            getActivity().runOnUiThread(()->{
                MyIListViewAdapter adapter = new MyIListViewAdapter(items);
                recyclerView.setAdapter(adapter);
            });
        });
        t.start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //recyclerView.setAdapter(new MyIListViewAdapter(PlaceholderContent.ITEMS));
            reloadData();
        }
        return view;
    }
}