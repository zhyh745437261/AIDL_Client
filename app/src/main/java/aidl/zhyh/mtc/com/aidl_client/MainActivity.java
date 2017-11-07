package aidl.zhyh.mtc.com.aidl_client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import aidl.zhyh.mtc.com.aidl_server.PayAidlInterface;

public class MainActivity extends AppCompatActivity {


    private PayAidlInterface mPayAidlInterface;

    private ServiceConnection mServiceConnection;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        Intent intent = new Intent();
        intent.setPackage("aidl.zhyh.mtc.com.aidl_server");
        intent.setAction("aidl.zhyh.mtc.com.aidl_server.MyAIDLService");

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mPayAidlInterface = PayAidlInterface.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        bindService(intent,mServiceConnection,BIND_AUTO_CREATE);

    }

    public void onClick(View v){
        try{
            if(mPayAidlInterface!=null)
                Toast.makeText(mContext, mPayAidlInterface.calculation(1,7)+""+mPayAidlInterface.getOne(), Toast.LENGTH_SHORT).show();
            Log.d("zhuyahui","name="+mPayAidlInterface.getOne().getName());
            Log.d("zhuyahui","age="+mPayAidlInterface.getOne().getAge());
            Log.d("zhuyahui","sex="+mPayAidlInterface.getOne().getSex());
            Log.d("zhuyahui","person="+mPayAidlInterface.getOne());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mServiceConnection != null){
            unbindService(mServiceConnection);
        }
    }
}
