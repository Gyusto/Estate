package yusto.programer.estate.rent.adapters;
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
import yusto.programer.estate.actionlistener.BtnDialogListener;
import yusto.programer.estate.rent.models.rent_details;

public class DetailsViewAdapter  extends  RecyclerView.Adapter<DetailsViewAdapter.MyViewHolder>  {
        private Context context;
        private List<rent_details> details;
        BtnDialogListener myDialog;

    public DetailsViewAdapter(Context context, List<rent_details> details, BtnDialogListener dialog) {
        this.context = context;
        this.details = details;
        myDialog = dialog;
    }

    @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(context).inflate(R.layout.rent_fragment_list,viewGroup,false);
            final MyViewHolder vHolder=new  MyViewHolder(view);

        return vHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.Rname.setText(details.get(i).getName() );
            Glide.with(context).load(details.get(i).getIcon()).fitCenter().into(myViewHolder.Rimage);
        }

        @Override
        public int getItemCount() {
            return details.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView Rname;
            private ImageView Rimage;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                Rimage=itemView.findViewById(R.id.rent_list_image);
                Rname=itemView.findViewById(R.id.rent_list_name);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.BtnDialogListener(details.get(getAdapterPosition()));
                    }
                });

            }
        }
    }
