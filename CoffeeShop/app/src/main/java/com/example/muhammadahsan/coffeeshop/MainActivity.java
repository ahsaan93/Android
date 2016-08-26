package com.example.muhammadahsan.coffeeshop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //global variables
    int price = 0;
    int qty = 0;
    String tPrice;

    boolean addWhippedCream=false;
    boolean addChoclate=false;
    String name=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //taking coffee price from strings
        price=Integer.parseInt(getString(R.string.coffee_rate));

        TextView qt = (TextView) findViewById(R.id.textView_qty);
        qty=Integer.parseInt(qt.getText().toString());
        totalPrice();

/*        Button sentEmail= (Button) findViewById(R.id.button_order);
        sentEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEmail=new Intent(Intent.ACTION_SENDTO);
                intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"m.ahsaan93@gmail.com"});
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order");
                intentEmail.putExtra(Intent.EXTRA_TEXT, "Order Summary\n\nName : "+name+"\nWhipped Creame : "+addWhippedCream+"\nChoclate : "+addChoclate+"\nQuantity : "+qty+"\nTotal : "+tPrice+"\nThank You!");
                intentEmail.setType("message/rfc822");
                startActivity(intentEmail);
            }
        });*/
    }

    public void addWhipped(View view){
        boolean selection = ((CheckBox) view).isChecked();
        if (selection){
            addWhippedCream=true;
            TextView additional = (TextView) findViewById(R.id.textView_additionalWhippedPrice);
            additional.setText("+"+getString(R.string.whippedCream_rate)+" $");
        }
        else{
            addWhippedCream=false;
            TextView additional = (TextView) findViewById(R.id.textView_additionalWhippedPrice);
            additional.setText("");
        }
    }
    public void addChoclate(View view){
        boolean selection = ((CheckBox) view).isChecked();
        if (selection){
            addChoclate=true;
            TextView additional = (TextView) findViewById(R.id.textView_additionalChoclatePrice);
            additional.setText("+"+getString(R.string.choclate_rate)+" $");
        }
        else{
            addChoclate=false;
            TextView additional = (TextView) findViewById(R.id.textView_additionalChoclatePrice);
            additional.setText("");
        }
    }
    public void basePrice(boolean whipped, boolean choclate){

        price=Integer.parseInt(getString(R.string.coffee_rate));

        if (whipped){
            price=price+Integer.parseInt(getString(R.string.whippedCream_rate));
        }
        if (choclate){
            price=price+Integer.parseInt(getString(R.string.choclate_rate));
        }
    }
    public void totalPrice(){
        basePrice(addWhippedCream,addChoclate);
        tPrice=String.valueOf(qty * price)+ " $";
        order();
    }
    public void qty_increament(View view){
        TextView qt = (TextView) findViewById(R.id.textView_qty);
        qty=Integer.parseInt(qt.getText().toString());
        qty=qty+1;
        qt.setText(String.valueOf(qty));
        totalPrice();
    }
    public void qty_decreament(View view){
        TextView qt = (TextView) findViewById(R.id.textView_qty);
        qty=Integer.parseInt(qt.getText().toString());
        if(qty<1){
            qty=1;
            qt.setText(String.valueOf(qty));
        }
        else if(qty>0 && qty<2) {
            totalPrice();
            Toast.makeText(this, "Quantity must be atleast 1", Toast.LENGTH_SHORT).show();
        }
        else if (qty>1) {
            qty = qty - 1;
            qt.setText(String.valueOf(qty));
        }
        totalPrice();
    }

    public void order(){
            TextView orderSumm = (TextView) findViewById(R.id.textView_orderSummary);
        orderSumm.setText("Order Summary\n\nName : "+name+"\nWhipped Creame : "+addWhippedCream+"\nChoclate : "+addChoclate+"\nQuantity : "+qty+"\nTotal : "+tPrice);
        }

    public void composeEmail(View view) {
        EditText userName = (EditText) findViewById(R.id.editText_userName);
        name = userName.getText().toString();
        if (name.length() < 1){
            Toast.makeText(this, "User Name cannot leave empty", Toast.LENGTH_SHORT).show();
        }
        else{
            totalPrice();
            TextView orderSumm = (TextView) findViewById(R.id.textView_orderSummary);
            orderSumm.setText("Order Summary\n\nName : "+name+"\nWhipped Creame : "+addWhippedCream+"\nChoclate : "+addChoclate+"\nQuantity : "+qty+"\nTotal : "+tPrice);


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"+"m.ahsaan93@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order");
            intent.putExtra(Intent.EXTRA_TEXT, "Order Summary\n\nName : "+name+"\nWhipped Creame : "+addWhippedCream+"\nChoclate : "+addChoclate+"\nQuantity : "+qty+"\nTotal : "+tPrice+"\n\nThank You!"+"\n\nBest Regards,\n"+getString(R.string.shop_name));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    }

}
