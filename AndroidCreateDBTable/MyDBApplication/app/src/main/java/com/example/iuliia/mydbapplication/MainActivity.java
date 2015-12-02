package com.example.iuliia.mydbapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etInput;
    TextView txtText;
    Button btnAdd, btnDelete;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        etInput = (EditText)findViewById(R.id.etInput);
        txtText = (TextView)findViewById(R.id.txtText);

        dbHandler = new MyDBHandler(this);


        dbHandler.addUser(new Users("ich", "@mail", "123"));
        dbHandler.addUser(new Users("du", "@mail", "345"));
        //get all books
        //List<Users> list = dbHandler.getAllUsers();
        //get all books
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
