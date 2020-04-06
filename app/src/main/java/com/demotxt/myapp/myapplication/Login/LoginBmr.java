package com.demotxt.myapp.myapplication.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.demotxt.myapp.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class LoginBmr extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private ImageView image;
    private int counter = 5;
    OkHttpClient client = new OkHttpClient();

    /*private final String GlobalVariables = "http://13.126.27.50/MHMS_DEV/user/";
    private final String GlobalVariablesRest = "http://13.126.27.50/MHMS_DEV/rest/";
    private final String CORS = "http://13.126.27.50";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_bmr);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("inside on click listener");

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        MHPFlow mhpFlow = new MHPFlow();
                        String information = null;
                        final String userName = ((EditText) findViewById(R.id.etName)).getText().toString();
                        final String password = ((EditText) findViewById(R.id.etPassword)).getText().toString();
                        System.out.println(userName+"     --------------------------     " +password);

                        String jwtToken = mhpFlow.login(userName, password);


                        try {
                            Log.e("try","inside LoginBmr try----------------------------------");
                            Log.e("JWT Token", jwtToken);
                            JSONObject jsonObjectbject = new JSONObject(jwtToken);
                            String token = jsonObjectbject.getString("token");
                            Log.e("Token", token);
                            JSONObject result = new JSONObject(MHPFlow.decoded(jwtToken));
                            Log.e("decoded String (result)", result.toString());
                            Log.e("getAssociatedOrg()",mhpFlow.getAssociatedOrg(token, result.getString("sessionToken")).toString());
                            JSONArray jsonArray = mhpFlow.getAssociatedOrg(token, result.getString("sessionToken"));
                            //System.out.println(jsonArray.getJSONObject(jsonArray.length()-1));
                            int cnt = 0;
                            ArrayList<String> list = new ArrayList<String>();
                            list.add("MHE/OP*");
                            while(cnt < jsonArray.length()){
                                JSONObject mheObject = jsonArray.getJSONObject(cnt);
                                list.add(mheObject.getString("name"));
                                cnt++;
                            }
                            Log.e("MHE list", list.toString());
                            Log.e("try", "outside LoginBmr try----------------------------------");
                            Intent intent = new Intent(LoginBmr.this, SelectMhe.class);
                            intent.putExtra("list", list);
                            LoginBmr.this.startActivity(intent);
                        }catch(Exception e){
                            e.printStackTrace();
                        }


                    }

                };
                new Thread(runnable).start();
            }
        });
    }

} //Login ends