package com.example.projecv;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity
implements OnVinetkaInsertedListener, onVinetkaUpdate, onVinetkaDeleted
{
    ListViewFragment listViewFragment;
    InsertFragment insertFragment;

    private void loadFragment(Fragment fragment, int containerId){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            listViewFragment = new ListViewFragment();
            insertFragment = new InsertFragment();
            loadFragment(insertFragment, R.id.fragment_insert_container);
            loadFragment(listViewFragment, R.id.fragment_list_container);
        }
    }

    @Override
    public void OnVinetkaInserted() {
        if(listViewFragment != null){
            listViewFragment.reloadData();
        }
    }

    @Override
    public void vinetkadeleted(int id) {
        if(listViewFragment != null){
            listViewFragment.reloadData();
        }
    }

    @Override
    public void vinetkaUpdate(int id) {
        if(listViewFragment != null){
            listViewFragment.reloadData();
        }
    }
}