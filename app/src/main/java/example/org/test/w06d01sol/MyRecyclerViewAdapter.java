package example.org.test.w06d01sol;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import example.org.test.w06d01sol.restcalls.model.Images;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public static final String IMAGE_URL = "http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1 ";

    ArrayList<Images> imagesArrayList;

    public MyRecyclerViewAdapter(ArrayList<Images> imagesArrayList) {
        this.imagesArrayList = imagesArrayList;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.image_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder viewHolder, int i) {

        Images currentImageBeingPopulated = imagesArrayList.get(i);


        Glide.with(viewHolder.itemView.getContext())
                .load("http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1 ")
                .into(viewHolder);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
