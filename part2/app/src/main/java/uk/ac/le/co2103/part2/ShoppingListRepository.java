package uk.ac.le.co2103.part2;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

import uk.ac.le.co2103.part2.dao.ShoppingListDao;
import uk.ac.le.co2103.part2.domain.ShoppingList;


public class ShoppingListRepository {
    private ShoppingListDao shoppingListDao;
    private LiveData<List<ShoppingList>> allItems;

    ShoppingListRepository(Application application) {
        ShopDB db = ShopDB.getDatabase(application);
        shoppingListDao = db.shoppingListDao();
        allItems = shoppingListDao.getShoppingLists();
    }

    LiveData<List<ShoppingList>> getAllItems() {
        return allItems;
    }

    void insert(ShoppingList shoppingList) {
        ShopDB.databaseWriteExecutor.execute(() -> {
            shoppingListDao.insert(shoppingList);
        });
    }
}
