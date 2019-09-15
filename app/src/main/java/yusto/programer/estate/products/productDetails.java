package yusto.programer.estate.products;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import yusto.programer.estate.R;
import yusto.programer.estate.products.fragments.product_details_Fragment;
import yusto.programer.estate.products.fragments.viewPagerAdapter;

public class productDetails extends FragmentActivity {
    private ImageView Image_cover;
    private TextView location_title,Amount,detailTitle,detailTitle2,detailTitle3;
    private TabLayout productTab;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details_pager);

        String location =getIntent().getExtras().getString("location");
        String pAmount =getIntent().getExtras().getString("amount");
       String thumbNail =getIntent().getExtras().getString("thumbNail");
       int type=getIntent().getExtras().getInt("type");
       int type2=getIntent().getExtras().getInt("type2");

           Image_cover = findViewById(R.id.product_house_details_Image);
           location_title = findViewById(R.id.product_house_details_location);
           Amount = findViewById(R.id.product_house_details_amount);
           detailTitle=findViewById(R.id.detailTitle);
           detailTitle2=findViewById(R.id.detailTitle2);
           detailTitle3=findViewById(R.id.detailTitle3);
           if(type==1) {
           Glide.with(this).load(thumbNail).fitCenter().into(Image_cover);
           location_title.setText(location);
           Amount.setText(pAmount);
           productTab=findViewById(R.id.house_list_details_tabs);
           viewPager=findViewById(R.id.product_house_details_pager);
           viewPagerAdapter adapter=new viewPagerAdapter(getSupportFragmentManager());
           adapter.addFragment(new product_details_Fragment(),"");
           viewPager.setAdapter(adapter);
           productTab.setupWithViewPager(viewPager);
           productTab.setSelectedTabIndicatorHeight(0);
          }else if(type2==2){
               Glide.with(this).load(thumbNail).fitCenter().into(Image_cover);
               location_title.setText(location);
               Amount.setText(pAmount);
               productTab=findViewById(R.id.house_list_details_tabs);
               viewPager=findViewById(R.id.product_house_details_pager);
               detailTitle.setText("Acres");
               detailTitle2.setText("Distance");
               detailTitle3.setText("");
               viewPagerAdapter adapter=new viewPagerAdapter(getSupportFragmentManager());
               adapter.addFragment(new product_details_Fragment(),"");
               viewPager.setAdapter(adapter);
               productTab.setupWithViewPager(viewPager);
               productTab.setSelectedTabIndicatorHeight(0);

              // Toast.makeText(getApplicationContext(),"Worked",Toast.LENGTH_LONG).show();
           }



    }
}
