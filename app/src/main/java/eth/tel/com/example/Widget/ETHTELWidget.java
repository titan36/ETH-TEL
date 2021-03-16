package eth.tel.com.example.Widget;

/**
 * @author t.me/ag3m3chu
 * @version 1.0 16/03/2021
 * @since 1.0
 */

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;

import eth.tel.com.example.FirstPage.CallMeBack.CallMeBackActivity;
import eth.tel.com.example.FirstPage.Recharge.RechargeActivity;
import eth.tel.com.example.FirstPage.Transfer.TransferActivity;
import eth.tel.com.example.Gebeta.PackageOffers.PackageOfferActivity;
import eth.tel.com.example.R;

/**
 * Implementation of App Widget functionality.
 */
public class ETHTELWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ethtel_widget);
//        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Set up the collection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            setRemoteAdapter(context, views);
        } else {
            setRemoteAdapterV11(context, views);
        }
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        //-----------------------------------------------------------------------------------------------
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.ethtel_widget);

        Intent checkBalance = new Intent(Intent.ACTION_CALL);
        String hash = Uri.encode("#");
        checkBalance.setData(Uri.parse("tel:*804"+ hash));

        PendingIntent checkBalanceIntent = PendingIntent.getActivity(context, 0, checkBalance, 0);
        remoteViews.setOnClickPendingIntent(R.id.checkBalanceWidget, checkBalanceIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
        //------------------------------------------------------------------------------------------------
        Intent rechargeBalance = new Intent(context, RechargeActivity.class);
        PendingIntent rechargeBalanceIntent = PendingIntent.getActivity(context, 0, rechargeBalance, 0);
        remoteViews.setOnClickPendingIntent(R.id.rechargeBalanceWidget, rechargeBalanceIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
        //------------------------------------------------------------------------------------------------
        Intent transferBalance = new Intent(context, TransferActivity.class);
        PendingIntent transferBalanceIntent = PendingIntent.getActivity(context, 0, transferBalance, 0);
        remoteViews.setOnClickPendingIntent(R.id.transferBalanceWidget, transferBalanceIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
        //------------------------------------------------------------------------------------------------
        Intent CallMeBack = new Intent(context, CallMeBackActivity.class);
        PendingIntent callMeBackIntent = PendingIntent.getActivity(context, 0, CallMeBack, 0);
        remoteViews.setOnClickPendingIntent(R.id.callMeBackWidget, callMeBackIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
        //------------------------------------------------------------------------------------------------
        Intent Gebeta = new Intent(context, PackageOfferActivity.class);
        PendingIntent GebetaIntent = PendingIntent.getActivity(context, 0, Gebeta, 0);
        remoteViews.setOnClickPendingIntent(R.id.gebetaWidget, GebetaIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    /**
     * Sets the remote adapter used to fill in the list items
     *
     * @param views RemoteViews to set the RemoteAdapter
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private static void setRemoteAdapter(Context context, @NonNull final RemoteViews views) {
        //views.setRemoteAdapter(R.id.widget_list,new Intent(context, WidgetService.class));
    }

    /**
     * Sets the remote adapter used to fill in the list items
     *
     * @param views RemoteViews to set the RemoteAdapter
     */
    @SuppressWarnings("deprecation")
    private static void setRemoteAdapterV11(Context context, @NonNull final RemoteViews views) {
        //views.setRemoteAdapter(0, R.id.widget_list,new Intent(context, WidgetService.class));

    }
}

