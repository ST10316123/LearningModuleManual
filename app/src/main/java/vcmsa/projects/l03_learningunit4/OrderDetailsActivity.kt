package vcmsa.projects.l03_learningunit4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.projects.l03_learningunit4.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    var order = Order()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_order_details)

        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get the name of the ordered product from the intent
        order.productName = intent.getStringExtra("order").toString()

        //set the product name on the text view
        binding.tvPlacedOrder.text = order.productName

        when(order.productName){
            "Maserati" -> binding.imgOrderedBeverage.setImageResource(R.drawable.maser)
            "colourful background" -> binding.imgOrderedBeverage.setImageResource(R.drawable.colorful_background)
            "This is Car 1" -> binding.imgOrderedBeverage.setImageResource(R.drawable.car1)
            "Some random name here" -> binding.imgOrderedBeverage.setImageResource(R.drawable.addfjk)
            "No Clue for some reason" -> binding.imgOrderedBeverage.setImageResource(R.drawable.noclue)
            "One Piece" -> binding.imgOrderedBeverage.setImageResource(R.drawable.oip)


        }

        binding.fabOrder.setOnClickListener(){
            shareIntent(applicationContext, order.productName)
        }


        }
    }
