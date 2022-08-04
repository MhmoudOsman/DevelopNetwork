package com.developnetwork.mahmoud.ui.homescreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.developnetwork.mahmoud.R;
import com.developnetwork.mahmoud.databinding.ItemProductBinding;
import com.developnetwork.mahmoud.service.models.ProductModel;
import com.developnetwork.mahmoud.ui.dialog.ProductDialog;

import java.util.List;

/*** Created by Mahmoud Osman on 8/4/2022 
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.item_product> {

    private final Context context;
    private final List<ProductModel> list_of_products;

    public ProductAdapter(List<ProductModel> list_of_products, Context context) {
        this.list_of_products = list_of_products;
        this.context = context;
    }

    @NonNull
    @Override
    public item_product onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        ItemProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_product, parent, false);

        return new item_product(binding, context);
    }

    @Override
    public void onBindViewHolder(@NonNull item_product holder, int position) {
        ProductModel model = list_of_products.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        if (list_of_products == null) {
            return 0;
        }
        return list_of_products.size();
    }

    static class item_product extends RecyclerView.ViewHolder {
        ItemProductBinding itemView;
        Context context;

        item_product(ItemProductBinding itemView, Context context) {
            super(itemView.getRoot());
            this.itemView = itemView;
            this.context = context;
        }

        void bind(ProductModel model) {
            itemView.setModel(model);
            itemView.productItem.setOnClickListener(v -> {
                new ProductDialog(context, model).show();
            });
        }

    }

    // Wont Create
}