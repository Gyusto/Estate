package yusto.programer.estate.rent.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import yusto.programer.estate.R;
import yusto.programer.estate.actionlistener.BtnRentList;
import yusto.programer.estate.products.ProductList;
import yusto.programer.estate.products.adapters.ImageViewAdapter;
import yusto.programer.estate.rent.adapters.DialogViewAdapter;
import yusto.programer.estate.rent.models.rentDialog;

import static yusto.programer.estate.APIs.api.images;
import static yusto.programer.estate.APIs.api.locations;

public class RentDialogFragement extends DialogFragment implements BtnRentList {
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    List<rentDialog> dialog;
    View view;
    private String nameCat;
    private RecyclerView recyclerViewDialog;
    public RentDialogFragement() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.rent_dialog,container,false);
        rentDetails();
        DialogViewAdapter adapter=new DialogViewAdapter(getContext(),dialog,RentDialogFragement.this);
        recyclerViewDialog=view.findViewById(R.id.rent_dialog_recycler);
        dialog =new ArrayList<>();
        return view;
    }

    public void rentDetails(){

        StringRequest info_request = new StringRequest(Request.Method.GET, locations, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject main_object = new JSONObject(response);
                    JSONArray product_aray = main_object.getJSONArray("data");
                    for (int i = 0;i<product_aray.length();i++){
                        JSONObject product_object = product_aray.getJSONObject(i);
                        rentDialog rentdialog = new rentDialog();
                        String location = product_object.getString("location");
                        String image = product_object.getString("image");
                        rentdialog.setLocation(location);
                        rentdialog.setThumbNail(images+image);
                        dialog.add(rentdialog);
                    }
                    DialogViewAdapter adapter=new  DialogViewAdapter(getActivity(),dialog,RentDialogFragement.this);
                    recyclerViewDialog.setHasFixedSize(true);
                    recyclerViewDialog.setAdapter(adapter);
                    recyclerViewDialog.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
                    adapter.notifyDataSetChanged();



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();




            }
        });

        requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(info_request);

    }
    @Override
    public void onRentListClick(rentDialog dialog) {
        Bundle args=getArguments();
        nameCat=args.getString("categories");
        Intent intent=new Intent(getContext(), ProductList.class);
        intent.putExtra("location",dialog.getLocation());
        intent.putExtra("thumbNail",dialog.getThumbNail());
        intent.putExtra("name",nameCat);
        getDialog().dismiss();
        startActivity(intent);

    }
}
