package vsu.ru.homecrime;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.frame_layout);
        if (fragment == null) {
            fragment = new MainFragment();
            fragmentManager.beginTransaction().add(R.id.frame_layout, fragment).commit();
        }
    }
}
