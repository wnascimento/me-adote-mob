package com.wnascimento.com.me_adote_mob.presentation.timeline;


import com.wnascimento.com.me_adote_mob.domain.timeline.model.AvailablePet;
import com.wnascimento.com.me_adote_mob.presentation.BasePresenter;
import com.wnascimento.com.me_adote_mob.presentation.BaseView;

public interface TimelineContract {

    interface Presenter extends BasePresenter {

        void getAvailablePets();

    }

    interface View extends BaseView<Presenter> {

        void updateTimeline(AvailablePet availablePet);

        void showLoadError();

    }

}
