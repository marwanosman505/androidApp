package uk.ac.le.co2103.part2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListsRecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
//    private ShoppingViewModel shoppingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        setContentView(R.layout.recyclerview_item);

        SpannableString ss = new SpannableString("hello");

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(ListsRecyclerViewActivity.this, "One", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(ListsRecyclerViewActivity.this, "Two", Toast.LENGTH_SHORT).show();
            }
        };

        ss.setSpan(clickableSpan1, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan2, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Java file for first activity
        TextView ShoppingTextView = findViewById(R.id.textView);
//        ShoppingTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("--------------->clicked");
//                Intent intent = new Intent(ListsRecyclerViewActivity.this, ShoppingListActivity.class);
//                startActivity(intent);
//            }
//        });

        ShoppingTextView.setText(ss);
        ShoppingTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
