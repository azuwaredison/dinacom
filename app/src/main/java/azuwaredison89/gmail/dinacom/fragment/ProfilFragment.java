package azuwaredison89.gmail.dinacom.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.HashMap;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.activity.LoginActivity;
import azuwaredison89.gmail.dinacom.activity.PengaturanActivity;
import azuwaredison89.gmail.dinacom.activity.ProfilActivity;
import azuwaredison89.gmail.dinacom.api.PrefManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {
    Button pengaturan, metode, profil;
    public static final String TAG_USERNAME = "username";
    TextView tv_nama;
    String username;

    public ProfilFragment() {
        // Required empty public constructor
    }

    public static ProfilFragment newInstance() {
        ProfilFragment fragment = new ProfilFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profil, container, false);

        pengaturan = (Button) v.findViewById(R.id.pengaturan);
        profil = (Button) v.findViewById(R.id.profil);

        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data();
            }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profil();
            }
        });
        return v;
    }

    private void data() {
        Intent pengaturan = new Intent(getActivity().getBaseContext(),
                PengaturanActivity.class);
        startActivity(pengaturan);
    }

    private void Profil() {
        Intent profil = new Intent(getActivity().getBaseContext(),
                ProfilActivity.class);
        startActivity(profil);
    }
}
