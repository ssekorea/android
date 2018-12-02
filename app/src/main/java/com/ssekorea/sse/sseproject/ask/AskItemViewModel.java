package com.ssekorea.sse.sseproject.ask;

import android.databinding.ObservableField;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class AskItemViewModel extends BaseViewModel<AskNavigator> {
    public final ObservableField<String> questionTitle;
    public final ObservableField<String> answerTitle;
    public AskItemViewModel(SchedulerProvider mSchedulerProvider) {
        super(mSchedulerProvider);
        questionTitle = new ObservableField<>();
        answerTitle = new ObservableField<>();
    }
}
