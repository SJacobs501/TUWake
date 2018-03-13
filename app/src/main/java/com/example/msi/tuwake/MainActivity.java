package com.example.msi.tuwake;

import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class
MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, AlarmsFragment.OnFragmentInteractionListener, LocationFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.navigation_alarms:
                    fragment = new AlarmsFragment();
                    break;

                case R.id.navigation_location:
                    fragment = new LocationFragment();
                    break;

                default:
                    return false;
            }

            startFragment(fragment);
            return true;
        }
    };

    private void startFragment(Fragment fragment) {
        FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment,"fragment");
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Start default fragment.
        startFragment(new HomeFragment());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
