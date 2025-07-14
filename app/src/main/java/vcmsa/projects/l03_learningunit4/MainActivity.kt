package vcmsa.projects.l03_learningunit4

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.projects.l03_learningunit4.databinding.ActivityMainBinding
import vcmsa.projects.l03_learningunit4.databinding.ActivityMainWithNavDrawerBinding

//the View.OnClickListener we added on the ffg line and created its separate class at the bottom
class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Old method of getting view items
    // Declare your ImageViews as nullable
    private var imageOnePiece: ImageView? = null
    private var imageMaser: ImageView? = null
    private var imageColorfulBackground: ImageView? = null
    private var imageOip: ImageView? = null
    private var imageNoClue: ImageView? = null
    private var imageAddfjk: ImageView? = null
    private var imageCar1: ImageView? = null
    private var helloMsg: TextView? = null


    //this we write after adding the intents
    var order = Order()

    private lateinit var binding: ActivityMainWithNavDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        //Still part of old method
//        // Initialize your ImageViews using findViewById
//        imageOnePiece = findViewById(R.id.onepiece)
//        imageMaser = findViewById(R.id.maser)
//        imageColorfulBackground = findViewById(R.id.colorful_background)
//        imageOip = findViewById(R.id.oip)
//        imageNoClue = findViewById(R.id.noclue)
//        imageAddfjk = findViewById(R.id.addfjk)
//        imageCar1 = findViewById(R.id.car1)
//        helloMsg = findViewById(R.id.hellomsg)


        // Now you can use them
        // For example:
        imageOnePiece?.setImageResource(R.drawable.oip)
        helloMsg?.text = "Hello from old method!"

        //Using Viewbinding: New method
        val binding = ActivityMainWithNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        //This line of code overrides the xml file where the text is just "Hello World"
        binding.hellomsg.text = "Hello! From the view binding side"

        //Toast
//        //Short pop up messages like toastrs in MVC
//        //When maserati car image pops out then message is displayed
//        binding.maser.setOnClickListener{
//            Toast.makeText(this, "Maserati",Toast.LENGTH_LONG).show()
//        }
//
//
//        binding.colorfulBackground.setOnClickListener {
//            // 1️⃣ Show a hardcoded Toast message
//            Toast.makeText(this, "You clicked the colourful image!", Toast.LENGTH_SHORT).show()
//        }
//
//
//        binding.car1.setOnClickListener {
//            // 1️⃣ Show a hardcoded Toast message
//            Toast.makeText(this, "You clicked the car1 image!", Toast.LENGTH_SHORT).show()
//        }


        //instead of writing a toaster for each image, we pass all the images to the OnClickListener method with its id as a parameter (this)
        //thereafter we configure the method to show the toasters
        binding.maser.setOnClickListener(this)
        binding.colorfulBackground.setOnClickListener(this)
        binding.car1.setOnClickListener(this)
        binding.addfjk.setOnClickListener(this)
        binding.oip.setOnClickListener(this)
        binding.noclue.setOnClickListener(this)



        setSupportActionBar(binding.navToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        var toggleOnOff = ActionBarDrawerToggle(this,
            binding.drawerLayout, binding.navToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggleOnOff)
        toggleOnOff.syncState()

        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }

    //we created this method to avoid previous repetitive code
    override fun onClick(v: View){
        when(v?.id) {
            R.id.maser -> order.productName = "Maserati"
            R.id.colorful_background -> order.productName = "colourful background"
            R.id.car1 -> order.productName = "This is Car 1"
            R.id.addfjk -> order.productName = "Some random name here"
            R.id.noclue -> order.productName = "No Clue for some reason"
            R.id.oip -> order.productName = "One Piece"

        }
            Toast.makeText(this@MainActivity,"MMM " + order.productName,Toast.LENGTH_SHORT).show()
                    openIntent(applicationContext, order.productName,
                        OrderDetailsActivity::class.java)

        }
    }


