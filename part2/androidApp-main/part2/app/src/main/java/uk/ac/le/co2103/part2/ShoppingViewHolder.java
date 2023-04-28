package uk.ac.le.co2103.part2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingViewHolder extends RecyclerView.ViewHolder {
    private final TextView listTextView;

    public ImageView shoppingImageView;

    private ShoppingViewHolder(View itemView) {
        super(itemView);
        listTextView = itemView.findViewById(R.id.textView);
        shoppingImageView = itemView.findViewById(R.id.shopping_image);
    }

    public void bind(String text) {
        listTextView.setText(text);
    }

    static ShoppingViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ShoppingViewHolder(view);
    }
}
