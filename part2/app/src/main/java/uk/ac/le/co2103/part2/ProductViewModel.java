package uk.ac.le.co2103.part2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import uk.ac.le.co2103.part2.domain.Product;
import uk.ac.le.co2103.part2.domain.ShoppingList;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repo;

    private final LiveData<List<Product>> allItems;

    public ProductViewModel(Application application) {
        super(application);
        repo = new ProductRepository(application);
        allItems = repo.getAllItems();
    }

    LiveData<List<Product>> getAllItems() {
        return allItems;
    }

    public void insert(Product list) { repo.insert(list); }
}
