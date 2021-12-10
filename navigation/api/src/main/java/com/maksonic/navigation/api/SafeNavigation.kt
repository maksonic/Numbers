package com.maksonic.navigation.api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.os.Parcelable
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

/**
 * @Author: maksonic on 10.12.2021
 */
private const val PASSED_DATA = "passed data"

fun Fragment.navigate(actionId: Int, hostId: Int? = null, data: Parcelable? = null) {
    val navController = if (hostId == null) {
        findNavController()
    } else {
        Navigation.findNavController(requireActivity(), hostId)
    }
    val bundle = Bundle().apply { putParcelable(PASSED_DATA, data) }
    val action = navController.currentDestination?.getAction(actionId)

    if (action != null && navController.currentDestination?.id != action.destinationId) {
        navController.navigate(actionId, bundle)
    }
}

val Fragment.navigationData: Parcelable?
    get() = arguments?.getParcelable(PASSED_DATA)

