package ua.internship.yaltask01;

/**
 * Created by Денис on 23.03.2016.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ImageViewHolder> {

    public static class ImageViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        ImageView photo;
        ImageView photo2;

        ImageViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            photo = (ImageView)itemView.findViewById(R.id.photo);
            photo2 = (ImageView)itemView.findViewById(R.id.photo2);
        }
    }

    List<Image> images;

    RVAdapter(List<Image> images){
        this.images = images;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        ImageViewHolder pvh = new ImageViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.photo.setImageResource(images.get(i).photoId);
        imageViewHolder.photo2.setImageResource(images.get(i).photoId2);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public String getItem(int i) {
        return "ImageView " + i;
    }
}
