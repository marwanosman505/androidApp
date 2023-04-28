package uk.ac.le.co2103.part2;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.jar.Attributes;

import lombok.Data;

@Entity(
        tableName = "products",
        foreignKeys = {
            @ForeignKey(entity = ShoppingList.class,
                parentColumns = "listId",
                childColumns = "shoppingId",
                onDelete = ForeignKey.CASCADE)
        },
        indices = {
            @Index(value = {"shoppingId", "name"}, unique = true)
        }
        )
public class Product {

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "quantity")
    private int quantity;
    @ColumnInfo(name = "unit")
    public String unit;
    @ColumnInfo(name = "shoppingId")
    public int shoppingId;

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


    public Product(@NonNull String name, int quantity, String unit, int shoppingId) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.shoppingId = shoppingId;

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
