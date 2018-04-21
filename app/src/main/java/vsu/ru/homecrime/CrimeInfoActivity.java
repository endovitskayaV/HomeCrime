package vsu.ru.homecrime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import vsu.ru.homecrime.model.DataKeeper;


public class CrimeInfoActivity extends AppCompatActivity {
    public static final String CRIME_KEY = "vsu.ru.homecrime.selectedCrimeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return CrimeInfoFragment.newInstance(position);
            }
            @Override
            public int getCount() {
                return DataKeeper.getNewInstance().getCrimeList().size();
            }
        });

        viewPager.setCurrentItem(getIntent().getIntExtra(CRIME_KEY, 1));
    }

    public static Intent newIntent(Context packageContext, int crimeId) {
        Intent i = new Intent(packageContext, CrimeInfoActivity.class);
        i.putExtra(CRIME_KEY, crimeId);
        return i;
    }
}
