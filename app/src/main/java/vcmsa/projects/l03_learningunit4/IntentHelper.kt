package vcmsa.projects.l03_learningunit4

import android.content.Context
import android.content.Intent
import android.os.Bundle

//Explicit Intent
fun openIntent(context: Context, order: String, activityToOpen: Class<*>){

    //Declare intent with context and class to pass the value to
    val intent = Intent(context, activityToOpen)

    //pass through the string value with key "order"
    intent.putExtra("order",order)

    //if context is not an activity, add FLAG_ACTIVITY_NEW_TASK
    if (context !is android.app.Activity){
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }

    //start the activity
    context.startActivity(intent)

}


//Implicit Intent
fun shareIntent(context: Context, order: String) {

    val sendIntent = Intent()

    //Set the action to indicate what to do - sned in this case
    sendIntent.action = Intent.ACTION_SEND
    sendIntent.putExtra(Intent.EXTRA_TEXT, order)

    //we are sending plain text
    sendIntent.type = "text/plain"

    //Show the share sheet
    val shareIntent = Intent.createChooser(sendIntent, null)

    //if context is not an activity, add FLAG-ACTIVITY_NEW_TASK
    if (context !is android.app.Activity){
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(shareIntent)

}

//Overloaded shareIntent method()
fun shareIntent(context: Context, order: Order) {

    val sendIntent = Intent()
    sendIntent.action = Intent.ACTION_SEND

    //Create a bundle and add multiple values to it
    val shareOrderDetails = Bundle()
    shareOrderDetails.putString("productName", order.productName)
    shareOrderDetails.putString("customerName", order.customerName)
    shareOrderDetails.putString("customerCell", order.customerCell)

//share the whole bundle
sendIntent.putExtra(Intent.EXTRA_TEXT,shareOrderDetails)
sendIntent.type = "text/plain"

    val shareIntent = Intent.createChooser(sendIntent, null)

    //if context is not an activity, add FLAG_ACTIVITY_NEW_TASK
    if(context !is android.app.Activity){
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(shareIntent)
}