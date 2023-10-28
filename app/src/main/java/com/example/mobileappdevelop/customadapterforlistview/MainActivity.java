package com.example.mobileappdevelop.customadapterforlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView profileListView;
    ArrayList<Profile> profiles;
    ProfileAdapter profileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileListView= (ListView) findViewById(R.id.profileListView);
        Profile profile=new Profile();
        profiles=profile.getAllProfile();
        profileAdapter=new ProfileAdapter(this,profiles);
        profileListView.setAdapter(profileAdapter); // this is just a comment
    }
}
