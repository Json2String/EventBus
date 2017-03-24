package smartbj35.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class PublisherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher);
    }

    /**
     * 在子线程中发布
     * @param view
     */
    public void onPublishEventBGThread(View view) {
        new Thread(){
            @Override
            public void run() {
                Event event = new Event("msg from publish BG Thread");
                EventBus.getDefault().post(event);
            }
        }.start();

    }

    /**
     * 在主线程中发布
     * @param view
     */
    public void onPublishEventMainThead(View view) {
        Event event = new Event("msg from publish main Thread");
        EventBus.getDefault().post(event);

    }
}
