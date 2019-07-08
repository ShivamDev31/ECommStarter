package io.kotlin.ecommstarter.home.viewstate

data class AdBlockViewState(val id: String,
                            val adImageUrl: String,
                            val adUrl: String,
                            val shouldShow: Boolean,
                            val type: String) : HomeViewState {
    override fun type() = HomeViewState.Type.AD_BLOCK
}
