package yusto.programer.estate.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import yusto.programer.estate.actionlistener.BtnactionListiner;
import yusto.programer.estate.R;

public class HouseViewAdapter extends RecyclerView.Adapter<HouseViewAdapter.MyViewHolder> {
    private Context context;
    private List<Houses> house;
   BtnactionListiner actionBtn;
   RequestOptions options;

    public HouseViewAdapter(Context context, List<Houses> house,BtnactionListiner listener) {
        this.context = context;
        this.house = house;
        actionBtn=listener;

        options=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.house_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

       myViewHolder.Hname.setText(house.get(i).getRegion());
      myViewHolder.Hno.setText(house.get(i).getNoOfHouses() );
      Glide.with(context).load(house.get(i).getThumbnail()).fitCenter().into(myViewHolder.Himage);

    }

    @Override
    public int getItemCount() {
        return house.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView Hname,Hno;
        private ImageView Himage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Hname=itemView.findViewById(R.id.House_region_id);
            Himage=itemView.findViewById(R.id.thumbnail_id);
            Hno=itemView.findViewById(R.id.House_no);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actionBtn.onHouseClick(house.get(getAdapterPosition()),Himage);

                }
            });


        }
    }
}
