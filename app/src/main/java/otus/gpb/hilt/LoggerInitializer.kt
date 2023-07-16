package otus.gpb.hilt

import android.content.Context
import android.util.Log
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

object LoggerInitializer {
    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface LoggerEntryPoint {
        @Num fun num(): Int
    }

    fun init(context: Context) {
        val entryPoint = EntryPoints.get(context, LoggerEntryPoint::class.java)
        Log.i("HILT LOGGER", "Initialized with num: ${entryPoint.num()}")
    }
}