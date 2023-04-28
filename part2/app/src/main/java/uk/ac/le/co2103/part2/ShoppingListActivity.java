package uk.ac.le.co2103.part2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;
    private static final String TAG = ShoppingListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        setContentView(R.layout.product_list);

        Log.d(TAG, "Creating recyclerView");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ProductListAdapter adapter = new ProductListAdapter(new ProductListAdapter.ProductDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d(TAG, "Adding items to adapter");
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        productViewModel.getAllItems().observe(this, items -> {
            adapter.submitList(items);
        });


    }
}
