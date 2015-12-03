package de.systemengineering.shopadmin;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

/**
 * Created by SZC on 03.12.2015.
 */
public class MainViewActivity extends AppCompatActivity implements View.OnClickListener {
    TableLayout tl;
    TableRow tr;
    TextView label;
    PermissionHandling ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);

        ph = new PermissionHandling();
        ph.getPermissionToUseCamera(this);

        Button btn_Scan = (Button) findViewById(R.id.btn_Scan);
        btn_Scan.setOnClickListener(this);

        tl = (TableLayout) findViewById(R.id.tbl_Main);
        addData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
        return true;
    }

    public void onClick(View view) {
        Log.i("clicks", "You clicked Button Scan");
        Intent i=new Intent(
                MainViewActivity.this,
                CameraViewActivity.class);
        startActivity(i);

    }

    public void onClickTable(View veiw) {
        Log.i("clicks", "You clicked the Table");
    }

    void addHeader(){
        /** <span class="IL_AD" id="IL_AD4">Create</span> a TableRow dynamically **/
        tr = new TableRow(this);

        /** Creating a TextView to add to the row **/
        label = new TextView(this);
        label.setText("Shop");
        label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        label.setPadding(5, 5, 5, 5);
        label.setBackgroundColor(Color.MAGENTA);
        LinearLayout Ll = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(label,params);
        tr.addView((View)Ll); // Adding textView to tablerow.

        /** Creating Qty Button **/
        TextView amount = new TextView(this);
        amount.setText("Amount");
        amount.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        amount.setPadding(5, 5, 5, 5);
        amount.setBackgroundColor(Color.MAGENTA);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(amount,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView date = new TextView(this);
        date.setText("Date");
        date.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        date.setPadding(5, 5, 5, 5);
        date.setBackgroundColor(Color.MAGENTA);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(date,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }

    public void addData() {

        addHeader();

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);

        /** Creating a TextView to add to the row **/
        label = new TextView(this);
        label.setText("REWE");
        label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        label.setPadding(5, 5, 5, 5);
        label.setBackgroundColor(Color.GRAY);
        LinearLayout Ll = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 2, 2, 2);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(label, params);
        tr.addView((View) Ll); // Adding textView to tablerow.

        /** Creating Qty Button **/
        TextView amount = new TextView(this);
        amount.setText("18,48");
        amount.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        amount.setPadding(5, 5, 5, 5);
        amount.setBackgroundColor(Color.GRAY);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 2, 2, 2);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(amount, params);
        tr.addView((View) Ll); // Adding textview to tablerow.

        TextView date = new TextView(this);
        date.setText("03.12.2015");
        date.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        date.setPadding(5, 5, 5, 5);
        date.setBackgroundColor(Color.GRAY);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 2, 2, 2);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(date, params);
        tr.addView((View) Ll); // Adding textview to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }
}
