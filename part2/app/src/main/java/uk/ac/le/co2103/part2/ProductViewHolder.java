package uk.ac.le.co2103.part2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private final TextView listTextView;
    public long listId;

    private ProductViewHolder(View itemView) {
        super(itemView);
        listTextView = itemView.findViewById(R.id.textView);
        listTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--------------->clicked");
//                Intent intent = new Intent(ShoppingViewHolder.this, ShoppingListActivity.class);
//                startActivity(intent);
            }
        });
    }


    public void bind(String text) {
        listTextView.setText(text);
    }

    static ProductViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ProductViewHolder(view);
    }
}