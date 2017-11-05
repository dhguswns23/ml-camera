package ai.deepquest.camera;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

/**
 * Created by dhgus_000 on 2017-10-24.
 */

public class SplashActivity extends AppCompatActivity {
    private int loadingTime = 1000;
    private PermissionListener permissionlistner = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(SplashActivity.this, "권한 허가", Toast.LENGTH_SHORT).show();

        }
        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(SplashActivity.this, "권한 거부\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
        }
    };
    Button photoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startLoading();
        TedPermission.with(this)
                .setPermissionListener(permissionlistner)
                .setRationaleMessage("카메라 사용을 위해선 카메라 접근권한이 필요합니다.")
                .setDeniedMessage("카메라 사용을 허용하지 않으실 경우 해당 기능사용이 불가능합니다.")
                .setPermissions(Manifest.permission.CAMERA)
                .check();
        photoButton = (Button) findViewById(R.id.photoButton);
        photoButton.setOnClickListener(onTakeClick);
    }

    private Button.OnClickListener onTakeClick = new View.OnClickListener() {
        public void onClick(View v){
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    private void startLoading() {
//        Handler handler = new Handler();
//        final Animation fadeInUpward = AnimationUtils.loadAnimation(this, R.anim.fade_in_upward);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                photoButton.startAnimation(fadeInUpward);
//
//            }
//        }, loadingTime);
    }
}
