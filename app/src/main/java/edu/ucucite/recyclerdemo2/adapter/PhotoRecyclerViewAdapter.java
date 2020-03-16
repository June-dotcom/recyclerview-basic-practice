package edu.ucucite.recyclerdemo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import edu.ucucite.recyclerdemo2.ICallMethod;
import edu.ucucite.recyclerdemo2.Photo;
import edu.ucucite.recyclerdemo2.R;

public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoRecyclerViewAdapter.PhotoViewHolder> {

    ArrayList<Photo> photoArrayList;
    Context context;
    ICallMethod iCallMethod;

    public PhotoRecyclerViewAdapter(ArrayList<Photo> photoArrayList, Context context, ICallMethod icallMethod) {
        this.photoArrayList = photoArrayList;
        this.context = context;
        this.iCallMethod = icallMethod;
    }


    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int position) {
        final Photo photo = photoArrayList.get(position);
        photoViewHolder.txtTitle.setText(photo.getTitle());
        Glide.with(context).asDrawable().load(photo.getImgIdResource()).into(photoViewHolder.img);
        photoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCallMethod.callMethod(photo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoArrayList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtTitle = itemView.findViewById(R.id.textTitle);
        }
    }
}
