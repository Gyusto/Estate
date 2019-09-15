package yusto.programer.estate.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import yusto.programer.estate.R;

public class IconViewAdapter extends RecyclerView.Adapter<IconViewAdapter.MyViewHolder> {
    private Context context;
    private List<IconMenu> icon;

    public IconViewAdapter(Context context, List<IconMenu> icon) {
        this.context = context;
        this.icon = icon;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.menu_list,viewGroup,false);
        return new IconViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.text1.setText(icon.get(i).getTitle());
        myViewHolder.imageView1.setImageResource(icon.get(i).getImage());
        myViewHolder.text2.setText(icon.get(i).getTitle2());
        myViewHolder.imageView2.setImageResource(icon.get(i).getImage2());
        myViewHolder.text3.setText(icon.get(i).getTitle3());
        myViewHolder.imageView3.setImageResource(icon.get(i).getImage3());
        myViewHolder.text4.setText(icon.get(i).getTitle4());
        myViewHolder.imageView4.setImageResource(icon.get(i).getImage4());

    }

    @Override
    public int getItemCount() {
        return icon.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView text1,text2,text3,text4;
        private ImageView imageView1,imageView2,imageView3,imageView4;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           text1=itemView.findViewById(R.id.icon_name1);
           imageView1=itemView.findViewById(R.id.image1);
           text2=itemView.findViewById(R.id.icon_name2);
           imageView2=itemView.findViewById(R.id.image2);
           text3=itemView.findViewById(R.id.icon_name3);
           imageView3=itemView.findViewById(R.id.image3);
           text4=itemView.findViewById(R.id.icon_name4);
           imageView4=itemView.findViewById(R.id.image4);


        }
    }

}
