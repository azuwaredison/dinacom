package azuwaredison89.gmail.dinacom.ui.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.ui.activity.pesanperawat.DaftarNamaPerawatActivity;
import azuwaredison89.gmail.dinacom.ui.activity.pesandokter.DokterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;

    private int[] gallery_grid_Images = {R.drawable.dokter, R.drawable.perawat, R.drawable.dokter1};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewFlipper = view.findViewById( R.id.v_flipper1);

        Button perawat = view.findViewById(R.id.perawat);
        Button dokter = view.findViewById(R.id.dokter);

        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotToDockerActivity();
            }
        });

        perawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPerawatActivity();
            }
        });

        for (int gallery_grid_image : gallery_grid_Images) {
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(gallery_grid_image);
        }
    }

    private void gotToDockerActivity() {
        Intent dokter = new Intent(getActivity(), DokterActivity.class);
        startActivity(dokter);
    }

    private void goToPerawatActivity() {
        Intent perawat = new Intent(getActivity(), DaftarNamaPerawatActivity.class);
        startActivity(perawat);
    }

    private void setFlipperImage(int res) {
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
    }
}
