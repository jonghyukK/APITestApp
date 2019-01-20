package com.trebit.restapitest.utils

import io.reactivex.*

/**
 * RestAPITest
 * Class: SchedulerProvider
 * Created by kangjonghyuk on 20/01/2019.
 *
 * Description:
 */


class SchedulerProvider(private val backgroundScheduler: Scheduler,
                        private val foregroundScheduler: Scheduler
){

    fun <T> getSchedulersForObservable(): (Observable<T>) -> Observable<T> {

        return { observable: Observable<T> ->
            observable.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

    fun <T> getSchedulersForSingle(): (Single<T>) -> Single<T> {
        return { single: Single<T> ->
            single.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

    fun <T> getSchedulersForCompletable(): (Completable) -> Completable {
        return { completable: Completable ->
            completable.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }

    fun <T> getSchedulersForFlowable(): (Flowable<T>) -> Flowable<T> {
        return { flowable: Flowable<T> ->
            flowable.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }
}