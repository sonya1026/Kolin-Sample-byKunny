package com.devhyesun.kolinsample.extensions

import com.devhyesun.kolinsample.AutoClearedDisposable
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    this.add(disposable)
}

operator fun AutoClearedDisposable.plusAssign(disposable: Disposable) = this.add(disposable)

fun runOnIoScheduler(func: () -> Unit): Disposable = Completable.fromCallable(func)
    .subscribeOn(Schedulers.io())
    .subscribe()