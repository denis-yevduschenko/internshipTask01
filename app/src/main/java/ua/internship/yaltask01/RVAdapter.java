package ua.internship.yaltask01;

/**
 * Created by Денис on 23.03.2016.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ImageViewHolder> {

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView cv;
        private ImageView photo;

        ImageViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            photo = (ImageView)itemView.findViewById(R.id.photo);
            photo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast toast;
            toast = Toast.makeText(v.getContext(), v.getClass().getSimpleName(), Toast.LENGTH_LONG);
            toast.show();
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
        ImageViewHolder imageViewHolder = new ImageViewHolder(v);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.photo.setImageResource(images.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
