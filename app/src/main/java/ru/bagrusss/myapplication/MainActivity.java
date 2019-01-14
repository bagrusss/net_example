package ru.bagrusss.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import ru.bagrusss.myapplication.net.HelloMessage;
import ru.bagrusss.myapplication.net.Network;

import java.util.concurrent.TimeUnit;

/**
 * Created by bagrusss on 14.01.2019
 */
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Network.helloApi.getHelloMessage()
                        .observeOn(AndroidSchedulers.mainThread())
                .delaySubscription(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<HelloMessage>() {
                    @Override
                    public void accept(HelloMessage helloMessage) throws Exception {
                        ((TextView) findViewById(R.id.text_view)).setText(helloMessage.message);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("error", throwable.getMessage(), throwable);
                    }
                });
    }

}
