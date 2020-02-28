package azuwaredison89.gmail.dinacom.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import azuwaredison89.gmail.dinacom.R;

public class NextActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tv = (TextView) findViewById(R.id.tv);

        for (int i = 0; i < CustomeAdapter.editModelArrayList.size(); i++){

            tv.setText(tv.getText() + " " + CustomeAdapter
                    .editModelArrayList.get(i)
                    .getEditTextValue() +System
                    .getProperty("line.separator"));
        }
    }
}
