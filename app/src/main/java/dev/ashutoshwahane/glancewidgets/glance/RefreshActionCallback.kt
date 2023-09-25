package dev.ashutoshwahane.glancewidgets


import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import com.google.gson.Gson
import entity.MarsEntity

class RefreshActionCallback: ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->

            val data = getApiData()
            val jsonData = Gson().toJson(data)
            prefs[ApodWidget.jsonStr] = jsonData

        }
        ApodWidget.update(context, glanceId)
    }

    private suspend fun getApiData(): MarsEntity {
        return RetrofitInstance.getRetrofitInstance().create(ImageApi::class.java).getMarsImage("La3VCCcJScqftN0zY2JdGkfNCegzrmSc2Zt4exT4")
    }
}