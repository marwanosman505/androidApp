package uk.ac.le.co2103.part2.domain;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import uk.ac.le.co2103.part2.domain.ShoppingList;

@Entity(
        tableName = "products",
        primaryKeys = { "listId", "name" },
        foreignKeys = {
            @ForeignKey(entity = ShoppingList.class,
                parentColumns = "listId",
                childColumns = "listId",
                onDelete = CASCADE)
        },
        indices = {
            @Index(value = {"listId", "name"}, unique = true)
        }
        )
public class Product {

    @NonNull
    private String name;
    private int quantity;
    private long listId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public Product(@NonNull String name) {
        this.name = name;
    }

}
