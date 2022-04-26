package edu.qc.seclass.fim.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcels;

import edu.qc.seclass.fim.DetailActivity;
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
    public void setFilteredList(ArrayList<FloorProduct> filteredList){
        this.floorList = filteredList;
        notifyDataSetChanged();
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


        FloorProduct floorProduct = floorList.get(position);
        holder.bind(floorProduct);
       // FloorProduct item = productList.get(position);
//        holder.floor_category_txt.setText(String.valueOf(floor_category.get(position)));
//        holder.floor_type_txt.setText(String.valueOf(floor_type.get(position)));
//        holder.floor_category_txt.setText(floorList.get(position).getFloorCategory());
//        holder.floor_type_txt.setText(String.valueOf(floorList.get(position).getFloorType()));
//        holder.floor_id_txt.setText(String.valueOf(floorList.get(position).getFloorID()));
    }

    @Override
    public int getItemCount() {
        return floorList.size();
    }

//    public void setList(List<FloorProduct> productList){
//        this.productList = productList;
//        notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView floor_category_txt, floor_type_txt, floor_id_txt;
        RelativeLayout relativeLayout;

        public ViewHolder(View view){
            super(view);
            floor_category_txt = view.findViewById(R.id.floor_category_txt);
            floor_type_txt = view.findViewById(R.id.floor_type_txt);
            floor_id_txt = view.findViewById(R.id.floor_id_txt);
            relativeLayout = view.findViewById(R.id.relativelayout);
        }


        public void bind(FloorProduct floorProduct){
            floor_category_txt.setText(floorProduct.getFloorCategory());
            floor_type_txt.setText(floorProduct.getFloorType());
            floor_id_txt.setText(String.valueOf(floorProduct.getFloorID()));

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("floor", Parcels.wrap(floorProduct));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }

    }
}
