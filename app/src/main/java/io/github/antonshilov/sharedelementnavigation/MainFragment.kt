package io.github.antonshilov.sharedelementnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import androidx.core.util.Pair as UtilPair

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        image.setOnClickListener { navigateToDetail() }
        activityBtn.setOnClickListener { navigateToActivity() }
    }

    private fun navigateToActivity() {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity!!,
                UtilPair.create(image, image.transitionName))
        val extras = ActivityNavigator.Extras(options)
        findNavController().navigate(R.id.detailActivity,
                null, // Bundle of args
                null, // NavOptions
                extras)
    }

    private fun navigateToDetail() {
        val extras = FragmentNavigatorExtras(image to image.transitionName)
        findNavController().navigate(R.id.detailFragment,
                null, // Bundle of args
                null, // NavOptions
                extras)
    }
}