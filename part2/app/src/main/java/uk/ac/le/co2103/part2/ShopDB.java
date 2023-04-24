package uk.ac.le.co2103.part2;


import android.content.ClipData;
import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import uk.ac.le.co2103.part2.Product;
import uk.ac.le.co2103.part2.ProductDao;

//@Database(entities = {ClipData.Item.class}, version = 1, exportSchema = false)
@Database(entities = {ShoppingList.class, Product.class}, version = 1, exportSchema = false)
public abstract class ShopDB extends RoomDatabase {

    public abstract ProductDao productDao();
    public abstract ShoppingListDao shoppingListDao();

    private static volatile ShopDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ShopDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ShopDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ShopDB.class, "shoppingcart_db")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                ShoppingListDao shopDao = INSTANCE.shoppingListDao();
                ProductDao productDao = INSTANCE.productDao();

                productDao.deleteAll();
                shopDao.deleteAll();

                ShoppingList shoppingList = new ShoppingList("Tescos");
                shoppingList.setListId(1);
                shopDao.insert(shoppingList);
                Product product = new Product("Milk");
                Product product2 = new Product("Bread");

                product.setListId(1);
                product2.setListId(1);

                productDao.insert(product);
                productDao.insert(product2);
            });
        }
    };
}