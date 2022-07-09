package com.example.activitytest

import android.app.Activity
import android.os.Process
import android.util.Log

object ActivityCollector {

    private val activityList = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activityList.add(activity)
        Log.d("ActivityCollector", "Add $activity")
    }

    fun removeActivity(activity: Activity) {
        activityList.remove(activity)
        Log.d("ActivityCollector", "Remove $activity")
    }

    fun finishAll() {
        for (activity in activityList) {
            if (!activity.isFinishing) {
                activity.finish()
                Log.d("ActivityCollector", "Finished $activity")
            }
        }
    }

}