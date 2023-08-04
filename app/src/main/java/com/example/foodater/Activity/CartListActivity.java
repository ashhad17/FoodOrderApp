package com.example.foodater.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.foodapplication.Adapter.CartListAdapter;
//import com.example.foodapplication.Helper.ManagementCart;
//import com.example.foodapplication.Interface.ChangeNumberItemListener;
//import com.example.foodapplication.R;
import com.example.foodater.Adapter.CartListAdapter;
import com.example.foodater.Domain.FoodDomain;
import com.example.foodater.Helper.CartManagement;
import com.example.foodater.Helper.EmailSender;
import com.example.foodater.Helper.MyDbHandler;
import com.example.foodater.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import papaya.in.sendmail.SendMail;

//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.activation.*;
//import javax.mail.Session;
//import javax.mail.Transport;
////import kotlin.io.LineReader;
//
//import com.example.foodapplication.R;

public class CartListActivity extends AppCompatActivity {
////    private TinyDB tinyDB;

private RecyclerView recyclerViewList;
private RecyclerView.Adapter adapter;
//private ManagementCart managementCart;
private TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt,checkOut;
//private
private ArrayList<FoodDomain> food;
private CartListAdapter cartListAdapter;
private CartManagement cartManagement;
ScrollView scrollView;
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(CartListActivity.this, MainActivity.class));
        finish();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
//        tax=findViewById(R.id.taxfees);
        System.out.println("CARTNULL"+getTotalFee());
        totalFeeTxt=findViewById(R.id.totalFees);
        taxTxt=findViewById(R.id.taxfees);
        deliveryTxt=findViewById(R.id.dfees);
        totalTxt=findViewById(R.id.total);
        emptyTxt=findViewById(R.id.emptyTxt);
        checkOut=findViewById(R.id.checkout);
        scrollView=findViewById(R.id.cartScrollView);

        recyclerViewList=findViewById(R.id.recyclerViewCart);
        recyclerViewList.setHasFixedSize(true);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
        food=new ArrayList<>();
        MyDbHandler db=new MyDbHandler(this);
        List<FoodDomain> foodList=db.getAllCart();
        for(FoodDomain foodDomain: foodList){
//            Log.d("dbharry", "\nId: " + food.getId() + "\n" +
//                    "Name: " + contact.getName() + "\n"+
//                    "Phone Number: " + contact.getPhoneNumber() + "\n" );
//            sb.append("\nID: "+contact.getId()).append("\nName: "+contact.getName()).append("\nNumber"+contact.getPhoneNumber());

            food.add(foodDomain);
        }
        cartListAdapter=new CartListAdapter(food,this);
        recyclerViewList.setAdapter(cartListAdapter);

        //        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        recyclerViewList.setLayoutManager(linearLayoutManager);
//        adapter=new CartListAdapter(food,this);
//
//        recyclerViewList.setAdapter(adapter);
        if(food.isEmpty()){
        emptyTxt.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        }
    else {
    emptyTxt.setVisibility(View.GONE);
    scrollView.setVisibility(View.VISIBLE);}
    checkOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getBaseContext(),"Order Placed We'll call you shortly for order Confermation",Toast.LENGTH_LONG).show();
//            EmailSender.sendEmail("asden7854@gmail.com","OrderDetails","Testing");
            addOrders();
            emptyTxt.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        }
    });

//        managementCart=new ManagementCart(this);
//        initView();
//        initList();
        CalculatorCart();
//        bottomNavigation();

//private void bottomNavigation(){
//    FloatingActionButton floatingActionButton=findViewById(R.id.cartbtn);
//    LinearLayout homebtn=findViewById(R.id.homeBtn);
//    floatingActionButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            startActivity(new Intent(getBaseContext(),CartListActivity.class));
//        }
//    });
//    homebtn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            startActivity(new Intent(getBaseContext(),MainActivity.class));
//        }
//    });
//}

//    private void initView() {
//        recyclerViewList=findViewById(R.id.recyclerViewCart);
//        totalFeeTxt=findViewById(R.id.totalFees);
//        taxTxt=findViewById(R.id.taxfees);
//        deliveryTxt=findViewById(R.id.dfees);
//        totalTxt=findViewById(R.id.total);
//        emptyTxt=findViewById(R.id.emptyTxt);
//        scrollView=findViewById(R.id.cartScrollView);
//        checkOut=findViewById(R.id.checkout);
//
////        recyclerViewList=findViewById(R.id.recyclerViewCart);
//    }
//
//    private void initList(){
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        recyclerViewList.setLayoutManager(linearLayoutManager);
////adapter=new CartListAdapter(managementCart.getListCart(),this, new ChangeNumberItemListener() {
//    @Override
//    public void changed() {
//        CalculatorCart();
//    }
//});
//recyclerViewList.setAdapter(adapter);
//if(cartManagement.getListCart().isEmpty()){
//    emptyTxt.setVisibility(View.VISIBLE);
//    scrollView.setVisibility(View.GONE);
//}
//else {
//    emptyTxt.setVisibility(View.GONE);
//    scrollView.setVisibility(View.VISIBLE);
//}
//checkOut.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Toast.makeText(getBaseContext(),"Order Placed We'll call you shortly for order Confermation",Toast.LENGTH_LONG).show();
//        emptyTxt.setVisibility(View.VISIBLE);
//        scrollView.setVisibility(View.GONE);
////        ArrayList<FoodDomain> listFood=new ArrayList<>();
////        listFood.clear();
////        tinyDB.putListObject("CartList",listFood);
//
//    }
//});
    }

    private void sendEmail() {
        SendMail mail = new SendMail("foodaterapplication@gmail.com", "Foodater@123",
                "asden7854@gmail.com",
                "Testing Email Sending",
                "Yes, it's working well\nI will use it always.");
        mail.execute();
    }

//    private void sendEmail() {
//        // email ID of Recipient.
//        String recipient = "20cs047@cittumkur.org";
//
//        // email ID of Sender.
//        String sender = "asden7854@gmail.com";
//
//        // using host as localhost
//        String host = "127.0.0.1";
//
//        // Getting system properties
//        Properties properties = System.getProperties();
//
//        // Setting up mail server
//        properties.setProperty("mail.smtp.host", host);
//
//        // creating session object to get properties
//        Session session = Session.getDefaultInstance(properties);
//
//        try
//        {
//            // MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From Field: adding senders email to from field.
//            message.setFrom(new InternetAddress(sender));
//
//            // Set To Field: adding recipient's email to from field.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//
//            // Set Subject: subject of the email
//            message.setSubject("This is Subject");
//
//            // set body of the email.
//            message.setText("This is a test mail");
//
//            // Send email.
//            Transport.send(message);
//            System.out.println("Mail successfully sent");
//        }
//        catch (MessagingException mex)
//        {
//            mex.printStackTrace();
//        }
//
//    }

    public void addOrders()
    {
        MyDbHandler db=new MyDbHandler(this);
        List<FoodDomain> foodList=db.getAllCart();
        FoodDomain foodDomain= new FoodDomain();
        for(int i=0;i<foodList.size();i++)
        {
            foodDomain.setId(foodList.get(i).getId());
            foodDomain.setTitle(foodList.get(i).getTitle());
            foodDomain.setFee(foodList.get(i).getFee());
            foodDomain.setPic(foodList.get(i).getPic());
            db.addOrders(foodDomain);
        }
        System.out.println("Message Sucess Inserted");
        db.deleteCartFull();
        db.close();

    }

   public void CalculatorCart(){
        MainActivity m=new MainActivity();
        double tax;
        double percentTax=0.18;
        double delivery=100.0;
//        double t=cartManagement.getTotalFee();
//        System.out.println("Toota;"+t);
        tax=Math.round((getTotalFee()*percentTax)*100)/100.0;
        double total=Math.round((getTotalFee()+tax+delivery)*100)/100.0;
        double itemtotal=Math.round(getTotalFee()*100)/100.0;
        totalTxt.setText("Rs."+itemtotal);
        tax=Math.round((getTotalFee()*percentTax)*100)/100.0;
//        System.out.println("totalFees"+cartManagement.getTotalFee());
        taxTxt.setText("Rs."+tax);
        deliveryTxt.setText("Rs."+delivery);
        totalFeeTxt.setText("Rs."+total);
    }
    public double getTotalFee(){
        MyDbHandler db=new MyDbHandler(this);
        List<FoodDomain> listFood=db.getAllCart();
        double fee=0;
        for(int i=0;i<listFood.size();i++)
        {
//        System.out.println("Sout"+listFood.get(0).getFee()*listFood.get(0).getNumberInCart());
            fee=fee+(listFood.get(i).getFee() *listFood.get(i).getNumberInCart());
        }
        return fee;
    }
    public void orders(View v){
        startActivity(new Intent(v.getContext(),OrdersActivity.class));
//       startActivity(new Intent(getBaseContext(),OrdersActivity.class));
    }
    public void about(View v){
//        startActivity(new Intent(MainActivity.this,AboutActivity.class));
        startActivity(new Intent(v.getContext(),AboutActivity.class));
    }
    public void contact(View v){

//        startActivity(new Intent(MainActivity.this,ContactActivity.class));
        startActivity(new Intent(v.getContext(),ContactActivity.class));
    }
    public void home(View v){

        startActivity(new Intent(v.getContext(),MainActivity.class));

    }
    public void cart(View v){

        startActivity(new Intent(v.getContext(),CartListActivity.class));

    }
}