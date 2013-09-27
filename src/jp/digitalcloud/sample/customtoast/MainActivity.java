package jp.digitalcloud.sample.customtoast;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText buttonShowToast = (EditText) findViewById(R.id.editTextShowToast);
        buttonShowToast.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showCustomToast();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void showCustomToast() {
        // get inflater and layout view
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_main, null);

        // get TextView on layout
        Button button = (Button) view.findViewById(R.id.buttonToastMessage);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.android.com/"));
                startActivity(intent);
            }
        });

        // generate Toast and set view
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.setView(view);

        // show Toast
        toast.show();
    }

}
