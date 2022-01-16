package isetb.pidev.projetpidev;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InscriptionActivity extends AppCompatActivity {
    EditText t1 , t2 ,t3,t4 ,t5;
    Button b1 , b2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscri);
        t1=findViewById(R.id.nom);
        t2=findViewById(R.id.edit_email);
        t3=findViewById(R.id.password);
        t4=findViewById(R.id.confirm_password);
        b1=findViewById(R.id.inscrire);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("MyInfo", MODE_PRIVATE) ;
                SharedPreferences.Editor esp=  sp.edit();

                String np = t1.getText().toString() ;
                esp.putString("nom",np);

                String em = t2.getText().toString() ;
                esp.putString("email",em);

                String pw = t3.getText().toString() ;
                esp.putString("mot de passe",pw);

                String confmot = t4.getText().toString() ;
                if (pw.equals(confmot)){
                    esp.commit();
                    Intent intent = new Intent(InscriptionActivity.this, LoginActivity.class);
                    startActivity(intent);

                }else
                    Toast.makeText(InscriptionActivity.this , "password non confirme", Toast.LENGTH_SHORT).show();

            }

        });
    }
}