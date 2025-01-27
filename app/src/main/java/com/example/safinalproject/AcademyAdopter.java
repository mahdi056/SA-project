package com.example.safinalproject;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AcademyAdopter extends CursorAdapter {


    public AcademyAdopter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.activity_academy_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = view.findViewById(R.id.text_view_Academy_name);
        TextView phoneTextView = view.findViewById(R.id.text_view_Academy_Phone);
        TextView locationTextView = view.findViewById(R.id.text_view_Academy_Location);
        ImageView productImageView = view.findViewById(R.id.image_view_Academy);

        String name = cursor.getString(cursor.getColumnIndexOrThrow(Databasehelper.COL_ACADEMY_NAME));
        String phone = cursor.getString(cursor.getColumnIndexOrThrow(Databasehelper.COL_ACADEMY_PHONE));
        String location = cursor.getString(cursor.getColumnIndexOrThrow(Databasehelper.COL_ACADEMY_LOCATION));
        byte[] imageBytes = cursor.getBlob(cursor.getColumnIndexOrThrow(Databasehelper.COL_PRODUCT_IMAGE_URI));

        // Set text and image
        nameTextView.setText(name);
        phoneTextView.setText(phone);
        locationTextView.setText(location);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        productImageView.setImageBitmap(bitmap);


    }

}