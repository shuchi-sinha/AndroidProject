package com.shuchi.s20240323_shuchisinha_nycschools.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.shuchi.s20240323_shuchisinha_nycschools.R;
import com.shuchi.s20240323_shuchisinha_nycschools.model.SATScoresViewModel;
import com.shuchi.s20240323_shuchisinha_nycschools.pojo.SATScores;
import com.shuchi.s20240323_shuchisinha_nycschools.pojo.School;

import java.util.Objects;

public class SchoolActivity extends AppCompatActivity {

    private School school;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_school);
        Toolbar toolbar = findViewById(R.id.school_toolbar);
        setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //School object to setup the page
        school = getIntent().getParcelableExtra("School");

        ImageButton directionsButton = findViewById(R.id.directionsButton);
        directionsButton.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:"+school.getLatitude()+","+school.getLongitude()+"?q="+school.getSchool_name());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        ImageButton websiteButton = findViewById(R.id.websiteButton);
        websiteButton.setOnClickListener(v -> {
            Uri websiteIntentUri = Uri.parse(school.getWebsite());
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, websiteIntentUri);
            v.getContext().startActivity(Intent.createChooser(websiteIntent, "Browse with"));
        });
        ImageButton callButton = findViewById(R.id.callButton);
        callButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + school.getPhone_number()));
            startActivity(intent);
        });

        ImageButton emailButton = findViewById(R.id.emailButton);
        emailButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"+school.getSchool_email()));
            v.getContext().startActivity(Intent.createChooser(intent, "Email School "));
        });

        // Setup UI with School object from intent
        TextView schoolNameTextView = findViewById(R.id.schoolNameText);
        TextView descTextView = findViewById(R.id.descriptionText);
        schoolNameTextView.setText(school.getSchool_name());
        schoolNameTextView.setSingleLine(false);
        schoolNameTextView.setHorizontallyScrolling(false);
        descTextView.setText(school.getOverview_paragraph());
        descTextView.setSingleLine(false);
        descTextView.setHorizontallyScrolling(false);

        // Loads SAT Scores for the School
        // private SATScoresViewModel satScoresViewModel;
        SATScoresViewModel satScoresViewModel = new ViewModelProvider(this).get(SATScoresViewModel.class);
        LiveData<SATScores> score = satScoresViewModel.getScoresForSchool(school.getDbn());
        score.observe(this, this::satScoresUpdated);
    }

    /**
     *  Updates the SAT Scores once available from DB
     * @param score calculate score
     */
    private void satScoresUpdated(SATScores score) {
        if (score != null) {
            TextView satScoresTextView = findViewById(R.id.satScoresTextView);
            satScoresTextView.setText(score.toString());
        }
    }

}