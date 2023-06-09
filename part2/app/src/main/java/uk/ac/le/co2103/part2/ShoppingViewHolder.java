package uk.ac.le.co2103.part2;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingViewHolder extends RecyclerView.ViewHolder {
    private final TextView listTextView;
    private final Context context;

    public long listId;

    private ShoppingViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;

        listTextView = itemView.findViewById(R.id.textView);
        listTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--------------->clicked"+listId);
                Intent intent = new Intent(context, ShoppingListActivity.class);
                context.startActivity(intent);
            }
        });
    }


    public void bind(String text) {
        listTextView.setText(text);
    }

    static ShoppingViewHolder create(ViewGroup parent, Context context) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ShoppingViewHolder(view, context);
    }
}
