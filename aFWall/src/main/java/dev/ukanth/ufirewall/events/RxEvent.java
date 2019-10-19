package dev.ukanth.ufirewall.events;

import dev.ukanth.ufirewall.log.Log;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by ukanth on 25/9/17.
 */

public class RxEvent {
    private PublishSubject<Object> sSubject = PublishSubject.create();

    public RxEvent() {
        // hidden constructor
    }

    public Disposable subscribe(@NonNull Consumer<Object> action) {
        return sSubject.subscribe(action, throwable -> {
            Log.i("AFWall", throwable.getLocalizedMessage());
        });
    }

    public void publish(@NonNull Object message) {
        sSubject.onNext(message);
    }

}
