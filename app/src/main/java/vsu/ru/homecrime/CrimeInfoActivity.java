package vsu.ru.homecrime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import vsu.ru.homecrime.model.Crime;



public class CrimeInfoActivity extends FragmentActivity {
    public static final String CRIME_KEY = "vsu.ru.homecrime.crime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_info);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_layout);
        if (fragment == null) {
            fragment = new CrimeInfoFragment();
            Bundle bundle=new Bundle();
            bundle.putSerializable(CRIME_KEY, getIntent().getSerializableExtra(CRIME_KEY));
            fragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.frame_layout, fragment).commit();
        }
    }


    public static Intent newIntent(Context packageContext, Crime crime) {
        Intent i = new Intent(packageContext, CrimeInfoActivity.class);
        i.putExtra(CRIME_KEY, crime);
        return i;
    }
}
