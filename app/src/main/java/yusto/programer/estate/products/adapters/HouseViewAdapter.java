package yusto.programer.estate.products.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yusto.programer.estate.R;
import yusto.programer.estate.actionlistener.BtnRentDetails;
import yusto.programer.estate.products.models.products_house;

public class HouseViewAdapter extends  RecyclerView.Adapter<HouseViewAdapter.MyViewHolder> {
    private Context context;
    private List<products_house> house;
    BtnRentDetails actionDetails;

    public HouseViewAdapter(Context context, List<products_house> house, BtnRentDetails actionBtn) {
        this.context = context;
        this.house = house;
        actionDetails=actionBtn;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.product_lists,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.pLocation.setText(house.get(i).getLocation() );
        Glide.with(context).load(house.get(i).getImage()).fitCenter().into(myViewHolder.pImage);
    }

    @Override
    public int getItemCount() {
        return house.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView pAmount,pLocation;
        private ImageView pImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pImage=itemView.findViewById(R.id.product_Image);
            pAmount=itemView.findViewById(R.id.product_Amount);
            pLocation=itemView.findViewById(R.id.product_location);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actionDetails.btnRentDetails(house.get(getAdapterPosition()),pImage);
                }
            });
        }
    }
}
