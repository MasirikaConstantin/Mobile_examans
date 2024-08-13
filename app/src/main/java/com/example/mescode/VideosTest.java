package com.example.mescode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideosTest extends AppCompatActivity {
    private ImageView mImageViewMonImage;
    private Button mButtonCapturerImage;
    private VideoView mVideoViewMaVideo;
    private Button mButtonCapturerVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_videos_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Camera Plus vidéos");
            init();
    }
        private void init(){
            mImageViewMonImage= findViewById(R.id.imageview_Monimage);
            mButtonCapturerImage=findViewById(R.id.btn_capturer_image);
            mVideoViewMaVideo= findViewById(R.id.videoview_mavideo);
            mButtonCapturerVideo=findViewById(R.id.btn_capturer_video);
            ajouterecouters();
        }
        private void ajouterecouters(){
            mButtonCapturerImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO
                    prendrePhoto();
                }
            });

            mButtonCapturerVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO
                    prendreVideo();
                }
            });
        }
        protected void prendrePhoto(){
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraActivityResultLauncher.launch(cameraIntent);
        }
        ActivityResultLauncher<Intent> cameraActivityResultLauncher =registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            Bundle extras = data.getExtras();
                            Bitmap imageBitmap = (Bitmap) extras.get("data");
                            mImageViewMonImage.setImageBitmap(imageBitmap);
                        }
                    }
                }
        );
        protected void prendreVideo(){
            Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            videActivityResultLauncher.launch(videoIntent);
        }

        ActivityResultLauncher<Intent> videActivityResultLauncher =registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            Uri uri = data.getData();
                            mVideoViewMaVideo.setVideoURI(uri);
                            mVideoViewMaVideo.start();
                        }
                    }
                }
        );
    }
