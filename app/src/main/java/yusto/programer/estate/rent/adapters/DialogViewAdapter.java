package yusto.programer.estate.rent.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import yusto.programer.estate.R;
import yusto.programer.estate.actionlistener.BtnRentList;
import yusto.programer.estate.rent.models.rentDialog;

public class DialogViewAdapter extends RecyclerView.Adapter<DialogViewAdapter.MyViewHolder> {
    private Context context;
    private List<rentDialog> dialogs;
    BtnRentList actionBtn;

    public DialogViewAdapter(Context context, List<rentDialog> dialogs, BtnRentList btn) {
        this.context = context;
        this.dialogs = dialogs;
        actionBtn=btn;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.rent_dialog_recycler,viewGroup,false);
        final MyViewHolder vHolder=new  MyViewHolder(view);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.Dname.setText(dialogs.get(i).getLocation());
        Glide.with(context).load(dialogs.get(i).getThumbNail()).fitCenter().circleCrop().into(myViewHolder.Dimage);
    }

    @Override
    public int getItemCount() {
        return dialogs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView Dname;
        private ImageView Dimage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Dimage=itemView.findViewById(R.id.rent_Dialog_image);
            Dname=itemView.findViewById(R.id.rent_Dialog_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actionBtn.onRentListClick(dialogs.get(getAdapterPosition()));
                }
            });

        }
    }
}
