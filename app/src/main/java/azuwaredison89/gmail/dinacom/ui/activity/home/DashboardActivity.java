package azuwaredison89.gmail.dinacom.ui.activity.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import azuwaredison89.gmail.dinacom.ui.fragment.*;
import azuwaredison89.gmail.dinacom.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_pesan:
                        selectedFragment = new PesanFragment();
                        break;
                    case R.id.nav_profil:
                        selectedFragment = new ProfilFragment();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (selectedFragment != null) {
                    transaction.replace(R.id.fl_container, selectedFragment);
                    transaction.commit();
                }
                return true;
            }
        });

        //Manually displaying the first fragment - one time only
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fl_container, new HomeFragment());
            transaction.commit();
        }
    }
}

