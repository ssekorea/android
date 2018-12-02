package com.ssekorea.sse.sseproject.intro;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;
import com.ssekorea.sse.sseproject.R;


public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("SSE란?");
        sliderPage.setDescription("SSE란 Square Step Exercise 의 약자로써 인지능력 향상 운동입니다.");
        sliderPage.setImageDrawable(R.drawable.logo);
        sliderPage.setBgColor(Color.parseColor("#2473E5"));
        addSlide(AppIntroFragment.newInstance(sliderPage));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("두번째 페이지");
        sliderPage2.setDescription("두번째 페이지에 들어갈 내용을 논의해야함니다");
        sliderPage2.setBgColor(Color.parseColor("#0EA0F4"));
        addSlide(AppIntroFragment.newInstance(sliderPage2));


        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("세번째 페이지");
        sliderPage3.setDescription("세번째 페이지에 들어갈 내용을 논의해야함니다");
        sliderPage3.setBgColor(Color.parseColor("#D21442"));
        addSlide(AppIntroFragment.newInstance(sliderPage3));
    }
}
