package yusto.programer.estate.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import yusto.programer.estate.R;
import yusto.programer.estate.actionlistener.BtnactionListiner;
import yusto.programer.estate.products.productDetails;

import static yusto.programer.estate.APIs.api.images;
import static yusto.programer.estate.APIs.api.productsBadge;

public class HomeFragment extends Fragment implements BtnactionListiner {

    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Slider> listSlider;
    private ViewPager slidepage;
    private TabLayout indicator;
    private RecyclerView reyclerViews;
    private  List<Houses> houseslist;
    private  List<IconMenu> Iconlist;
    private  List<Land> Landlist;
    private RecyclerView reyclerLandViews;
    private RecyclerView reyclerIconViews;
    private ProgressBar progressBar;
    private int progressStatus=0;
    private Handler loadHandler=new Handler();
    private  View view;
    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_fragment,container,false);
        slidepage=view.findViewById(R.id.slider_page);
        reyclerViews=view.findViewById(R.id.House_recycler);
        reyclerLandViews=view.findViewById(R.id.Land_recycler);
        reyclerIconViews=view.findViewById(R.id.menu_recycler);
        indicator=view.findViewById(R.id.indicator);

        progressBar=view.findViewById(R.id.onload_progressbar);
        //slider
        SlidePagerAdapter adapter=new SlidePagerAdapter(getContext(), listSlider);
        slidepage.setAdapter(adapter);

        //land

        IconViewAdapter adapter4=new IconViewAdapter(getContext(),Iconlist);
        reyclerIconViews.setHasFixedSize(true);
        reyclerIconViews.setAdapter(adapter4);
        reyclerIconViews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        houseslist=new ArrayList<>();
        Landlist=new ArrayList<>();
        getIndicator();
        House_info();
        Land_info();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSlider();
        getIcon();

    }

    public void getSlider(){

        listSlider =new ArrayList<>();
        listSlider.add(new Slider(R.drawable.car1,"Get an Amazing Car"));
        listSlider.add(new Slider(R.drawable.car2,"Get an Amazing Car"));
        listSlider.add(new Slider(R.drawable.house1,"Living in a Better House"));
        listSlider.add(new Slider(R.drawable.house,"Dream House"));
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new HomeFragment.SliderTask(),4000,6000);

    }
    public void getIcon(){
        Iconlist =new ArrayList<>();
        Iconlist.add(new IconMenu("Products","Recent Added","Sales","About us",R.drawable.ic_002_product,R.drawable.ic_plus,R.drawable.ic_money,R.drawable.ic_info_black_24dp));
    }


    public void getIndicator(){
        indicator.setupWithViewPager(slidepage,true);

    }

    private void  House_info(){

        StringRequest info_request = new StringRequest(Request.Method.GET, productsBadge+"type=Houses&badges=top_rated&status=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject main_object = new JSONObject(response);
                    JSONArray product_aray = main_object.getJSONArray("data");
                    for (int i = 0;i<product_aray.length();i++){
                        JSONObject product_object = product_aray.getJSONObject(i);
                        Houses houses = new Houses();
                        String location = product_object.getString("location");
                        String locations = product_object.getString("locations");
                        String location_home = product_object.getString("location_home");
                        String description = product_object.getString("description");
                        String rooms = product_object.getString("rooms");
                        String bedroom = product_object.getString("bedroom");
                        String bathroom = product_object.getString("bathroom");
                        String price = product_object.getString("price");
                        String Thumbnails = product_object.getString("products_name");
                        houses.setRegion(locations);
                        houses.setNoOfHouses("Tshs "+price);
                        houses.setThumbnail(images+Thumbnails);

                        houseslist.add(houses);
                    }

                    HouseViewAdapter adapter2=new HouseViewAdapter(getContext(),houseslist,HomeFragment.this);
                    reyclerViews.setHasFixedSize(true);
                    reyclerViews.setAdapter(adapter2);
                    reyclerViews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
                    adapter2.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();
               // Houses houses = new Houses();



            }
        });

        requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(info_request);
    }

    private void  Land_info(){

        StringRequest info_request = new StringRequest(Request.Method.GET, productsBadge+"type=Land&badges=top_rated&status=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject main_object = new JSONObject(response);
                    JSONArray product_aray = main_object.getJSONArray("data");
                    for (int i = 0;i<product_aray.length();i++){
                        JSONObject product_object = product_aray.getJSONObject(i);
                        Land land = new Land();
                        String location = product_object.getString("location");
                        String locations = product_object.getString("locations");
                        String location_home = product_object.getString("location_home");
                        String description = product_object.getString("description");
                        String acre_rooms = product_object.getString("acre_rooms");
                        String price = product_object.getString("price");
                        String Thumbnails = product_object.getString("products_name");
                        land.setLocation(locations);
                        land.setRent_amout("Tshs "+price);
                        land.setThumbNail(images+Thumbnails);


                        Landlist.add(land);
                    }
                    LandViewAdapter adapter3=new LandViewAdapter(getContext(),Landlist,HomeFragment.this);
                    reyclerLandViews.setHasFixedSize(true);
                    reyclerLandViews.setAdapter(adapter3);
                    reyclerLandViews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
                    adapter3.notifyDataSetChanged();



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
    public void onHouseClick(Houses house, ImageView thumbNails) {
        Intent intent=new Intent(getContext(), productDetails.class);
        intent.putExtra("location",house.getRegion());
        intent.putExtra("thumbNail",house.getThumbnail());
        intent.putExtra("type",1);
        startActivity(intent);
        //Toast.makeText(getContext(), "Worked"+house.getThumbnail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLandClick(Land land) {
//        Intent intent=new Intent(getContext(), productDetails.class);
//        intent.putExtra("location",land.getLocation());
//        intent.putExtra("thumbNail",land.getThumbNail());
//        intent.putExtra("amount",land.getRent_amout());
//        intent.putExtra("type2",2);
//        startActivity(intent);
        Toast.makeText(getContext(),"Worked"+land.getLocation(),Toast.LENGTH_LONG).show();
    }

    class SliderTask extends TimerTask {



        @Override
        public void run() {
            if (getActivity() == null) {
                return;
            }
            getActivity().runOnUiThread(new Runnable(){
                @Override
                public void run() {
                    if(slidepage.getCurrentItem()<listSlider.size()-1){
                        slidepage.setCurrentItem(slidepage.getCurrentItem()+1);
                    }else
                        slidepage.setCurrentItem(0);

                }
            });

        }
    }

}


