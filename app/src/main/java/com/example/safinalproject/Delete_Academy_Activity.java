package com.example.safinalproject;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Delete_Academy_Activity extends AppCompatActivity {

    private EditText editTextName;
    private TextView textViewPhoneNumber;
    private TextView textViewLocation;
    private ImageView imageViewAcademy;
    private Button buttonDelete;
    private Button buttonSearch;
    private TextView textViewAcademyId;

    private Databasehelper databaseHelper;
    private byte[] academyImageByteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_academy);

        editTextName = findViewById(R.id.edit_text_academy_name);
        textViewPhoneNumber = findViewById(R.id.text_view_phone_number);
        textViewLocation = findViewById(R.id.text_view_academy_location);
        textViewAcademyId = findViewById(R.id.text_view_academy_id);
        imageViewAcademy = findViewById(R.id.image_view_academy);
        buttonDelete = findViewById(R.id.button_delete);
        buttonSearch = findViewById(R.id.button_search);

        databaseHelper = new Databasehelper(this);

        buttonSearch.setOnClickListener(view -> searchAcademy());
        buttonDelete.setOnClickListener(view -> deleteAcademy());
    }

    private void searchAcademy() {
        String academyName = editTextName.getText().toString().trim();
        if (academyName.isEmpty()) {
            Toast.makeText(this, "Please enter an academy name to search", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor cursor = databaseHelper.getProductByName(academyName);
        if (cursor != null && cursor.moveToFirst()) {
            int academyId = cursor.getInt(cursor.getColumnIndexOrThrow(Databasehelper.COL_ID));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(Databasehelper.COL_ACADEMY_PHONE));
            String location = cursor.getString(cursor.getColumnIndexOrThrow(Databasehelper.COL_ACADEMY_LOCATION));
            byte[] image = cursor.getBlob(cursor.getColumnIndexOrThrow(Databasehelper.COL_PRODUCT_IMAGE_URI));

            textViewPhoneNumber.setText(phone);
            textViewLocation.setText(location);
            textViewAcademyId.setText("Academy ID: " + academyId);

            if (image != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                imageViewAcademy.setImageBitmap(bitmap);
                academyImageByteArray = image;
            }
            cursor.close();
        } else {
            Toast.makeText(this, "Academy not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteAcademy() {
        String academyName = editTextName.getText().toString().trim();

        if (academyName.isEmpty()) {
            Toast.makeText(this, "Please enter an academy name to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        databaseHelper.deleteProduct(academyName);
        Toast.makeText(this, "Academy deleted", Toast.LENGTH_SHORT).show();
    }
}