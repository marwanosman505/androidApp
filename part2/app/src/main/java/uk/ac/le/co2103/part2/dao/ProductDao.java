package uk.ac.le.co2103.part2.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import uk.ac.le.co2103.part2.domain.Product;

@Dao
public interface ProductDao {
    @Insert
    void insert(Product product);

    @Query("DELETE FROM products")
    void deleteAll();

    @Query("SELECT * FROM products ORDER BY name ASC")
    LiveData<List<Product>> getShoppingList();
}
