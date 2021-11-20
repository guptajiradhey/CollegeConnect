package com.example.collegeconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collegeconnect.Uttils.Tools;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreenActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    Fragment selectedFragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Tools.setSystemBarColor(this, R.color.royalBlue);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        Tools.setSystemBarColor(HomeScreenActivity.this, R.color.royalBlue);

                        navigation.setBackgroundColor(getResources().getColor(R.color.royalBlue));
                        break;
                    case R.id.explore:
                        selectedFragment = new ExploreCommunityFragment();
                        Tools.setSystemBarColor(HomeScreenActivity.this, R.color.pink_800);

                        navigation.setBackgroundColor(getResources().getColor(R.color.pink_800));
                        break;
                    case R.id.create:
                        selectedFragment = new CreateandManageFragment();
//                        mTextMessage.setText(item.getTitle());
                        Tools.setSystemBarColor(HomeScreenActivity.this, R.color.blue_grey_700);

                        navigation.setBackgroundColor(getResources().getColor(R.color.blue_grey_700));
                        break;
                    case R.id.profile:
                        selectedFragment = new ProfileFragment();
                        Tools.setSystemBarColor(HomeScreenActivity.this, R.color.teal_800);

                        navigation.setBackgroundColor(getResources().getColor(R.color.teal_800));

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                return true;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();


    }


    private void initComponent() {


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        navigation.setBackgroundColor(getResources().getColor(R.color.blue_600));
                        return true;
                    case R.id.explore:
                        navigation.setBackgroundColor(getResources().getColor(R.color.pink_800));
                        return true;
                    case R.id.create:
//                        mTextMessage.setText(item.getTitle());
                        navigation.setBackgroundColor(getResources().getColor(R.color.blue_grey_700));
                        return true;
                    case R.id.profile:
                        navigation.setBackgroundColor(getResources().getColor(R.color.teal_800));
                        return true;
                }
                return false;
            }
        });

        /*
        NestedScrollView nested_content = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        nested_content.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY < oldScrollY) { // up
                    animateNavigation(false);
//                    animateSearchBar(false);
                }
                if (scrollY > oldScrollY) { // down
                    animateNavigation(true);
//                    animateSearchBar(true);
                }
            }
        });


        // display image


    }

    boolean isNavigationHide = false;

    private void animateNavigation(final boolean hide) {
        if (isNavigationHide && hide || !isNavigationHide && !hide) return;
        isNavigationHide = hide;
        int moveY = hide ? (2 * navigation.getHeight()) : 0;
        navigation.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
    }

         */

    }
}