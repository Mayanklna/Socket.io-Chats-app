package com.example.socketdemo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




public class inbox_activity extends AppCompatActivity implements InboxAdapter.ListItemClickListener {

    private RecyclerView inboxList;
    private ImageView img;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    androidx.appcompat.app.ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_activity);



        inboxList = (RecyclerView) findViewById(R.id.inbox_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        inboxList.setLayoutManager(layoutManager);
        inboxList.setHasFixedSize(true);


        // Since the data set is not available this array is used to in place of username, this arrya is passed to the adapter for now
        String[] a={"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};

        inboxList.setAdapter( new InboxAdapter(this,a));


    }


    @Override
    public void onListItemClick(String username, TextView message) {
        Intent intentToStartChat =new Intent(inbox_activity.this, MainActivity.class);
        intentToStartChat.putExtra( "username", username);
        startActivity(intentToStartChat);
        message.setTextColor(Color.parseColor("#c9c9c9"));

    }



}