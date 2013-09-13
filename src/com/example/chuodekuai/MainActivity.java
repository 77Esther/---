package com.example.chuodekuai;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageView imageview1;
	ImageButton button12;
	ImageButton button22;
	int i = 0;
	
	private static MainActivity instance = null;
	public static MainActivity getInstance(){
		//if (instance==null) instance=new MainActivity();
		return instance;
	}
	
	public static Handler handler = new Handler(){
		public void handleMessage(Message msg){
			getInstance().imageview1.setImageResource(R.drawable.ha);
			getInstance().i = 3;
		}
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
		
        setContentView(R.layout.activity_main);
        imageview1=(ImageView) (findViewById(R.id.imageView1));
        button12=(ImageButton)(findViewById(R.id.button12));
        button12.setOnClickListener(onClickListener);
        button22=(ImageButton)(findViewById(R.id.button22));
        button22.setOnClickListener(onClickListener);
        
        Timer timer = new Timer();
        timer.start();
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
	protected void onResume() { 
		/**  * 设置为横屏  */
		if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){ 
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			} 
		super.onResume();
	}
    
    private OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			int k = v.getId();
			int b1 = R.id.button12;
			int b2 = R.id.button22;
			if(i==0)
			{
				if(k == b1)
					button12.setImageResource(R.drawable.ha);
					Toast.makeText(MainActivity.this,"Blue Win!",Toast.LENGTH_SHORT).show();
				if(k == b2)
					button22.setImageResource(R.drawable.ha);
					Toast.makeText(MainActivity.this,"Red Win!",Toast.LENGTH_SHORT).show();
				
				Intent intent=new Intent(MainActivity.this,MainActivity.class);
				startActivity(intent);
				
				finish();
			}
		
			if(i==3){
				if(k == b1)
					button12.setImageResource(R.drawable.ha);
					Toast.makeText(MainActivity.this,"Red Win!",Toast.LENGTH_SHORT).show();
				if(k == b2)
					button22.setImageResource(R.drawable.ha);
					Toast.makeText(MainActivity.this,"Blue Win!",Toast.LENGTH_SHORT).show();
				
				Intent intent=new Intent(MainActivity.this,MainActivity.class);
				startActivity(intent);
				
				finish();
				}
	        }
    };
}
