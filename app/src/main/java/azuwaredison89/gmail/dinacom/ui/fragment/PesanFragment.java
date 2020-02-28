package azuwaredison89.gmail.dinacom.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import azuwaredison89.gmail.dinacom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesanFragment extends Fragment {

    Button kembali, hapus;


    public PesanFragment() {
        // Required empty public constructor
    }

    public static PesanFragment newInstance() {
        PesanFragment fragment = new PesanFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View r =  inflater.inflate(R.layout.fragment_pesan, container, false);

        kembali = (Button) r.findViewById(R.id.kembali);
        hapus = (Button) r.findViewById(R.id.hapus);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return r;
    }
}
