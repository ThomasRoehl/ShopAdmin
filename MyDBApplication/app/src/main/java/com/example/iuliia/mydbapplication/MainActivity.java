package com.example.iuliia.mydbapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etUsername, etEmail, etPassword1, etPassword2;
    TextView txtText;
    Button btnAdd, btnDelete;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.id_save);
        etUsername = (EditText)findViewById(R.id.id_username);
        etEmail= (EditText)findViewById(R.id.id_email);
        etPassword1 = (EditText)findViewById(R.id.id_password1);
        etPassword2 = (EditText)findViewById(R.id.id_password2);


        //txtText = (TextView)findViewById(R.id.txtText);

        dbHandler = new MyDBHandler(this);



            //Add a product to the databas



        Button record = (Button) findViewById(R.id.id_save);
        record.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userName = etUsername.getText().toString();
                String userEmail = etEmail.getText().toString();
                String userPassword1 = etPassword1.getText().toString();

                Users u = new Users(userName, userEmail, userPassword1);
                dbHandler.addUser(u);
                //startService(new Intent(MainActivity.this, SensorService.class));
            }
        });


//    Button record = (Button) findViewById(R.id.idRecord);
//    record.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View v) {
//            dataUnAcc = new ArrayList<String>();
//            dataCoAcc = new ArrayList<String>();
//            dataRot = new ArrayList<String>();
//            dataGyro = new ArrayList<String>();
//            dataGravity = new ArrayList<String>();
//            accuracy_accel = new ArrayList<String>();
//
//            filenameUnAcc = (""+((EditText)findViewById(R.id.idNameEingabe)).getText().toString().trim()+"UnAcc"+".csv");
//            filenameCoAcc = (""+ ((EditText)findViewById(R.id.idNameEingabe)).getText().toString().trim()+"CoAcc"+".csv");
//            filenameRot = (""+ ((EditText)findViewById(R.id.idNameEingabe)).getText().toString().trim()+"Ro"+".csv");
//            filenameGyro = (""+ ((EditText)findViewById(R.id.idNameEingabe)).getText().toString().trim()+"Gy"+".csv");
//            filenameGravity = (""+ ((EditText)findViewById(R.id.idNameEingabe)).getText().toString().trim()+"Gr"+".csv");
//            startService(new Intent(MainActivity.this,
//                    SensorService.class));
//
//        }
//    });


        //dbHandler.addUser(new Users("ich", "@mail", "123"));
        // dbHandler.addUser(new Users("du", "@mail", "345"));

        dbHandler.getAllUsers();


//        try {
//            printDatabase();
//        }catch (Exception e){
//            Log.i("exxxx", e.toString());
//        }

    }
//
//    public void printDatabase() {
//        String dbString = dbHandler.databaseToString();
//        txtText.setText(dbString);
//        etInput.setText("");
//    }

//    //Add a product to the database
//    public void addButtonClicked(View view){
//        Log.i("exxxx", "CLİCKED ADD BUTTON");
//        String user = etInput.getText().toString();
//        Users u = new Users(user);
//        dbHandler.addUser(u);
//        //printDatabase();
//    }

//    //Delete a product to the database
//    public void deleteButtonClicked(View view){
//        Log.i("exxxx", "CLİCKED DELETE BUTTON");
//        String inputText = etInput.getText().toString();
//        dbHandler.deleteProduct(inputText);
//        printDatabase();
//    }
}
