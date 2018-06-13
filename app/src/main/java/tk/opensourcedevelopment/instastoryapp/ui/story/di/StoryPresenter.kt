package tk.opensourcedevelopment.instastoryapp.ui.story.di

import tk.opensourcedevelopment.instastoryapp.ui.base.presenter.BasePresenter

interface StoryPresenter : BasePresenter {
    fun getStories(userId: Long)
}