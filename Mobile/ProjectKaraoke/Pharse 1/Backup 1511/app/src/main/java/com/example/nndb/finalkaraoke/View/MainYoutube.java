package com.example.nndb.finalkaraoke.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nndb.finalkaraoke.Model.DTO.Music;
import com.example.nndb.finalkaraoke.Present.YoutubeConfig;
import com.example.nndb.finalkaraoke.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainYoutube extends YouTubeBaseActivity {

    YouTubePlayerView mYoutubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_youtube);
        addControls();
        addEvents();
    }

    private void addControls() {
        mYoutubePlayerView=findViewById(R.id.mYoutubePlay);
        btnPlay=findViewById(R.id.btnPlay);
    }

    private void addEvents() {

        mOnInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Intent intent=getIntent();
                Music music= (Music) intent.getSerializableExtra("KEY_MUSIC");
                String KeyYoutubeURL=music.getKeyYoutube();
                //youTubePlayer.setFullscreen(true);
                if (!b) {
                    youTubePlayer.cueVideo(KeyYoutubeURL);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        /**btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);
            }
        });**/

        mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);
    }
}
