package uk.ac.le.co2103.part2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import uk.ac.le.co2103.part2.domain.ShoppingList;

public class ShoppingViewModel extends AndroidViewModel {
    private ShoppingListRepository repo;

    private final LiveData<List<ShoppingList>> allItems;

    public ShoppingViewModel(Application application) {
        super(application);
        repo = new ShoppingListRepository(application);
        allItems = repo.getAllItems();
    }

    LiveData<List<ShoppingList>> getAllItems() {
        return allItems;
    }

    public void insert(ShoppingList list) { repo.insert(list); }
}
