package uk.ac.le.co2103.part2;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;


public class ProductRepository {
    private ProductDao productDao;
    private LiveData<List<Product>> allItems;

    ProductRepository(Application application) {
        ShopDB db = ShopDB.getDatabase(application);
        productDao = db.productDao();
        allItems = productDao.getShoppingList();
    }

    LiveData<List<Product>> getAllItems() {
        return allItems;
    }

    void insert(Product item) {
        ShopDB.databaseWriteExecutor.execute(() -> {
            productDao.insert(item);
        });
    }
}
