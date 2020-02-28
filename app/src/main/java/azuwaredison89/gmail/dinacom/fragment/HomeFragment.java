package azuwaredison89.gmail.dinacom.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.puskesmas.DaftarNamaPerawatActivity;
import azuwaredison89.gmail.dinacom.puskesmas.DokterActivity;
import azuwaredison89.gmail.dinacom.puskesmas.PerawatActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button dokter, perawat;

    ViewFlipper viewFlipper;
    FragmentManager fragmentManager;
    int gallery_grid_Images[] = {R.drawable.dokter, R.drawable.perawat, R.drawable.dokter1};

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        viewFlipper = (ViewFlipper)rootView.findViewById(R.id.v_flipper1);
        perawat = (Button) rootView.findViewById(R.id.perawat);
        dokter = (Button) rootView.findViewById(R.id.dokter);

        perawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_perawat();
            }
        });
        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });


        for(int i=0; i<gallery_grid_Images.length; i++){
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(gallery_grid_Images[i]);
        }
        return rootView;
    }

    private void sendData() {
        Intent dokter = new Intent(getActivity().getBaseContext(),
                DokterActivity.class);
        startActivity(dokter);
    }

    private void btn_perawat() {
        Intent perawat = new Intent(getActivity().getBaseContext(),
                DaftarNamaPerawatActivity.class);
        startActivity(perawat);
    }

    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }

}
