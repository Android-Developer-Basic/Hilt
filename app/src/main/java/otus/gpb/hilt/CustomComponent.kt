package otus.gpb.hilt

import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomScoped

@CustomScoped
@DefineComponent(parent = SingletonComponent::class)
interface CustomComponent

@DefineComponent.Builder
interface CustomComponentBuilder {
    fun someData(@BindsInstance str: String): CustomComponentBuilder
    fun build(): CustomComponent
}

@Module
@InstallIn(CustomComponent::class)
class CustomModule {
    @Provides
    @CustomScoped
    fun bool(): Boolean = true
}

@EntryPoint
@InstallIn(CustomComponent::class)
interface CustomEntryPoint {
    @Num fun num(): Int
    fun str(): String
    fun bool(): Boolean
}

