package yusto.programer.estate.products.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import yusto.programer.estate.R;
import yusto.programer.estate.products.adapters.ImageViewAdapter;
import yusto.programer.estate.products.models.productImages;

public class product_details_Fragment extends Fragment{
        private List<productImages> imagelist;
        private RecyclerView reyclerImageViews;

    public product_details_Fragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.product_details_recycler,container,false);
        //Images
        propuctImages();
        reyclerImageViews=view.findViewById(R.id.product_house_details_recycler);
        ImageViewAdapter adapter=new ImageViewAdapter(getContext(), imagelist);
        reyclerImageViews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
       reyclerImageViews.setAdapter(adapter);
        return view;
    }

    public void propuctImages(){
        imagelist=new ArrayList<>();
        imagelist.add(new productImages(R.drawable.house1,""));
        imagelist.add(new productImages(R.drawable.house1,""));
        imagelist.add(new productImages(R.drawable.house1,""));
        imagelist.add(new productImages(R.drawable.house1,""));


    }
}
