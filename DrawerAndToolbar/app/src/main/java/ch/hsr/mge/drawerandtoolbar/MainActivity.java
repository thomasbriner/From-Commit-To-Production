package ch.hsr.mge.drawerandtoolbar;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        content = findViewById(R.id.content);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        getFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, new SettingsFragment())
                        .commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawerHome:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, new HomeFragment())
                        .commit();
                break;
            case R.id.drawerBookmarks:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, new BookmarksFragment())
                        .commit();
                break;
            case R.id.drawerUpload:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, new UploadFragment())
                        .commit();
                break;
            case R.id.drawerPlugins:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, new PluginsFragment())
                        .commit();
                break;
        }

        mkSnack();
        item.setChecked(true);
        drawer.closeDrawers();
        return true;
    }

    private void mkSnack() {
        Snackbar snackbar = Snackbar.make(content, "Hello MGE!", Snackbar.LENGTH_LONG);
        snackbar.setAction("Do it again!", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mkSnack();
            }
        });
        snackbar.show();
    }
}
