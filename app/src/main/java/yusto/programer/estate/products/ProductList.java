package yusto.programer.estate.products;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import yusto.programer.estate.R;
import yusto.programer.estate.products.fragments.product_list_Fragment;
import yusto.programer.estate.products.fragments.viewPagerAdapter;

public class ProductList extends FragmentActivity {
private ImageView Image_cover;
private TextView location_title;
private TabLayout productTab;
private ViewPager viewPager;
private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_lists_pager);

        location =getIntent().getExtras().getString("location");
        String thumbNail =getIntent().getExtras().getString("thumbNail");
        String name =getIntent().getExtras().getString("name");

        //send data to pager
        Image_cover=findViewById(R.id.location_Image_Cover);
        location_title=findViewById(R.id.location_title);
        Glide.with(this).load(thumbNail).fitCenter().into(Image_cover);
       // Image_cover.setImageResource(thumbNail);
        location_title.setText(location);
        productTab=findViewById(R.id.house_list_tabs);
        viewPager=findViewById(R.id.house_list_pager);
        if(name.equals("Houses")){

            TextView self=findViewById(R.id.self);
            TextView selfNo=findViewById(R.id.self_no);
            TextView Double=findViewById(R.id.Double);
            TextView DoubleNo=findViewById(R.id.Double_no);
            TextView Single=findViewById(R.id.Single);
            TextView SingleNo=findViewById(R.id.Single_no);
            self.setText("Self");
            selfNo.setText("313");
            Double.setText("Double");
            DoubleNo.setText("2341");
            Single.setText("Single");
            SingleNo.setText("12");
            viewPagerAdapter adapter=new viewPagerAdapter(getSupportFragmentManager());
            Bundle args=new Bundle();
            args.putString("loca",location);
            product_list_Fragment product=new product_list_Fragment();
            product.setArguments(args);
            adapter.addFragment(product,"");
            viewPager.setAdapter(adapter);
            productTab.setupWithViewPager(viewPager);
            productTab.setSelectedTabIndicatorHeight(0);
        }else if(name.equals("Offices")){
            TextView self=findViewById(R.id.self);
            TextView selfNo=findViewById(R.id.self_no);
            TextView Double=findViewById(R.id.Double);
            TextView DoubleNo=findViewById(R.id.Double_no);
            TextView Single=findViewById(R.id.Single);
            TextView SingleNo=findViewById(R.id.Single_no);
            //self.setText("Self");
           // selfNo.setText("313");
           // Double.setText("Double");
            //DoubleNo.setText("2341");
            //Single.setText("Single");
           // SingleNo.setText("12");
           // Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        }else if(name.equals("Conference")){
            Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        }else if(name.equals("Warehouse")){
            Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        }else if(name.equals("Shops")){
            Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        }else if(name.equals("Land")){
            Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        }


    }

}
