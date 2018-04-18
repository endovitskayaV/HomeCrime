package vsu.ru.homecrime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import vsu.ru.homecrime.model.Crime;
import vsu.ru.homecrime.model.DataKeeper;


public class CrimeInfoActivity extends FragmentActivity {
    public static final String CRIME_KEY = "vsu.ru.homecrime.crime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_info);



        ViewPager viewPager=findViewById(R.id.view_pager);
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

         viewPager.setCurrentItem(((Crime) getIntent().getSerializableExtra(CRIME_KEY)).getId());



//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_layout);
//        if (fragment == null) {
//            fragmentManager.beginTransaction()
//                    .add(R.id.frame_layout,
//                    CrimeInfoFragment.newInstance(((Crime) getIntent().getSerializableExtra(CRIME_KEY)).getId())).commit();
//        }
    }

    public static Intent newIntent(Context packageContext, Crime crime) {
        Intent i = new Intent(packageContext, CrimeInfoActivity.class);
        i.putExtra(CRIME_KEY, crime);
        return i;
    }
}
