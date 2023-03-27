package com.shuchi.s20240323_shuchisinha_nycschools.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shuchi.s20240323_shuchisinha_nycschools.R;
import com.shuchi.s20240323_shuchisinha_nycschools.model.SchoolViewModel;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    
    private SchoolViewModel mSchoolViewModel;
    private SchoolListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter = new SchoolListAdapter(new SchoolListAdapter.SchoolDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        mSchoolViewModel = new ViewModelProvider(this).get(SchoolViewModel.class);

        // Update the cached copy of the words in the adapter.
        mSchoolViewModel.getAllSchools().observe(this, adapter::submitList);
        mSchoolViewModel.loadSchools();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.menu, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_refresh) {
            mSchoolViewModel.loadSchools();
            return true;
        }
        else if (id == R.id.action_search){
            SearchView searchView = (SearchView) item.getActionView();
            searchView.setOnQueryTextListener(this);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // Updates Search filter and runs DB Query using search string non capitalized.
        // We can additional for the entire Data instead
        newText = "%"+newText.toLowerCase()+"%";
        mSchoolViewModel.getFilteredSchools(newText).observe(this,
                adapter::submitList);
        return true;
    }
}