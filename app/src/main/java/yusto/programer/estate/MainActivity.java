package yusto.programer.estate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onload);
        textView=findViewById(R.id.onload_text);
        imageView=findViewById(R.id.onload_image);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.transition);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);
        final Intent intent=new Intent(this,Home.class);
        Thread thread=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
