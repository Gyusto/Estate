package yusto.programer.estate.rent.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import yusto.programer.estate.R;
import yusto.programer.estate.actionlistener.BtnDialogListener;
import yusto.programer.estate.rent.adapters.DetailsViewAdapter;
import yusto.programer.estate.rent.models.rent_details;

public class RentFragment extends Fragment implements BtnDialogListener {
    RecyclerView reyclerRentViews;
    List<rent_details> details;
    View view;
    public RentFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rent_fragment, container, false);
        rentDetails();
        reyclerRentViews=view.findViewById(R.id.rent_fragment_recycler);
        DetailsViewAdapter adapter=new DetailsViewAdapter(getContext(),details,RentFragment.this);
        reyclerRentViews.setHasFixedSize(true);
        reyclerRentViews.setLayoutManager(new GridLayoutManager(getActivity(),3));
        reyclerRentViews.setAdapter(adapter);

        return view;

    }

    public void rentDetails(){
        details=new ArrayList<>();
        details.add(new rent_details(R.drawable.ic_001_rent,"Houses"));
        details.add(new rent_details(R.drawable.ic_001_rent,"Offices"));
        details.add(new rent_details(R.drawable.ic_001_rent,"Conference"));
        details.add(new rent_details(R.drawable.ic_001_rent,"Warehouse"));
        details.add(new rent_details(R.drawable.ic_001_rent,"Shops"));
        details.add(new rent_details(R.drawable.ic_001_rent,"Land"));

    }

    @Override
    public void BtnDialogListener(rent_details details) {
        RentDialogFragement dialogFragement=new RentDialogFragement();
        Bundle args=new Bundle();
        args.putString("categories",details.getName());
        dialogFragement.setArguments(args);
        dialogFragement.show(getChildFragmentManager(),"RentDialog");

    //  Toast.makeText(getContext(), "Worked"+details.getName(), Toast.LENGTH_SHORT).show();
    }


}
