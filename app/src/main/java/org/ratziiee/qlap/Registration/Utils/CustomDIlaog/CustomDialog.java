package org.ratziiee.qlap.Registration.Utils.CustomDIlaog;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.ratziiee.qlap.R;


/**
 * Created by cspl-5a on 16/3/18.
 */

public class CustomDialog {

    private AlertDialog b;
    private DialogInterface dialogInterface;


    public void showChangeLangDialog(final Context context, Activity activity, String DialogMessage,final int uniqueId) {

        dialogInterface=(DialogInterface)activity;
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.customdialog, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        final Button yes=(Button)dialogView.findViewById(R.id.btn_yes);
        final Button no=(Button)dialogView.findViewById(R.id.btn_no);
        TextView tv_dialog=(TextView)dialogView.findViewById(R.id.tv_dialog);
        tv_dialog.setText(DialogMessage);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogInterface.btn_yes(uniqueId);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogInterface.btn_no(uniqueId);
            }
        });


        b = dialogBuilder.create();
        b.show();

    }

    public void dialogDismiss()
    {
        b.dismiss();
    }
}
