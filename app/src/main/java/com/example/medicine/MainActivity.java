package com.example.medicine;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final int COLTI_FRAGMENT=0;
    private static final int TRIP_HISTORY_FRAGMENT=1;
    private static final int DISCOUNT_FRAGMENT=2;
    private static final int SETTINGS_FRAGMENT=3;
    private static final int HELP_FRAGMENT=4;

    private FrameLayout frameLayout;
    private NavigationView navigationView;
    public static DrawerLayout drawer;

    private Window window;
    private Toolbar toolbar;

    private int currentFragment = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout=(FrameLayout)findViewById(R.id.mainFrameLayoutID);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        gotoFragment(getString(R.string.home_title),new Coltitrip(),COLTI_FRAGMENT);

    }

    @Override
    public void onBackPressed() {
        if (currentFragment == COLTI_FRAGMENT){
            currentFragment = -1;
            super.onBackPressed();
        }else {
            gotoFragment(getString(R.string.home_title), new Coltitrip(),COLTI_FRAGMENT);
            navigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        int id = item.getItemId();

        if (id == R.id.nav_home){
            gotoFragment(getString(R.string.home_title),new Coltitrip(),COLTI_FRAGMENT);
        }else if (id == R.id.nav_trip_hostory){
            gotoFragment(getString(R.string.trip_history_title),new TripHistoryFragment(),TRIP_HISTORY_FRAGMENT);
        }else if (id == R.id.nav_discount){
            gotoFragment(getString(R.string.discount_title),new DiscountFragment(),DISCOUNT_FRAGMENT);
        }else if (id == R.id.nav_setting){
            gotoFragment(getString(R.string.settings_title),new SettingsFragment(),SETTINGS_FRAGMENT);
        }else if (id == R.id.nav_help){
            gotoFragment(getString(R.string.help_title),new HelpFragment(),HELP_FRAGMENT);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void gotoFragment(String title, Fragment fragment, int fragment_no){
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment,fragment_no);
    }

    private void setFragment(Fragment fragment, int fragment_No){
        if (fragment_No != currentFragment){
            currentFragment = fragment_No;

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(frameLayout.getId(),fragment);
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            transaction.commit();
        }
    }
}