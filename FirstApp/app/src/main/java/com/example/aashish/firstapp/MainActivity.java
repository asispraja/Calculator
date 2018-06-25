package com.example.aashish.firstapp;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button badd,bsub,bmul,bdiv,bequal,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    Button bdot,bneg,bclear,bBrace,bPer;
    TextView res,subRes,fun;
    Double temp;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res= (TextView) findViewById(R.id.resultText);
        subRes= (TextView) findViewById(R.id.subResultText);
        bequal = (Button) findViewById(R.id.equalBtn);
        b0 = (Button) findViewById(R.id.btn0);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        bdot = (Button) findViewById(R.id.btnDot);
        bclear = (Button) findViewById(R.id.clearBtn);
        bneg = (Button) findViewById(R.id.btnNegative);
        bBrace = (Button) findViewById(R.id.braceBtn);
        bPer = (Button) findViewById(R.id.percentBtn);
        fun=(TextView)findViewById(R.id.func);
    }
    public void storeValue( View view)
    {
        double num1 = Double.parseDouble(res.getText().toString());
        subRes.setText(num1+"");
        res.setText("0");
        if(view.getId()==R.id.addBtn)
            fun.setText("+");
        else if(view.getId()==R.id.subBtn)
            fun.setText("-");
        else if(view.getId()==R.id.mulBtn)
            fun.setText("*");
        else if(view.getId()==R.id.divBtn)
            fun.setText("/");
        else if(view.getId()==R.id.percentBtn)
            fun.setText("%");
        else
        fun.setText("null");
    }
    public void number(View view)
    {
        String tem = res.getText().toString();
        if(tem.equals("0"))
            tem="";
        String temp1="";
        if(view.getId()==R.id.btn0)
             temp1=tem+"0";
        else if(view.getId()==R.id.btn1)
            temp1=tem+"1";
        else if(view.getId()==R.id.btn2)
            temp1=tem+"2";
        else if(view.getId()==R.id.btn3)
            temp1=tem+"3";
        else if(view.getId()==R.id.btn4)
            temp1=tem+"4";
        else if(view.getId()==R.id.btn5)
            temp1=tem+"5";
        else if(view.getId()==R.id.btn6)
            temp1=tem+"6";
        else if(view.getId()==R.id.btn7)
            temp1=tem+"7";
        else if(view.getId()==R.id.btn8)
            temp1=tem+"8";
        else if(view.getId()==R.id.btn9)
            temp1=tem+"9";
        else if(view.getId()==R.id.btnDot)
        {
            if(!temp1.contains(".")){
                temp1=tem+".";
            }
        }
        else
            temp1="null";
        res.setText(temp1);


    }
    public void equals(View view)
    {
        String val= fun.getText().toString();
        double main, submain,result=0;
        String myres;
        if(!subRes.getText().toString().equals("")) {
            main = Double.parseDouble(res.getText().toString());

            submain = Double.parseDouble(subRes.getText().toString());

            if (val == "+") {
                result = main + submain;
            } else if (val == "-") {
                result = submain - main;
            }
            if (val == "*") {
                result = main * submain;
            }
            if (val == "/") {
                result = main / submain;
            }
            if (val == "%") {
                result = submain * main / 100;
            }
            myres=result+"";
           int lens=myres.length()-1;
           if(myres.charAt(lens)=='0'&&myres.charAt(lens-1)=='.') {
              myres=myres.substring(0,lens-1);
           }

            res.setText(myres);
            subRes.setText("");
        }
    }
    public void clear(View view)
    {
        res.setText("0");
        subRes.setText("");
        fun.setText("");
    }
    public void negative(View view)
    {
        String temp1=res.getText().toString();
        temp1="-"+temp1;
        res.setText(temp1);
    }
public void brace(View view)
{
    String tem = res.getText().toString();

    if(tem.equals("0"))
        tem="";
    if(tem.contains("("))
    {
        tem=tem+")";

    }
    else {
        tem = tem + "(";

    }
    res.setText(tem+"");


}
public void back(View view)
{
    String tem = res.getText().toString();


        tem = tem.substring(0, tem.length() - 1);
        if(tem.equals(""))
            tem="0";
        res.setText(tem);
}

}

