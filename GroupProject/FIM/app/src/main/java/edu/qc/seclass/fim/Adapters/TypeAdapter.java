package edu.qc.seclass.fim.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import edu.qc.seclass.fim.R;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder>  {


    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_category , parent, false);
        return new TypeAdapter().ViewHolder(itemView);
    }

}
