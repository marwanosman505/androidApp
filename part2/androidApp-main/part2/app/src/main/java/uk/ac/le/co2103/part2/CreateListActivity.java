package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CreateListActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private EditText editListName;
    private Button btnLoadImage;
    private ImageView imageView;
    private Button btnCreate;
    private Uri imageUri;
    private ShoppingViewModel shoppingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        editListName = findViewById(R.id.edit_list_name);
        btnLoadImage = findViewById(R.id.btn_load_image);
        imageView = findViewById(R.id.image_view);
        btnCreate = findViewById(R.id.btn_create);

        shoppingViewModel = new ViewModelProvider(this).get(ShoppingViewModel.class);

        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String listName = editListName.getText().toString().trim();
                if (listName.isEmpty()) {
                    Toast.makeText(CreateListActivity.this, "Please enter a list name", Toast.LENGTH_SHORT).show();
                } else {
                    ShoppingList shoppingList = new ShoppingList(listName);
                    if (imageUri != null) {
                        byte[] imageByteArray = uriToByteArray(imageUri);
                        shoppingList.setImage(imageByteArray);
                    }

                    shoppingViewModel.insert(shoppingList);
                    Toast.makeText(CreateListActivity.this, "List created", Toast.LENGTH_SHORT).show();
                    finish(); // Close the activity and navigate back to the main activity
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(CreateListActivity.this, "Error loading image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private byte[] uriToByteArray(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
