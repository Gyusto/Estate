package yusto.programer.estate.products.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import yusto.programer.estate.R;
import yusto.programer.estate.actionlistener.BtnRentDetails;
import yusto.programer.estate.products.adapters.HouseViewAdapter;
import yusto.programer.estate.products.models.products_house;
import yusto.programer.estate.products.productDetails;

import static yusto.programer.estate.APIs.api.images;
import static yusto.programer.estate.APIs.api.productslists;

public class product_list_Fragment extends Fragment implements BtnRentDetails {
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private RecyclerView houseRecycler;
    private List<products_house> houseList;
    private String location_product;

    public product_list_Fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.product_lists_recycler,container,false);

        TextView title=view.findViewById(R.id.list_houses);
        Bundle args=getArguments();
        location_product=args.getString("loca");
        title.setText("List of Houses");
        houseRecycler=view.findViewById(R.id.product_house_recycler);
        houseList=new ArrayList<>();
        productHouseList();
        return view;
    }





    public void productHouseList(){
        StringRequest info_request = new StringRequest(Request.Method.GET, productslists+"type=Houses&location="+location_product.replaceAll(" ", "+")+"&status=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                        JSONObject main_object = new JSONObject(response);
                        JSONArray product_aray = main_object.getJSONArray("data");
                        for (int i = 0;i<product_aray.length();i++){
                            JSONObject product_object = product_aray.getJSONObject(i);
                            products_house products = new products_house();
                            String locations = product_object.getString("locations");
                            String price = product_object.getString("price");
                            String Thumbnails = product_object.getString("images");
                            products.setLocation(locations);
                            products.setImage("Tshs "+price);
                            products.setImage(images+Thumbnails);
                            houseList.add(products);
                       }

                    HouseViewAdapter adapter=new HouseViewAdapter(getContext(),houseList,product_list_Fragment.this);
                    houseRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    houseRecycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();



            }
        });

        requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(info_request);

    }

    @Override
    public void btnRentDetails(products_house house, ImageView thumbNails) {
        Intent intent=new Intent(getContext(), productDetails.class);
        intent.putExtra("location",house.getLocation());
        intent.putExtra("amount",house.getAmount());
        intent.putExtra("thumbNail",house.getImage());
        startActivity(intent);
    }
}
