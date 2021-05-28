package com.example.wattsup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.example.wattsup.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);

        tabLayout = findViewById(R.id.tab);

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }

    public class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(@NonNull FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @NonNull

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Calls();
                case 1:
                    return new Chats();
                case 2:
                    return new Status();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Calls";
                case 1:return "Chats";
                case 2:return "Status";


            }

            return super.getPageTitle(position);
        }
    }
}


