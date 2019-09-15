package yusto.programer.estate.home;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yusto.programer.estate.R;

public class SlidePagerAdapter extends PagerAdapter {
private Context mcontext;
private List<Slider> list;

    public SlidePagerAdapter(Context mcontext, List<Slider> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout=inflater.inflate(R.layout.slider_item,null);

        ImageView slideimg=sliderLayout.findViewById(R.id.slide_img);
        TextView slideText=sliderLayout.findViewById(R.id.textTitle);
         Glide.with(mcontext).load(list.get(position).getImage()).into(slideimg);
        slideText.setText(list.get(position).getTitle());
        container.addView(sliderLayout);
        return sliderLayout;

    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
