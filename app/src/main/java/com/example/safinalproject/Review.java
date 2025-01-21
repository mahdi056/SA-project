package com.example.safinalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Review extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText etReviewComment;
    private Button btnSubmitReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ratingBar = findViewById(R.id.rating_bar);
        etReviewComment = findViewById(R.id.et_review_comment);
        btnSubmitReview = findViewById(R.id.btn_submit_review);

        // Handle review submission
        btnSubmitReview.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String comment = etReviewComment.getText().toString().trim();

            if (comment.isEmpty()) {
                Toast.makeText(this, "Please write a review comment", Toast.LENGTH_SHORT).show();
            } else {
                // You can save this data to a database or send it to a server
                Toast.makeText(this, "Thank You for your feedback\nRating: " + rating + "\nComment: " + comment, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
