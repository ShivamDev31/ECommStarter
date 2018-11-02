package io.kotlin.ecommstarter.rx

import io.reactivex.functions.Function

interface Converter<T, R> : Function<T, R>
