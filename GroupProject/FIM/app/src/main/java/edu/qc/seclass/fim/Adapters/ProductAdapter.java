package edu.qc.seclass.fim.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.fim.ProductActivity;
import edu.qc.seclass.fim.R;
import edu.qc.seclass.fim.models.FloorProduct;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {


//    private List<FloorProduct> productList;
    private Activity activity;
//    private ArrayList floor_id, floor_category, floor_type, floor_species, floor_color;
    private Context context;
    private ArrayList<FloorProduct> floorList;
//    public ProductAdapter(Activity activity, Context context, ArrayList floor_id, ArrayList floor_category, ArrayList floor_type, ArrayList floor_species, ArrayList floor_color){
//        this.context = context;
//        this.activity = activity;
//        this.floor_category = floor_category;
//        this.floor_type = floor_type;
//        this.floor_species = floor_species;
//        this.floor_id = floor_id;
//        this.floor_color = floor_color;
//
//    }
    public ProductAdapter(Context context, ArrayList<FloorProduct> floor){
        this.context = context;
        this.floorList = floor;
    }
//    public ProductAdapter(ProductActivity activity){
//        this.activity = activity;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

       // FloorProduct item = productList.get(position);
//        holder.floor_category_txt.setText(String.valueOf(floor_category.get(position)));
//        holder.floor_type_txt.setText(String.valueOf(floor_type.get(position)));
        holder.floor_category_txt.setText(floorList.get(position).getFloorCategory());
        holder.floor_type_txt.setText(String.valueOf(floorList.get(position).getFloorType()));
        holder.floor_id_txt.setText(String.valueOf(floorList.get(position).getFloorID()));
    }
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
//
//        FloorCategory item = categoryList.get(position);
//        holder.category.setText(item.getCategory());
//    }

    @Override
    public int getItemCount() {
        return floorList.size();
    }

//    public void setList(List<FloorProduct> productList){
//        this.productList = productList;
//        notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView floor_category_txt, floor_type_txt, floor_id_txt;

        public ViewHolder(View view){
            super(view);
            floor_category_txt = view.findViewById(R.id.floor_category_txt);
            floor_type_txt = view.findViewById(R.id.floor_type_txt);
            floor_id_txt = view.findViewById(R.id.floor_id_txt);
        }


        @Override
        public void onClick(View view) {

        }
    }
}
