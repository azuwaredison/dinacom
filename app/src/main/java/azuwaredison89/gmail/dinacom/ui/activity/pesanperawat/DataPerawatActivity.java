package azuwaredison89.gmail.dinacom.ui.activity.pesanperawat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import azuwaredison89.gmail.dinacom.R;
import azuwaredison89.gmail.dinacom.model.CobaActivity;

public class DataPerawatActivity extends AppCompatActivity {

    private Button lanjutkan_perawat;

    public static final String EXTRA_PLAYER = "extra_player;";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_perawat);

        lanjutkan_perawat = findViewById(R.id.lanjutkan_perawat);
        lanjutkan_perawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPerawatActivity.this, CobaActivity.class);
                startActivity(intent);
            }
        });
    }
}
