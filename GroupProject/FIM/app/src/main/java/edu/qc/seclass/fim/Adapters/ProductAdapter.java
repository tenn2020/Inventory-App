package edu.qc.seclass.fim.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.qc.seclass.fim.ProductActivity;
import edu.qc.seclass.fim.R;
import edu.qc.seclass.fim.models.FloorProduct;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {


    private List<FloorProduct> productList;
    private ProductActivity activity;

    public ProductAdapter(ProductActivity activity){
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_category , parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        FloorProduct item = productList.get(position);
        holder.category.setText(item.getCategory());
   }
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
//
//        FloorCategory item = categoryList.get(position);
//        holder.category.setText(item.getCategory());
//    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setList(List<FloorProduct> productList){
        this.productList = productList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView category;

        public ViewHolder(View view){
            super(view);
            category = view.findViewById(R.id.categoryName);

        }


        @Override
        public void onClick(View view) {

        }
    }


}
