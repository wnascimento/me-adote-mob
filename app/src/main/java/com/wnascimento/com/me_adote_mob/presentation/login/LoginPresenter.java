package com.wnascimento.com.me_adote_mob.presentation.login;

import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.domain.owner.Owner;
import com.wnascimento.com.me_adote_mob.domain.owner.interactor.LoginUserFlowableUseCase;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginUserFlowableUseCase loginUseCase;
    private final CompositeDisposable compositeDisposable;

    private LoginContract.View loginView;

    @Inject
    public LoginPresenter(LoginContract.View view, LoginUserFlowableUseCase loginUseCase) {
        loginView = view;
        this.loginUseCase = loginUseCase;
        compositeDisposable = new CompositeDisposable();
        view.attachPresenter(this);
    }

    @Override
    public void reload() {

    }

    @Override
    public void close() {
        compositeDisposable.clear();
    }



    @Override
    public void login(String email, String password) {
        OwnerContract user = new Owner(email, password);

        if (!user.hasEmail()) {
            loginView.showMessageEmailNotValid();
            return;
        }
        if (!user.hasPassword()) {
            loginView.showMessagePasswordNotValid();
            return;
        }
        loginUseCase.run(new LoginUserFlowableUseCase.Request(user)).subscribeWith(new LoginUserObservable());
    }


    public class LoginUserObservable implements SingleObserver<Boolean> {
        @Override
        public void onSubscribe(Disposable disposable) {
            compositeDisposable.add(disposable);
        }

        @Override
        public void onSuccess(Boolean registered) {
            if (registered) {
                loginView.goToPets();
            } else {
                loginView.showMessageUserNotFound();
            }
        }

        @Override
        public void onError(Throwable t) {
            t.printStackTrace();
            loginView.showMessageUserNotFound();
        }

    }

}
