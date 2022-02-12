package ie.wit.donationx.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import ie.wit.donationx.R
import ie.wit.donationx.databinding.ActivityDonateBinding

class Donate : AppCompatActivity() {

    private lateinit var binding: ActivityDonateBinding

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)}
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)}
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim)}

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.addBtn.setOnClickListener{
            onAddButtonClicked()

        }

        binding.editBtn.setOnClickListener { Toast.makeText(this, "Edit Button Clicked", Toast.LENGTH_SHORT).show() }

        binding.imageBtn.setOnClickListener { Toast.makeText(this, "Image Button Clicked", Toast.LENGTH_SHORT).show() }




    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked


    }

    private fun setAnimation(clicked: Boolean) {
        if(!clicked){
            binding.editBtn.visibility = View.VISIBLE
            binding.imageBtn.visibility = View.VISIBLE
        }
        else
        {
            binding.editBtn.visibility = View.INVISIBLE
            binding.imageBtn.visibility = View.INVISIBLE
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked)
        {
            binding.editBtn.startAnimation(fromBottom)
            binding.imageBtn.startAnimation(fromBottom)
            binding.addBtn.startAnimation(rotateOpen)
        }
        else
        {
            binding.editBtn.startAnimation(toBottom)
            binding.imageBtn.startAnimation(toBottom)
            binding.addBtn.startAnimation(rotateClose)
        }
    }
}


