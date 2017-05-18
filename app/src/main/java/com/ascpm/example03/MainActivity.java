package com.ascpm.example03;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import layout.FragmentFirst;
import layout.FragmentFourth;
import layout.FragmentSecond;
import layout.FragmentThird;
import layout.FragmentWeb;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager contentViewPager;
    private Button contentButton01;
    private Button contentButton02;
    private Button contentButton03;
    private Button contentButton04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        event();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.itemButton:
                this.contentViewPager.setCurrentItem(4);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navButton01) {
            this.contentViewPager.setCurrentItem(0);
        } else if (id == R.id.navButton02) {
            this.contentViewPager.setCurrentItem(1);
        } else if (id == R.id.navButton03) {
            this.contentViewPager.setCurrentItem(2);
        } else if (id == R.id.navButton04) {
            this.contentViewPager.setCurrentItem(3);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init() {
        this.contentViewPager = ViewPager.class.cast(findViewById(R.id.contentViewPager));
        this.contentViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new FragmentFirst();
                    case 1:
                        return new FragmentSecond();
                    case 2:
                        return new FragmentThird();
                    case 3:
                        return new FragmentFourth();
                    case 4:
                        return new FragmentWeb();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        this.contentViewPager.setCurrentItem(0);
        this.contentButton01 = Button.class.cast(findViewById(R.id.contentButton01));
        this.contentButton01.setTag(0);
        this.contentButton02 = Button.class.cast(findViewById(R.id.contentButton02));
        this.contentButton02.setTag(1);
        this.contentButton03 = Button.class.cast(findViewById(R.id.contentButton03));
        this.contentButton03.setTag(2);
        this.contentButton04 = Button.class.cast(findViewById(R.id.contentButton04));
        this.contentButton04.setTag(3);
    }

    private void event() {
        this.contentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String text;

                switch (position) {
                    case 0:
                        text = getResources().getString(R.string.content_button_01);
                        break;
                    case 1:
                        text = getResources().getString(R.string.content_button_02);
                        break;
                    case 2:
                        text = getResources().getString(R.string.content_button_03);
                        break;
                    case 3:
                        text = getResources().getString(R.string.content_button_04);
                        break;
                    case 4:
                        text = getResources().getString(R.string.action_item);
                        break;
                    default:
                        text = "";
                }

                TextView.class.cast(findViewById(R.id.navHeaderTextView)).setText(text);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        View.OnClickListener clickListener = v -> this.contentViewPager.setCurrentItem(Integer.class.cast(v.getTag()));
        this.contentButton01.setOnClickListener(clickListener);
        this.contentButton02.setOnClickListener(clickListener);
        this.contentButton03.setOnClickListener(clickListener);
        this.contentButton04.setOnClickListener(clickListener);
    }
}
