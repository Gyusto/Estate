package yusto.programer.estate.products.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.List;
import yusto.programer.estate.R;
import yusto.programer.estate.products.models.productImages;

public class ImageViewAdapter extends  RecyclerView.Adapter<ImageViewAdapter.MyViewHolder> {
    private Context context;
    private List<productImages> images;

    public ImageViewAdapter(Context context, List<productImages> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.product_details,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Glide.with(context).load(images.get(i).getMoreImages()).fitCenter().into(myViewHolder.pImage);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView pImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pImage=itemView.findViewById(R.id.product_house_detailsImages);
        }
    }
}
