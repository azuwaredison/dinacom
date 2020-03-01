package azuwaredison89.gmail.dinacom.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import azuwaredison89.gmail.dinacom.R;
<<<<<<< HEAD
//import azuwaredison89.gmail.dinacom.api.PrefManager;
//import azuwaredison89.gmail.dinacom.api.RequestHandler;
//import azuwaredison89.gmail.dinacom.api.User;
=======
>>>>>>> c97c377032d91fb7242c95c7f98daec27c850dba

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

<<<<<<< HEAD
   /*     if (!PrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, ProfilActivity.class));
        } */


//        User user = PrefManager.getInstance(this).getUser();
//        tv_nama = findViewById(R.id.tv_nama);
//        tv_nama.setText(user.getUsername());
    }
}
      //  btn_foto = (Button) findViewById(R.id.btn_foto);
     //   profile_image = findViewById(R.id.profile_image);



    /*    btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }
        }); */

 /*   private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Pilih Foto"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filepath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                profile_image.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
            UploadPicture(getId, getStringImage(bitmap));

        }
    }

    private void UploadPicture(final String id, final String photo) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu Sebentar");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPLOAD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.i(TAG, response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("Sukses");

                            if (success.equals("1")) {
                                Toast.makeText(ProfilActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(ProfilActivity.this, "Coba Lagi" + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(ProfilActivity.this, "Coba Lagi Deh!" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                })
        {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("id", id);
                    params.put("photo", photo);
                    return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
=======
>>>>>>> c97c377032d91fb7242c95c7f98daec27c850dba
    }

}

