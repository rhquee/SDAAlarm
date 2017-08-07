package pl.kfrak.sdaalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryBroadcastReceiver extends BroadcastReceiver {

    //odpala sie w momencie kiedy transmisja przyjdzie
    @Override
    public void onReceive(Context context, Intent intent) {
        //jesli mamy kontekst to mozemy odpalac np uslugi
        Toast.makeText(context, "Charger pluged in", Toast.LENGTH_SHORT).show();
        Intent startActivityIntent = new Intent(context, MainActivity.class);

        //flaga: task to zestaw komponentów związanych z aplikacją. startActivity killuje poprzednie taski aby ustawić nowy
        startActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //BR nie jest activity i nie ma kontekstu - dostajemy go w parametrze. StartActivity istnieje tylko w klasach, które sa activity
        context.startActivity(startActivityIntent);
    }
}
