package com.example.nihal.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView input,result;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAdd,btnSub,btnMul,btnDiv,btnClear,btnEqual;
    double val1,val2;
    boolean add,sub,mul,div,equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnClear = findViewById(R.id.btnClear);
        btnEqual = findViewById(R.id.btnEqual);
        btnMul = findViewById(R.id.btnMul);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnAdd = findViewById(R.id.btnAdd);
        input =findViewById(R.id.input);
        result=findViewById(R.id.result);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText()+"9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(input.getText().equals("")) {

                    Toast.makeText(MainActivity.this, "pls enter the values first", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "can be done ", Toast.LENGTH_SHORT).show();
                    val1 = Double.parseDouble(input.getText() + "");
                    add = true;
                    input.setText("");
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().equals("")) {

                    Toast.makeText(MainActivity.this, "pls enter the values first", Toast.LENGTH_SHORT).show();

                }else{

                val1 = Double.parseDouble(input.getText()+"");
                sub=true;
                input.setText(null);
                }


            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(input.getText().equals("")) {

                    Toast.makeText(MainActivity.this, "pls enter the values first", Toast.LENGTH_SHORT).show();

                }else {

                    val1 = Double.parseDouble(input.getText() + "");
                    mul = true;
                    input.setText(null);
                }

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().equals("")) {

                    Toast.makeText(MainActivity.this, "pls enter the values first", Toast.LENGTH_SHORT).show();

                }else {

                    val1 = Double.parseDouble(input.getText() + "");
                    div = true;
                    input.setText(null);
                }

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().equals("")) {

                    Toast.makeText(MainActivity.this, "pls enter the values first", Toast.LENGTH_SHORT).show();

                }else {
                    val2 = Double.parseDouble(input.getText() + "");


                /*switch (view.getId()){
                    case  R.id.btnAdd:
                        result.setText(val1 + val2+"");
                        break;
                    case  R.id.btnSub:
                        result.setText(val1 - val2+"");
                        break;
                    case  R.id.btnMul:
                        result.setText(val1 * val2+"");
                        break;
                    case  R.id.btnDiv:
                        result.setText(val1 / val2+"");
                        break;
                }*/

                    if (add == true) {
                        result.setText(val1 + val2 + "");
                        add = false;
                    } else if (sub == true) {
                        result.setText(val1 - val2 + "");
                        sub = false;
                    } else if (mul == true) {
                        result.setText(val1 * val2 + "");
                        mul = false;
                    } else if (div == true) {
                        result.setText(val1 / val2 + "");
                        div = false;
                    } else if (equal == true) {
                        result.setText("");
                        equal = false;
                    }

                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                input.setText("");
            }
        });
    }
}